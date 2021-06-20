# US2001 - Como Gestor de Serviços de Help desk (GSH), eu pretendo criar um novo catálogo de serviços.
=======================================


# 1. Requisitos

**US3001** Como utilizador, eu pretendo consultar/pesquisar os catálogos de serviços e respetivos serviços que me estão/são disponibilizados.

Pré-Requisitos:
	- Existências de Catálogos;
	- Existências de Serviços;

Requisitos:
	- Diversos Métodos de Pesquisa;

Pós-Requisitos
	-Visualização dos Catálogos ou dos Serviços;


A interpretação feita deste requisito foi no sentido de procurar um catálogo por determinada informação dele.

# 2. Análise

	A análise foi realizada tendo em conta as reuniões com o Cliente e as respostas dadas no Fórum para esclarecimento de dúvidas.
	
	*Pesquisar Catálogo por diversos métodos;
	*Pesquisar Serviços por diversos métodos;
	*Visualizar o resultado obtido da Pesquisa;


# 3. Design

	Para realizar esta funcionalidade a equipa usou o padrão Controller e Repository.
	Foi criado o Controller para ser responsável pelas pesquisas a serem realizadas.
	Após ser selecionado o tipo de pesquisa e ser introduzidos os dados necessários é realizada a pesquisa e é visualizado o/os catalogo/s ou o/os serviço/s.
	O Controller usa o CatalogRepository ou o ServiceRepository para ir buscar o que é pretendido.

## 3.1. Realização da Funcionalidade

![US3001](SD/US3001.svg)

## 3.2. Diagrama de Classes

Por indicação do professor, não é necessário elaborar o Diagrama de Classes.

## 3.3. Padrões Aplicados

O padrão aplicado foi o padrão Controller e Repository.

## 3.4. Testes 

Os testes aplicados a esta funcionalidade são os seguinstes:
Após ser selecionado um tipo de pesquisa visualizar o catalogo suposto ou o serviço.

	@Test
	public void pesquisaXCatalog(x field to be used to search){
		Catalog catalogExpected = new Catalog(all fields);
		Catalog searchedCatalog = findByXfield(x);

	}

# 4. Implementação

Após ser usada a pesquisa aparecer ou o Catalog ou o Serviço.

# 5. Integração/Demonstração

As pesquisas foram realizadas para os catálogos devido a US's estarem atrasadas

# 6. Observações

Fornecer mais tipos de pesquisas.



