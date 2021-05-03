# US2001 - Como Gestor de Serviços de Help desk (GSH), eu pretendo criar um novo catálogo de serviços.
=======================================


# 1. Requisitos

**US2001** Como Gestor de Serviços de Help desk pretendo criar um novo catálogo de serviços.

- 2001.1. Como Gestor de Serviços de Help desk pretendo criar um novo catálogo de serviços atribuindo-lhe uma descrição breve.

- 2001.2. Como Gestor de Serviços de Help desk pretendo criar um novo catálogo de serviços atribuindo-lhe uma descrição completa.

- 2001.3. Como Gestor de Serviços de Help desk pretendo criar um novo catálogo de serviços atribuindo-lhe um identificador.

- 2001.4. Como Gestor de Serviços de Help desk pretendo criar um novo catálogo de serviços atribuindo-lhe um ícone.

- 2001.5. Como Gestor de Serviços de Help desk pretendo criar um novo catálogo de serviços atribuindo-lhe um título.

- 2001.6. Como Gestor de Serviços de Help desk pretendo criar um novo catálogo de serviços atribuindo-lhe um colaborador responsável.

- 2001.7. Como Gestor de Serviços de Help desk pretendo criar um novo catálogo de serviços atribuindo-lhe uma ou mais equipas que podem aceder ao catálogo.

- 2001.8. Como Gestor de Serviços de Help desk pretendo criar um novo catálogo de serviços atribuindo-lhe um nível de criticidade.

- 2001.9. Como Gestor de Serviços de Help desk pretendo criar um novo catálogo de serviços atribuindo-lhe uma lista de serviços.


A interpretação feita deste requisito foi no sentido de criar um catálogo com todos os atributos necessários para a sua criação.

# 2. Análise

	A análise foi realizada tendo em conta as reuniões com o Cliente e as respostas dadas no Fórum para esclarecimento de dúvidas.

	* O catálogo é identificado por um Identificador, por um Ícone e por um título que devem ser únicos.
	* O título deve ter um máximo de 50 caracteres.
	* O catálogo é caraterizado por uma descrição breve e por uma descrição completa.
	* A descrição breve deve ter um máximo de 40 caracteres.
	* A descrição completa deve ter um máximo de 100 caracteres.
	* O catálogo tem associado um nível de criticidade.
	* O catálogo tem um colaborador responsável.
	* O catálogo só pode ser acedido por uma ou mais equipas.
	* O catálogo é constituído por uma lista de serviços.
	* O catálogo tem de ter, obrigatoriamente, todos os seus atributos completos para puder ser criado.


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



