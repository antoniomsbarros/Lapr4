# US2052 - Como RRH, eu pretendo criar uma nova equipa.
=======================================


# 1. Requisitos

**US2052** Como RRH, eu pretendo criar uma nova equipa.

- 2052.1. Como RRH, eu pretendo criar uma nova equipa atribuindo-lhe uma designação.

- 2052.2. Como RRH, eu pretendo criar uma nova equipa atribuindo-lhe um Acronimo.

- 2052.3. Como RRH, eu pretendo criar uma nova equipa atribuindo-lhe um tipo de equipa.

Esta interpretação deste requisito foi feita no sentido de criar uma equipa com todos os seus atributos necessarios para a sua criação.

# 2. Análise
    
    A análise foi realizada tendo em conta as reuniões com o Cliente e com as respostas submetidas pelo Cliente no Fórum para esclarecimento de dúvidas
	
    * A Equipa é identificada por um código Único gerado automaticamente, um Acrónimo, uma Designação e um tipo de Equipa.
    * O Acrónimo é caraterizado por ter menos de 10 caracteres que só pode ter Letras maiúsculas, minúsculas e números.
    * A designação pode ter um número máximo de 50 caracteres.
    * A Equipa é constituída por um Colaborador responsável.
    * A Equipa é constituída por uma Lista de colaboradores que representa uma lista total de todos os colaboradores da equipa.
    * A Equipa tem de ter, obrigatoriamente, o tipo de equipa, o acronimo, codigo Único, e a Designação especificados 
        inicialmente, a lista de colaboradores pode ser adicionado depois  ou no inicio da criação da equipa.
# 3. Design

    Para a realizar esta UC foi usado um padrão Controller e Repository.
    Foi criado o CreateTeamController que será responsável pela criação de uma nova equipa.
    Dado que uma Equipa é composta por varios colaboradores e um tipo de Equipa são levantados para os que se melhor adequam aquela equipa.
    Depois de serem escolhidos e serem introduzidas todas as informaçoes necessarias.
    O Controller utiliza a classe Catalgo e ClientUser para poder instanciar uma equipa
    O controller usa o TeamRepository para guardar os dados na base de dados.


## 3.1. Realização da Funcionalidade

![sdCreateTeam](sd Create Team.png)

## 3.2. Diagrama de Classes

Por indicação do professor, não é necessário elaborar o Diagrama de Classes.
## 3.3. Padrões Aplicados
O padrão utilizado foi o padrão Controller e Repository.

## 3.4. Testes 
Os testes aplicados a esta funcionilidade são:

**Teste 1:** Testar se não é possivel mandar um acronimo com mais de 10 caracteres.

**Teste 2:** Testar se não é possivel mandar um acronimo com um caracter que não seja numero ou letra

**Teste 3:** Testar se não é possivel mandar um designação com mais de 50 caracteres.

**Teste 4:** Testar se não é possivel mandar um valor NULL para um parametro;

# 4. Implementação

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integração/Demonstração

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observações

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*



