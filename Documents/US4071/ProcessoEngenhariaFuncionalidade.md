# US4071- Como Gestor de Projeto, eu pretendo que seja desenvolvido e integrado no Motor de Fluxos de Atividades  algoritmos que distribuam a realização de tarefas automáticas pelas diversas instâncias do Executor de Tarefas Automáticas existentes na infraestrutura instalada.
=======================================


# 1. Requisitos

**US4071** Como Gestor de Projeto, eu pretendo que seja desenvolvido e integrado no Motor de Fluxos de Atividades  algoritmos que distribuam a realização de tarefas automáticas pelas diversas instâncias do Executor de Tarefas Automáticas existentes na infraestrutura instalada.

- Pré-Requisitos
	- Existência de um Executor de atividades automáticas 
- Requisitos
	- Existência de uma atividade automática para ser executada
	- Existência de um ou mais pedidos não terem atividades atribuidas.
	- Existência de um ou mais atividades de um pedido não estarem aprovadas
- Pós-Requisitos
	- o pedido se encontrar no estado finalizado 

A interpretação feita deste requisito foi no sentido é que esta Us é responsável por manter e avançar o estado de um pedido feito

# 2. Análise

	A análise foi realizada tendo em conta as reuniões com o Cliente e as respostas dadas no Fórum para esclarecimento de dúvidas.

	*Primeiro algoritmo baseado em First Came First Served(entre as instâncias do Executor de Tarefas), ou seja a instância que chega à fila de ready em primeiro lugar também é o primeiro a ser executado.
	*Segundo algoritmo tem em consideração a disponibilidade das respectivas instâncias e a carga atual das mesmas.
	*O algortimo a ser adotado pelo sistema é definido por configuração


# 3. Design

## 3.1. Realização da Funcionalidade


## 3.2. Diagrama de Classes

Não é necessário.

## 3.3. Padrões Aplicados

Não há padrões.

## 3.4. Testes 

Testes para verificar a criação de threads.

# 4. Implementação

# 5. Integração/Demonstração

# 6. Observações

Melhoria da US


