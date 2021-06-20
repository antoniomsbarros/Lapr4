# US1004 Como Gestor de Projeto, eu pretendo que seja desenvolvida uma linguagem/gramática de suporte geral ao sistema para expressar, entre outras coisas, validações de formulários e atividades automáticas.  
=======================================


# 1. Requisitos

Pré-requisitos - Existência de formulários e de atividades automáticas

Requisitos - Criação da linguagem/gramática

Pós-requisitos - Validação dos formulários e das atividades automáticas

**US1004** Como Gestor de Projeto, eu pretendo que seja desenvolvida uma linguagem/gramática de suporte geral ao sistema para expressar, entre outras coisas, validações de formulários e atividades automáticas.

- Validação dos atributos fo formulário;

- Validação do script da atividade automática;

A interpretação feita deste requisito foi no sentido de desenvolver uma linguagem/gramática que suporte o sistema para validar formulários e atividades automáticas.

# 2. Análise

	É necessário uma expressão regular para se puder validar os atributos a preencher nos formulários.
	Verificar a independência entre os atributos dos formulários.
	Verificar se o script está de acordo com a linguagem definida.

# 3. Design

## 3.1. Realização da Funcionalidade

Em primeiro lugar é necessário desenvolver uma linguagem/gramática para se usar posteriormente para as validações necessárias.
A linguagem tem de ser desenvolvida de modo geral para ser utilizada no sistema.

Formulários:
Após o desenvolver da linguagem/gramática, esta será utilizada para validar as respostas dos Users perante os atributos aprensentados.
Neste aspeto, salienta-se que a obrigatoriedade dos campos e dos valores admissíveis para cada campo pode variar em função dos valores de outros campos (e.g., se o campo A tem o valor “outra” então o campo B torna-se de preenchimento obrigatório, caso contrário não deve ser/estar preenchido).

Atividades Automáticas:
Após o desenvolver da linguagem/gramática, esta será utilizada para:

- A consulta/obtenção de informação constante num determinado ficheiro local partindo de dados existentes no contexto do pedido em causa. Por
exemplo, com base no número de cliente indicado no pedido consultar um ficheiro XML com informação sobre clientes para obter o escalão de rapel que
lhe está associado. Outro exemplo, com base no identificador de um produto consultar um outro ficheiro para obter o preço base de comercialização desse
produto;

- A realização de cálculos matemáticos baseados em informação disponível tanto no contexto do pedido como em informação obtida durante a realização
do script (cf. ponto anterior). Por exemplo, com base numa quantidade indicada no pedido e no preço base do produto obtido através de uma consulta,
calcula-se um valor total (i.e., quantidade * preço) e a partir daí aplica-5 se um desconto de rapel (e.g., se valor total for menor que X não há direito a
desconto, entre X e Y aplica-se 2% desconto e superior a Y aplica-se 5% de desconto);

- O envio de emails cujo remetente(s), assunto e corpo da mensagem estão estaticamente definidos no script. Contudo, estes podem conter algumas
expressões que precisam de ser previamente computadas e substituídas pelo seu resultado de forma a que o email seja corretamente enviado. Por
exemplo, no corpo do email pode constar o texto “Valor Total: {{$vt}}€”, onde “{{$vt}}” representa uma expressão que precisa de ser computada e
substituída pelo seu resultado (e.g., “350.00”) de modo a que no corpo do email enviado conste “Valor Total: 350.00€”; 

## 3.2. Diagrama de Classes

Não é necessário

## 3.3. Padrões Aplicados

ANTLR.

## 3.4. Testes 

Verificar se os dados introduzidos nas respostas aos atributos do formulário.

System.out.println(Nome atributo);
        String resp = Console.readLine("Answer the attribute");
        String regExep = at.Regularexpression().toString();
        Pattern pat = Pattern.compile(regExep);
        Matcher mat = pat.matcher(resp);
        result = mat.matches();

Se der True a resposta seguiu a expressão regular.
Se der False a resposta não seguiu a expressão regular.

# 4. Implementação

# 5. Integração/Demonstração

# 6. Observações

Nenhuma observação



