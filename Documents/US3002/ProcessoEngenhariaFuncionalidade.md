# US3002 - Como utilizador, eu pretendo solicitar um serviço do catálogo de serviços que me é disponibilizado.
=======================================


# 1. Requisitos

**US3002** Como utilizador, eu pretendo solicitar um serviço do catálogo de serviços que me é disponibilizado.

- Pré-Requisitos
	- ExistÊncia de utilizadores capazes de aceder aos Catálogos;
	- Existência de Catálogos;
	- Existências de Serviços;
	- Existências de Formulários;
- Requisitos
	- Solicitar o serviço pretendido;
	- Preencher o Pedido para submeter;
	- Preencher o Formulário;
- Pós-Requisitos
	- Solicitação realizada;

A interpretação feita deste requisito foi no sentido de um utilizador puder solicitar um serviço de um catálogo do qual ele tem acesso.

# 2. Análise

	A análise foi realizada tendo em conta as reuniões com o Cliente e as respostas dadas no Fórum para esclarecimento de dúvidas.

	*A pesquisa do serviço é realizada por catálogo
	*Toda a informação do formulário tem de ser preenchida.
	*O Pedido tem de ter toda a informação necessária.


# 3. Design

Para realziar esta funcionalidade a equipa usou o padrão Controller, Repository e Builder.
Foi criado o RequestServiceController que é responsável pela criação do Draft, Pedido e do Ticket.
Após ser introduzidos todos os dados necessários é criado o Draft ou o Pedido e o Ticket.
É usado o RequestRepository e o DraftRepository e o TicketRepository para guardar a informação.

## 3.1. Realização da Funcionalidade

Visualização do SD

## 3.2. Diagrama de Classes

Por indicação do professor, não é necessário elaborar o Diagrama de Classes.

## 3.3. Padrões Aplicados

O padrão aplicado foi o padrão Controller e Repository e Builder.

## 3.4. Testes 


**Teste 1 a x:** Verificar que não é possível criar uma instância da classe Draft com valores nulos.

	@Test(expected = IllegalArgumentException.class)
		public void DraftensureNullIsNotAllowed() {
		Draft draft = new Draft(x field null);
	}


**Teste 2 a x:** Verificar que não é possível criar uma instância da classe Request com valores nulos.

	@Test(expected = IllegalArgumentException.class)
		public void RequestensureNullIsNotAllowed() {
		Request request = new Request(x field null);
	}


# 4. Implementação

Após ser preenchido os dados irá aparecer o Draft ou o Pedido e o Ticket na Base de Dados.

# 5. Integração/Demonstração

Após ser preenchido os dados irá aparecer o Draft ou o Pedido e o Ticket na Base de Dados.

# 6. Observações

Melhorar a gramática.



