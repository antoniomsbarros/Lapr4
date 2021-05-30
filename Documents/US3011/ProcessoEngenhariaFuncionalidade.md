# US3002 - Como utilizador, eu pretendo que após me autenticar seja-me apresentado o meu dashboard web e que este se mantenha atualizado (automaticamente).
=======================================


# 1. Requisitos

**US3011** Como utilizador, eu pretendo que após me autenticar seja-me apresentado o meu dashboard web e que este se mantenha atualizado (automaticamente).

- Pré-Requisitos
	- Existência de Serviços
- Requisitos
	- Existe colaborador
	- Existência de atividades
	- Existências de uma atividade atribuída ao utilizador;
- Pós-Requisitos
	- O Dashboard manter-se atualizado.

A interpretação feita deste requisito foi no sentido em que apareça um dashboard com as atividades do utilizador e manter-se atualizado 
sem que aja a necessidade de atualizar.

# 2. Análise

	A análise foi realizada tendo em conta as reuniões com o Cliente e as respostas dadas no Fórum para esclarecimento de dúvidas.

	* O dashboard deve aparecer quando o colaborador faz o login
	* O dashboard deve mostrar tudas as atividades feitas pelo colaborador 
	* O dashboard deve mostrar as atividades que faltam fazer mostrando o tempo pelo que faltam fazer
	* O dashboard deve mostrar as atividades por prioridade


# 3. Design

*Nesta secção a equipa deve descrever o design adotado para satisfazer a funcionalidade. Entre outros, a equipa deve apresentar diagrama(s) de realização da funcionalidade, diagrama(s) de classes, identificação de padrões aplicados e quais foram os principais testes especificados para validar a funcionalidade.*

*Para além das secções sugeridas, podem ser incluídas outras.*

## 3.1. Realização da Funcionalidade

*Nesta secção deve apresentar e descrever o fluxo/sequência que permite realizar a funcionalidade.*

## 3.2. Diagrama de Classes

*Nesta secção deve apresentar e descrever as principais classes envolvidas na realização da funcionalidade.*

## 3.3. Padrões Aplicados

*Nesta secção deve apresentar e explicar quais e como foram os padrões de design aplicados e as melhores práticas.*

## 3.4. Testes 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

**Teste 1:** Verificar que não é possível criar uma instância da classe Exemplo com valores nulos.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

# 4. Implementação

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integração/Demonstração

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observações

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*


