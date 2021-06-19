# UC 1005 - Manual Task

# 1. Requisitos
**1005** Como Gestor de Serviços de Help desk (GSH) pretendo que seja desenvolvida a componente representativa de uma 
	atividade manual dedicada à apresentação e recolha de informação de um utilizador,
	no âmbito de um pedido e que a mesma seja adicionada à biblioteca de atividades típicas do sistema para, dessa forma, 
	poder ser usada na definição de fluxos de atividades.
 
	* Demo1005.2 criar um novo tipo de atividade (manual/automática).
 	* Demo1005.3 verificar a lista de pedidos de um utilizador para recolher as suas informações.
 	* Demo1005.4 criar uma nova atividade manual e seus respetivo/os formulário/os.
 	* Demo1005.6 definir um fluxo de atividades, que guarda certa/s atividade/s realizada/s. 
A interpretação feita deste requisito foi no sentido de criar uma atividade manual e armazená-la num fluxo de atividades, com todos os atributos necessários para a sua criação.

##1.1 Pré-Requisitos 
	Para definir uma atividade manual, é requisito que:
		- Existam pedidos finalizados. 
		- Exista um gestor de Gestor de Serviços de Help desk (GSH) registado no sistema.

# 2. Análise

Segundo o caderno de encargos, existem dois tipos de atividades: as manuais e as automáticas.
	
	* A Componente representativa de uma atividade manual é realizada por um determinado
	colaborador ou por um colaborador pertencente a uma determinada equipa.
	
	* Pode requerer o preenchimento de um formulário e estas informações são
	especificadas aquando da inclusão do componente num fluxo de atividades.

	
##2.1  Pós-Requisitos
		* Criação de uma atividade manual atribuido a um colaborador pertencente a uma equipa. 
		* Elaboração de um formulário de preenchimento de uma atividade.
		* Inclusão do componente num fluxo de atividades.

# 3. Padrões Aplicados
	Model-View-Controller (MVC) 
	Herança 
	JPA (De forma a armazenar persistentemente os dados de uma Manual Task na base de dados).
	Repository (De forma a permitir incluir,alterar,excluir,pesquisar a ManualTask na base de dados).

## 3.1. Testes

*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da
satisfação dos requisitos.*

**Teste 1:** Verificar que não é possível criar uma instância da classe Manual Task com valores nulos.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		ManualTask instance = new ManualTask(null, null,null,null,null,null,null,null,null);
	}

**Teste 2:** Verificar que a data limite da submissão não é inferior à data atual.

	@Teste(expected=IllegalArgumentException.class)
		public void ensureDeadlineDate(){
		Calendar now = Calendar.getInstance();
		Calendar deadDate = new Calendar();
		deadDate.setDate(2020,12,20);
		ManualTask instance = new ManualTask (TaskState.PENDING, new Deadline(deadDate), 1,......);
	}

# 4. Implementação



# 5. Integração/Demonstração

* Foi utilizado o conceito de herança exatamente para melhor integração da componente no sistema.


* Assim, é possível criar uma tarefa manual com todos os atributos necessários,
e ainda criar novos tipos de tarefas, que resultem do reaproveitamento de código.
  