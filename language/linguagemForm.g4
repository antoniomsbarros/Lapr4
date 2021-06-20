grammar linguagemForm;

start:
    |start statement_verification
    |start statement_configuration;

statement_verification: if_func;
statement_configuration: config;


if_func: IF conditions 'then' content ';';

content: content ctntconditions
        |content config
        |content if_func
        |ctntconditions
        |config
        |if_func
        ;

gap: INTEGER AND INTEGER;

 config: INTEGER SIZE INTEGER END #valSize
         |INTEGER BETWEEN gap END #valBetween
         |INTEGER IS OBLIGATION END #valObligatory
         ;

 ctntconditions: conditions END;

 conditions : condition  #conditionsNoOp
             |conditions CONDITION_OP condition END #conditionsOp
             ;

 condition: INTEGER (VERIFICATION_OP|EQUAL_OR_NOT) intExpression #valueVerifyVerifyOrEqualOrNot
           | INTEGER COLON STR_STATE #valState
           | INTEGER EQUAL_OR_NOT stringCondition   #valEqualString //integer == if (str_a.equals(str_b) return
           | INTEGER EQUAL_OR_NOT BOOLEAN_OP #valIsBoolean //integer == true-> 1 else (false)-> 0
           | BOOLEAN_OP EQUAL_OR_NOT INTEGER #booleanIsVal// true -> integer = 1(verify)   false-> integer= 0 (verify)
           ;
/**
SRV1- FORM PEDIDO-> EXEMPLO VALIDACAO FORM
if(data2 >= data1) {
    //validar gramática das datas
    return ?
}

if(STRING_AUSENCIA.equals("justificado"){
// preencher campo justificacao
return ?
-> permitir que justicacao = "Qualquer coisa";
}
**/

stringCondition: stringValue | stringWithQuoteMarks;
intExpression: intValue | intExpression MATH_OP intValue;

stringValue: STRING | STRING stringValue;
stringWithQuoteMarks: QUOTE_MARKS stringValue QUOTE_MARKS;



intValue: INTEGER (POINT?) INTEGER
          |INTEGER;


////////////LEXER RULES STARTED///////////////////
IF: 'if';
STR_STATE: ('empty'|'Empty'|'EMPTY'|'filled'|'Filled'|'FILLED');
SIZE: ('size is'|'SIZE IS');
BETWEEN: ('is between'|'IS BETWEEN');
SIDE_BAR: ('/');
AND: ('AND'|'and');
IS: ('IS'|'is');
END: ';';
COLON: ':';
POINT: '.';
QUOTE_MARKS: '"';
VERIFICATION_OP: ('<'|'>'|'<='|'>=');
LOGIC_OP: ('&'|'|'| '~'|'^');
BOOLEAN_OP: ('true'|'True'|'TRUE'|'false'|'False'|'FALSE');
EQUAL_OR_NOT: ('=='|'!=');
CONDITION_OP: ('&&'|'||');
OPTION_TYPE: ('INTEGER'|'String'|'Bool'|'Data');
MATH_OP: ('+'|'-'|'*'|'%'|'/');
OBLIGATION:('obligatory'
            |'Obligatory'
            |'OBLIGATORY'
            |'not obligatory'
            |'Not Obligatory'
            |'NOT OBLIGATORY'
            |'Not obligatory');
STRING: [a-zA-Z]+;
INTEGER: [0-9]+;
DATA:DAY SIDE_BAR MONTH SIDE_BAR YEAR;
YEAR: [2][0][0-9][0-9];
MONTH:[0][1-9]|[1][0-2];
DAY: [0][1-9]|[1][0-9]|[2][0-8]|[2][9]|[3][0-1] ;