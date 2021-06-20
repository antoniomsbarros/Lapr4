package eapli.base.AutomaticTaskExecution;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
/*
public class Visitor extends linguagemBaseVisitor {
    /*** memory to save variable/value pairs *//*
    Map<String, Double> memory = new HashMap<>();

    /**
     * codigo+ # codigoParser
     * @return
     *//*
    @Override
    public Double visitCodigoParser(linguagemParser.CodigoParserContext ctx) {
        List<linguagemParser.CodeContext> codeList = ctx.code();
        for (linguagemParser.CodeContext c : codeList){
            Double value = (Double) visit(c);
        }
        return null;
    }

    /**
     * ID '=' expr NEWLINE # assignExpr
     *//*
    @Override
    public Double visitAssignExpr(linguagemParser.AssignExprContext ctx) {
        String id = ctx.ID().getText();
        Double value = (Double) visit(ctx.expr()) ;
        memory.put(id, value);
        System.out.println(id+" = "+value);
        return value;
    }

    /**
     * 'if' '(' comparation ')' NEWLINE inicio 'end' NEWLINE # if
     */ /*
    @Override
    public Double visitIf(linguagemParser.IfContext ctx) {
        int b = (Integer) visit(ctx.comparation());

        if (b == 1){
            linguagemParser.CodigoParserContext cod = (linguagemParser.CodigoParserContext) ctx.start();
            Object value = visit(cod);
            return 1.0;
        }
        return 0.0;
    }

    /**
     * 'send' ADDRESS ADDRESS NEWLINE '"' texto '"' NEWLINE # address
     */ /*
    @Override
    public Double visitAddress(linguagemParser.AddressContext ctx) {
        System.out.println(visit(ctx.text()));

        String to = ctx.ADDRESS(1).getText();
        String from = ctx.ADDRESS(0).getText();
        System.out.println(ctx.ADDRESS(0).getText());
        System.out.println(visit(ctx.text()));
        String texto = String.valueOf(visit(ctx.text()));

        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.transport.protocol", "smtp");
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Send Email");
            message.setText(texto);

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException m) {
            m.printStackTrace();
        }

        return 0.0;
    }

    /**
     * expr NEWLINE # calcExpr
     *//*
    @Override
    public Double visitCalcExpr(linguagemParser.CalcExprContext ctx) {

        Double value =  (Double) visit(ctx.expr());
        return value;
    }

    /**
     * NEWLINE # newline
     */ /*
    @Override
    public Double visitNewline(linguagemParser.NewlineContext ctx) {
        return 0.0;
    }

    /**
     * '(' expr ')' # parens
     *//*
    @Override
    public Double visitParens(linguagemParser.ParensContext ctx) {
        return (Double) visit(ctx.expr());
    }

    /**
     * expr  op=('*'|'/') expr # multDiv
     *//*
    @Override
    public Double visitMultDiv(linguagemParser.MultDivContext ctx) {
        Double left = (Double) visit(ctx.expr(0));
        Double right = (Double) visit(ctx.expr(1));
        if (ctx.op.getType() == linguagemParser.MUL) {
            return (Double) left * (Double) right;
        }
        return (Double) left / (Double) right;
    }

    /**
     * expr  op=('+'|'-') expr # addSub
     *//*
    @Override
    public Double visitAddSub(linguagemParser.AddSubContext ctx) {
        Double left = (Double) visit(ctx.expr(0));
        Double right = (Double) visit(ctx.expr(1));
        if (ctx.op.getType() == linguagemParser.ADD) {
            return (Double) left + (Double) right;
        }
        return (Double) left - (Double) right; // must be SUB
    }

    /**
     * INT # intExpr
     *//*
    @Override
    public Double visitIntExpr(linguagemParser.IntExprContext ctx) {

        return Double.valueOf(ctx.INT().getText());
    }

    /**
     * ID # idExpr
     *//*
    @Override
    public Double visitIdExpr(linguagemParser.IdExprContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) {
            return memory.get(id);
        }
        else {
            throw new IllegalArgumentException("ID does not exist");
        }

    }

    /**
     * 'take' ID CODE ID PATH # take
     */ /*
    @Override
    public Double visitCalcTake(linguagemParser.CalcTakeContext ctx) {
        System.out.println(ctx.string(0).getText());
        System.out.println(ctx.string(1).getText());
        System.out.println(ctx.string(2).getText());
        System.out.println(ctx.string(3).getText());
            try
            {
                File file = new File(ctx.PATH().getText());
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(file);
                doc.getDocumentElement().normalize();
                System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
                NodeList nodeList = doc.getElementsByTagName(ctx.string(0).getText());

                for (int itr = 0; itr < nodeList.getLength(); itr++)
                {
                    Node node = nodeList.item(itr);
                    System.out.println("\nNode Name: " + node.getNodeName());
                    if (node.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element eElement = (Element) node;
                        if (eElement.getElementsByTagName(ctx.string(1).getText()).item(0).getTextContent().equals(ctx.string(2).getText())){
                            System.out.println("Campo "+ ctx.string(1).getText() + ": "+ eElement.getElementsByTagName(ctx.string(1).getText()).item(0).getTextContent());
                            return Double.valueOf(eElement.getElementsByTagName(ctx.string(3).getText()).item(0).getTextContent());
                        }
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println("Campo Inválido! : " + e);
            }
        return null;
    }

    /**
     * ID # returnString;
     */ /*
    @Override
    public String visitReturnString(linguagemParser.ReturnStringContext ctx) {
        System.out.println(ctx.ID().getText());
        return (ctx.ID().getText());
    }

    /**
     * comparation  op=('=='|'<'|'>'|'<='|'>='|'!=') comparation # verifyComparation
     */ /*
    @Override
    public Integer visitVerifyComparation(linguagemParser.VerifyComparationContext ctx) {

        Double left =  (Double) visit(ctx.comparation(0));
        Double right = (Double) visit(ctx.comparation(1));
        if (ctx.op.getType() == linguagemParser.BIG) {
            if (left > right){
                return 1;
            }
            else{
                return 0;
            }
        }
        else if (ctx.op.getType() == linguagemParser.BIGEQ) {
            if (left >= right){
                return 1;
            }
            else{
                return 0;
            }
        }else if (ctx.op.getType() == linguagemParser.LESS) {
            if (left < right){
                return 1;
            }
            else{
                return 0;
            }
        }else if (ctx.op.getType() == linguagemParser.LESSEQ) {
            if (left <= right){
                return 1;
            }
            else{
                return 0;
            }
        }else if (ctx.op.getType() == linguagemParser.EQ) {
            if (left == right){
                return 1;
            }
            else{
                return 0;
            }
        }else {
            if (left != right){
                return 1;
            }
            else{
                return 0;
            }
        }
    }

    /**
     * INT # intComparation
     */ /*
    @Override
    public Double visitIntComparation(linguagemParser.IntComparationContext ctx) {

        return Double.valueOf(ctx.INT().getText());
    }

    /**
     * ID # idComparation
     */ /*
    @Override
    public Double visitIdComparation(linguagemParser.IdComparationContext ctx) {

        String id = ctx.ID().getText();
        if (memory.containsKey(id)) {
            return memory.get(id);
        }
        else {
            throw new IllegalArgumentException("ID does not exist");
        }
    }

    /**
     * texto expr # exprTextoEmail
     *//*
    @Override
    public String visitExprTextEmail(linguagemParser.ExprTextEmailContext ctx) {
        String texto = visit(ctx.text()) + " " + visit(ctx.expr());
        return texto;
    }

    /**
     * texto CODE # codeTextoEmail
     */ /*
    @Override
    public String visitCodeTextEmail(linguagemParser.CodeTextEmailContext ctx) {
        String texto = visit(ctx.text()) + " " + visit((linguagemParser.CodeEmailContext) ctx.ID());
        return texto;
    }

    /**
     * expr # exprEmail
     *//*
    @Override
    public Double visitExprEmail(linguagemParser.ExprEmailContext ctx) {
        return (Double) visit((linguagemParser.ExprContext) ctx.expr());
    }

    /**
     * CODE # codeEmail
     *//*
    @Override
    public String visitCodeEmail(linguagemParser.CodeEmailContext ctx) {
        return ctx.ID().getText();
    }

}*/
