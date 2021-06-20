grammar linguagem;
start: code+ # codigoParser;
code: ID '=' expr NEWLINE # assignExpr
    | 'if' '(' comparation ')' NEWLINE start 'end' NEWLINE # if
    |'send' ADDRESS ADDRESS NEWLINE '"' text '"' NEWLINE # address
    | expr NEWLINE # calcExpr
    | NEWLINE # newline
    ;

expr: '(' expr ')' # parens
     | expr  op=('*'|'/') expr # multDiv
     | expr  op=('+'|'-') expr # addSub
     | 'take' string string string string PATH # calcTake
     | INT # intExpr
     | ID # idExpr
     ;

string: ID # returnString; // take CLASS_NAME UNIQUE_CODE FIELD_INTENDED

comparation: comparation  op=('=='|'<'|'>'|'<='|'>='|'!=') comparation # verifyComparation
         | INT # intComparation
         | ID # idComparation
         ;
text: text expr # exprTextEmail
      | text ID # codeTextEmail
      | ID # codeEmail
      | expr # exprEmail
      ;
NEWLINE: [\r\n]+;
INT:[0-9]+ ([.][0-9]+)?;
//NUM:[0-9]+(.[0-9]+)?;
ID:[a-zA-Z0-9]+;
PATH: [\\a-zA-Z0-9.]+;
SPACE  : [ ]+ -> skip;
ADDRESS: [a-z0-9_]+ '@' [a-z0-9]+ '.com';

ATT: '=';
RIG: '(';
LEF: ')';
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

EQ: '==';
LESS: '<';
BIG: '>';
LESSEQ : '<=' ;
BIGEQ : '>=' ;
DIFF : '!=' ;