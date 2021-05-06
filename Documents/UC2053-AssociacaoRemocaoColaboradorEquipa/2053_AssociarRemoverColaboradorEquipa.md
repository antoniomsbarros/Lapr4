US2053 - Associar ou Remover Colaborador a uma equipa
=======================================

# 1. Requisitos

O Responsável de Recursos Humanos (RRH) pretende associar/remover um colaborador a uma equipa. Um colaborador pode pertencer a uma ou mais equipa. Contudo, não poderá pertencer a duas equipas do mesmo tipo. Assim está UC é dependente das UCs 2052 (Criação de uma nova equipa) e 2054 (Registo de um novo tipo de equipa).

# 2. Análise

Este caso de uso pretende permitir associar/remover um colaborador a uma equipa. Um colaborador pode estar associado a várias equipas distintas e uma equipa pode ter vários colaboradores associados. Ao remover o último colaborador de uma equipa é enviada uma mensagem de aviso.

## 2.1 Pré-requisito

Colaborador e Equipa definidos

# 3. Design

O diagrama doptado foi o diagrama de sequência, a fim de descrever o fluxo de realização do caso de uso. Satisfazendo a funcionalidade desejada.

## 3.1. Realização da Funcionalidade

*Nesta secção deve apresentar e descrever o fluxo/sequência que permite realizar a funcionalidade.*

SD:

![2053_AssociarRemoverColaboradorEquipa.svg](2053_AssociarRemoverColaboradorEquipa.svg)

## 3.2. Padrões Aplicados

*Nesta secção deve apresentar e explicar quais e como foram os padrões de design aplicados e as melhores práticas.*

## 3.3. Testes 

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