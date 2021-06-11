# US3023 - Do Manual Task Pending
=======================================


# 1. Requisitos

Realizar as tarefas que eu, como colaborador, tenho como pendentes.

**Demo1** Como Utilizador pretendo...

- Demo1.1. realizar uma tarefa que tenho como pendente

A interpretação feita deste requisito foi no sentido de um colaborador poder escolher uma das tarefas 
que ele tem pendente e realizá-la.

# 2. Análise

Para a realização do caso de uso é necessário uma consulta das tarefas pendentes e a 
seleção de uma para a realização. A realização consiste em preencher o formulário 
associado e dar a tarefa como concluída. Os dados do formulário devem ser todos validados
por expressões regulares.

## 2.1. Pré-Condição
* Tarefa Manual já definida
* Consulta de tarefas pendentes já feita


## 2.2. Pós-Condição
* Tarefa realizada

# 3. Design

O diagrama doptado foi o diagrama de sequência, a fim de descrever o fluxo de realização do caso de uso.
Satisfazendo a funcionalidade desejada.

## 3.1. Realização da Funcionalidade

*Nesta secção deve apresentar e descrever o fluxo/sequência que permite realizar a funcionalidade.*

SD:

## 3.2. Padrões Aplicados

Foram aplicados os padrões:
* **Repository:** Para comunicar com a base de dados, ter acesso aos dados
  por meio das queries feitas.
* **Use-Case Controller:** Para gerir o fluxo de execução do caso de uso.

## 3.3. Testes 

**Teste 1:** Verificar que não é possível realizar uma tarefa que não consta na base de dados.

	@Test(expected = IllegalArgumentException.class)
    public void ensureManualTaskExist() {
          ManualTask manualTask = new ManualTask(...);
          doManualTask(manualTask);
	}

# 4. Implementação

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integração/Demonstração

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

