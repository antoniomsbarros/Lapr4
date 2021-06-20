package eapli.validateForm;

import eapli.base.ordermanagement.domain.Attribute;

import java.util.ArrayList;
import java.util.List;

public class MyVisitor extends linguagemFormBaseVisitor{

    private List<Attribute> requestAttribute;
    private List<String> requestData;
    private List<String> errors;
    private Boolean error = false;

    public MyVisitor(List<Attribute> requestAttribute,List<String> requestData){
        this.requestAttribute = requestAttribute;
        this.requestData = requestData;
    }


    @Override
    public Boolean visitStart(linguagemFormParser.StartContext ctx) {
        try {
            if (ctx.start() != null) {
                if ((Boolean) this.visit(ctx.start()) != true) {
                    return true;
                }
            }
            errors = new ArrayList<>();

            if (ctx.statement_verification().if_func() != null || ctx.statement_verification() != null) {
                if (!((Boolean) this.visit(ctx.statement_verification().if_func())) ||
                        !((Boolean) this.visit(ctx.start().statement_verification()))) {
                    for (String s : errors) {
                        System.out.println("Erro: " + s);
                    }
                    error = true;
                    return false;
                }
            }

            if (ctx.statement_configuration().config() != null || ctx.statement_configuration() != null) {
                if (!((Boolean) this.visit(ctx.statement_configuration().config())) ||
                        !((Boolean) this.visit(ctx.statement_verification()))) {
                    for (String s : errors) {
                        System.out.println("Erro: " + s);
                    }
                    error = true;
                    return false;
                }
            }
            return !error;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override public Boolean visitIf_func(linguagemFormParser.If_funcContext ctx) {
        try{
            if (!(Boolean)this.visit(ctx.conditions())){
                return true;
            }
            linguagemFormParser.ContentContext valueContent = ctx.content();
            Object evaluated = null;
            Boolean verify = true;
            do{
                if (valueContent.ctntconditions()!=null){
                    evaluated = this.visit(valueContent.ctntconditions().conditions());
                    if ((Boolean) evaluated == false){
                        verify = false;
                    }
                }
                if (valueContent.config()!=null){
                    evaluated = this.visit(valueContent.config());
                    if ((Boolean) evaluated == false){
                        verify = false;
                    }
                }
                valueContent = valueContent.content();
            }while(valueContent!=null);
            return verify;

        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override public Boolean visitContent(linguagemFormParser.ContentContext ctx) {
        try{
            if (!(Boolean)this.visit(ctx.content())){
                return true;
            }
            linguagemFormParser.ContentContext contentContext = ctx.content();
            Object evaluated = null;
            Boolean verify = true;

            do{
                if (contentContext.content()!=null) {
                    if (contentContext.content().ctntconditions() != null) {
                        evaluated = this.visit(contentContext.content().ctntconditions());  //content: content ctntconditions
                        if ((Boolean) evaluated == false) {
                            verify = false;
                        }
                    }
                } else if (contentContext.content().config()!=null){
                    evaluated = this.visit(contentContext.content().config());  //content: content config
                    if ((Boolean) evaluated == false) {
                        verify = false;
                    }
                }else if(contentContext.content().if_func()!= null){
                    evaluated = this.visit(contentContext.content().if_func());  //content: content if_func
                    if ((Boolean) evaluated == false) {
                        verify = false;
                    }
                } else if (contentContext.ctntconditions()!= null){
                    evaluated = this.visit(contentContext.ctntconditions());  //content: ctntconditions
                    if ((Boolean) evaluated == false) {
                        verify = false;
                    }
                }else if(contentContext.config()!=null){
                    evaluated = this.visit(contentContext.config());  //content: content ctntconditions
                    if ((Boolean) evaluated == false) {
                        verify = false;
                    }
                }else{
                    evaluated = this.visit(contentContext.if_func());  //content: content ctntconditions
                    if ((Boolean) evaluated == false) {
                        verify = false;
                    }
                }
                contentContext = contentContext.content();
            }while(contentContext!= null);
            return verify;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override public Boolean visitValSize(linguagemFormParser.ValSizeContext ctx) {
        String val = requestData.get(Integer.parseInt(ctx.INTEGER().get(0).toString())-1); // "1-x"
        int size = Integer.parseInt(ctx.INTEGER().get(1).toString());

        try{
            if (val.length() == size){
                return true;
            }
            String err = "O tamanho de "+val+" não é "+size+"!\n";
            errors.add(err);
            return false;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
     }


    @Override public Boolean visitValBetween(linguagemFormParser.ValBetweenContext ctx) {
        try{
           int aux = Integer.parseInt(ctx.INTEGER().toString())-1;
           int val = Integer.parseInt(requestData.get(aux));
           int valBetween1 = Integer.parseInt((ctx.gap().INTEGER().get(0).toString()));
           int valBetween2 = Integer.parseInt((ctx.gap().INTEGER().get(1).toString()));

           if (val>= valBetween1 && val<=valBetween2){
               return true;
           }
            String err = "O valor "+val+ " nao está entre  "+valBetween1+" e "+valBetween2+"!\n";
            errors.add(err);
            return false;
        }catch(Exception e){
        e.printStackTrace();
        System.out.println(e.getMessage());
        return false;
        }
    }
    @Override public Boolean visitValObligatory(linguagemFormParser.ValObligatoryContext ctx) {
        try {
            String value = requestData.get(Integer.parseInt(ctx.INTEGER().toString()) - 1);
            String mandatory = ctx.OBLIGATION().getText();

            if (mandatory.equalsIgnoreCase("obligatory")) {
                if (value.isBlank()) {
                    Attribute attrb = requestAttribute.get(Integer.parseInt(ctx.INTEGER().toString())-1);
                    String err ="Nao preencheu o atributo : (OBRIGATORIO)\n"+attrb.printForm()+"\n";
                    errors.add(err);
                    return false;
                }
                return true;
            } else { //not obligatory field to fill!
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override public Boolean visitConditionsNoOp(linguagemFormParser.ConditionsNoOpContext ctx) {
        try{
            return (Boolean) this.visit(ctx.condition());
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override public Boolean visitConditionsOp(linguagemFormParser.ConditionsOpContext ctx) {
        try{
            Object conditionsEvaluated= null;
            Boolean verify = false;

            linguagemFormParser.ConditionsContext conditionsContext = ctx.conditions();
            do{
                conditionsEvaluated = this.visit(conditionsContext);
               if (!((Boolean) this.visit((conditionsContext)))){
                   return false;
               }
            }while(ctx.conditions() != null);

            String op = ctx.CONDITION_OP().toString();

            Object conditionEvaluated = this.visit(ctx.condition());

            switch(op){
                case "&&":
                    if ((Boolean)conditionsEvaluated && (Boolean)conditionEvaluated){
                        return true;
                    } else {
                    return false;
                    }
                case "||":
                    if ((Boolean)conditionsEvaluated || (Boolean)conditionEvaluated){
                        return true;
                    } else{
                        return false;
                    }

                default:
                    return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override public Boolean visitValueVerifyVerifyOrEqualOrNot(linguagemFormParser.ValueVerifyVerifyOrEqualOrNotContext ctx) {
      try{
          float value = Float.parseFloat(requestData.get(Integer.parseInt(ctx.INTEGER().toString())-1));
          float calc = visitIntExpression(ctx.intExpression()); // calculo de valores com valores de verificacao (+,-,/,*,%)

          if (calc == 0.0f){
              System.out.println("Erro de calculo!");
              return false;
          }

          if (ctx.EQUAL_OR_NOT() == null && ctx.VERIFICATION_OP()!= null){
              String op = ctx.VERIFICATION_OP().toString();
              Attribute attrb = requestAttribute.get(Integer.parseInt(ctx.INTEGER().toString())-1);
              String errMenor =  "O atributo "+ attrb.printForm() + "é menor que "+calc;
              String errMaior =  "O atributo "+ attrb.printForm() + "é maior que "+calc;
              String errMaiorIgual =  "O atributo "+ attrb.printForm() + "é maior-igual que "+calc;
              String errMenorIgual =  "O atributo "+ attrb.printForm() + "é menor-igual que "+calc;
              switch(op){
                  case ">":
                      if (value > calc){
                       return true;
                      }
                      errors.add(errMaior);
                      return false;
                  case "<":
                      if (value < calc){
                          return true;
                      }
                      errors.add(errMenor);
                      return false;
                  case "<=":
                      if (value <= calc){
                          return true;
                      }
                      errors.add(errMenorIgual);
                      return false;
                  case ">=":
                      if (value >= calc){
                          return true;
                      }
                      errors.add(errMaiorIgual);
                      return false;
                  default:
                      return false;
              }
          } else if(ctx.EQUAL_OR_NOT() != null && ctx.VERIFICATION_OP()==null) {
                String op = ctx.EQUAL_OR_NOT().toString();
                Attribute attrb = requestAttribute.get(Integer.parseInt(ctx.INTEGER().toString())-1);
                String errIgual =  "O atributo "+ attrb.printForm() + "é igualr a "+calc;
                String errDiferente =  "O atributo "+ attrb.printForm() + "é diferente de "+calc;

                switch(op){
                    case"==":
                        if (value == calc){
                            return true;
                        }
                        errors.add(errIgual);
                        return false;
                    case"!=":
                        if (value != calc){
                            return true;
                        }
                        errors.add(errDiferente);
                        return false;
                    default:
                        return false;
                }
          } else {
              return false;
          }
      }catch(Exception e){
          e.printStackTrace();
          System.out.println(e.getMessage());
          return false;
      }
    }
    @Override public Boolean visitValState(linguagemFormParser.ValStateContext ctx) {
        try{
            String val = requestData.get(Integer.parseInt(ctx.INTEGER().toString())-1);
            String state = ctx.STR_STATE().toString();

            Attribute attrb = requestAttribute.get(Integer.parseInt(ctx.INTEGER().toString())-1);
            String err= "Nao preencheu o atributo : (OBRIGATORIO)\n"+ attrb.printForm()+"\n";

        if (state.equalsIgnoreCase("filled")) {
            if (val.isBlank()) {
                errors.add(err);
                return false;
            }
            return true;
        }

        if (state.equalsIgnoreCase("empty")) {
            if (val.isBlank()) {
                return true;
            }
            errors.add(err);
            return false;
        }
                return false;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override public Boolean visitValEqualString(linguagemFormParser.ValEqualStringContext ctx) {
        try{
            String val = requestData.get(Integer.parseInt(ctx.INTEGER().toString())-1);
            StringBuilder aux = new StringBuilder();

            linguagemFormParser.StringValueContext stringValueContext = ctx.stringCondition()  //'ola'-> funciona     ola -> ardeu
                    .stringWithQuoteMarks().stringValue();

            do{
                aux.append(stringValueContext.STRING().toString()).append(" ");
                stringValueContext = stringValueContext.stringValue();
            }while(stringValueContext!=null);

            String valToEqualize = aux.toString();
            valToEqualize.replace("\"","");

            String op = ctx.EQUAL_OR_NOT().toString();
            Attribute attrb = requestAttribute.get(Integer.parseInt(ctx.INTEGER().toString())-1);
            String err1= "O atributo"+ attrb.printForm()+ "deveria de ser "+ valToEqualize+"\n";
            String err2 = "O atributo "+attrb.printForm()+"nao pode ser "+ valToEqualize+"\n";

            switch(op){
                case "==":
                    if (val.trim().equalsIgnoreCase((valToEqualize.trim()))){
                        return true;
                    }
                    errors.add(err1);
                    return false;

                case "!=":
                    if (val.trim().equalsIgnoreCase(valToEqualize.trim())){
                        return true;
                    }
                    errors.add(err2);
                    return false;

                default:
                    return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override public Boolean visitValIsBoolean(linguagemFormParser.ValIsBooleanContext ctx) {
        try{
            String value = requestData.get(Integer.parseInt(ctx.INTEGER().toString())-1);
            String op = ctx.EQUAL_OR_NOT().toString();
            String bol = ctx.BOOLEAN_OP().toString();

            Attribute attrb = requestAttribute.get(Integer.parseInt(ctx.INTEGER().toString())-1);
            String err= "O atributo "+ attrb.printForm() + "nao corresponde a: "+bol;

            switch(op){
                case "==":
                    if (value.equals(bol)){
                        return true;
                    }
                    errors.add(err);
                    return false;

                case "!=":
                    if (!value.equals(bol)){
                        return true;
                    }
                    errors.add(err);
                    return false;

                default:
                    return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override public Boolean visitBooleanIsVal(linguagemFormParser.BooleanIsValContext ctx) {
        try{
            String value = requestData.get(Integer.parseInt(ctx.INTEGER().toString())-1);
            String op = ctx.EQUAL_OR_NOT().toString();
            String bol = ctx.BOOLEAN_OP().toString();

            Attribute attrb = requestAttribute.get(Integer.parseInt(ctx.INTEGER().toString())-1);
            String err= " "+ bol + "nao corresponde ao atributo: "+attrb.printForm();

            switch(op){
                case "==":
                    if (value.equals(bol)){
                        return true;
                    }
                    errors.add(err);
                    return false;

                case "!=":
                    if (!value.equals(bol)){
                        return true;
                    }
                    errors.add(err);
                    return false;

                default:
                    return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }


    @Override public Float visitIntExpression(linguagemFormParser.IntExpressionContext ctx) {
        try{
            String mathOperator = ctx.MATH_OP().toString();
            float a = Float.parseFloat(ctx.intValue().INTEGER().toString());

            if (ctx.intExpression().intExpression() == null){ // intExpression = intValue
                float b = Float.parseFloat(ctx.intExpression().toString());
                switch(mathOperator){
                    case "+":
                        return a + b;
                    case "-":
                        return a - b;
                    case "*":
                        return a * b;
                    case "/":
                        return a / b;
                    case "%":
                        return a % b;
                    default:
                        return 0.0f;
                }
            } else {
                float b = visitIntExpression(ctx.intExpression());
                switch(mathOperator){
                    case "+":
                        return a + b;
                    case "-":
                        return a - b;
                    case "*":
                        return a * b;
                    case "/":
                        return a / b;
                    case "%":
                        return a % b;
                    default:
                        return 0.0f;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return 0.0f;
        }
    }

    @Override
    public Boolean visitValBetween(linguagemFormParser.ValBetweenContext ctx) {
        try{
            int aux = Integer.parseInt(ctx.INTEGER().toString())-1;
            int val = Integer.parseInt(requestData.get(aux));
            int valBetween1 = Integer.parseInt((ctx.gap().INTEGER().get(0).toString()));
            int valBetween2 = Integer.parseInt((ctx.gap().INTEGER().get(1).toString()));

            if (val>= valBetween1 && val<=valBetween2){
                return true;
            }
            String err = "O valor "+val+ " nao está entre  "+valBetween1+" e "+valBetween2+"!\n";
            errors.add(err);
            return false;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override
    public Boolean visitValObligatory(linguagemFormParser.ValObligatoryContext ctx) {
        try {
            String value = requestData.get(Integer.parseInt(ctx.INTEGER().toString()) - 1);
            String mandatory = ctx.OBLIGATION().getText();

            if (mandatory.equalsIgnoreCase("obligatory")) {
                if (value.isBlank()) {
                    Attribute attrb = requestAttribute.get(Integer.parseInt(ctx.INTEGER().toString())-1);
                    String err ="Nao preencheu o atributo : (OBRIGATORIO)\n"+attrb.printForm()+"\n";
                    errors.add(err);
                    return false;
                }
                return true;
            } else { //not obligatory field to fill!
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override
    public Boolean visitConditionsNoOp(linguagemFormParser.ConditionsNoOpContext ctx) {
        try{
            return (Boolean) this.visit(ctx.condition());
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override
    public Boolean visitConditionsOp(linguagemFormParser.ConditionsOpContext ctx) {
        try{
            Object conditionsEvaluated= null;
            Boolean verify = false;

            linguagemFormParser.ConditionsContext conditionsContext = ctx.conditions();
            do{
                conditionsEvaluated = this.visit(conditionsContext);
                if (!((Boolean) this.visit((conditionsContext)))){
                    return false;
                }
            }while(ctx.conditions() != null);

            String op = ctx.CONDITION_OP().toString();

            Object conditionEvaluated = this.visit(ctx.condition());

            switch(op){
                case "&&":
                    if ((Boolean)conditionsEvaluated && (Boolean)conditionEvaluated){
                        return true;
                    } else {
                        return false;
                    }
                case "||":
                    if ((Boolean)conditionsEvaluated || (Boolean)conditionEvaluated){
                        return true;
                    } else{
                        return false;
                    }

                default:
                    return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override
    public Boolean visitValueVerifyVerifyOrEqualOrNot(linguagemFormParser.ValueVerifyVerifyOrEqualOrNotContext ctx) {
        try{
            float value = Float.parseFloat(requestData.get(Integer.parseInt(ctx.INTEGER().toString())-1));
            float calc = visitIntExpression(ctx.intExpression()); // calculo de valores com valores de verificacao (+,-,/,*,%)

            if (calc == 0.0f){
                System.out.println("Erro de calculo!");
                return false;
            }

            if (ctx.EQUAL_OR_NOT() == null && ctx.VERIFICATION_OP()!= null){
                String op = ctx.VERIFICATION_OP().toString();
                Attribute attrb = requestAttribute.get(Integer.parseInt(ctx.INTEGER().toString())-1);
                String errMenor =  "O atributo "+ attrb.printForm() + "é menor que "+calc;
                String errMaior =  "O atributo "+ attrb.printForm() + "é maior que "+calc;
                String errMaiorIgual =  "O atributo "+ attrb.printForm() + "é maior-igual que "+calc;
                String errMenorIgual =  "O atributo "+ attrb.printForm() + "é menor-igual que "+calc;
                switch(op){
                    case ">":
                        if (value > calc){
                            return true;
                        }
                        errors.add(errMaior);
                        return false;
                    case "<":
                        if (value < calc){
                            return true;
                        }
                        errors.add(errMenor);
                        return false;
                    case "<=":
                        if (value <= calc){
                            return true;
                        }
                        errors.add(errMenorIgual);
                        return false;
                    case ">=":
                        if (value >= calc){
                            return true;
                        }
                        errors.add(errMaiorIgual);
                        return false;
                    default:
                        return false;
                }
            } else if(ctx.EQUAL_OR_NOT() != null && ctx.VERIFICATION_OP()==null) {
                String op = ctx.EQUAL_OR_NOT().toString();
                Attribute attrb = requestAttribute.get(Integer.parseInt(ctx.INTEGER().toString())-1);
                String errIgual =  "O atributo "+ attrb.printForm() + "é igualr a "+calc;
                String errDiferente =  "O atributo "+ attrb.printForm() + "é diferente de "+calc;

                switch(op){
                    case"==":
                        if (value == calc){
                            return true;
                        }
                        errors.add(errIgual);
                        return false;
                    case"!=":
                        if (value != calc){
                            return true;
                        }
                        errors.add(errDiferente);
                        return false;
                    default:
                        return false;
                }
            } else {
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

}



