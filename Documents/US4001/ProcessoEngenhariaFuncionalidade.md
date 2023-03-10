# US4001- Como Gestor de Projeto, eu pretendo que seja desenvolvido no Motor de Fluxo de Atividade o mecanismo de gestão/controlo/avanço do fluxo de atividades de um dado pedido.
=======================================


# 1. Requisitos

**US3011** Como Gestor de Projeto, eu pretendo que seja desenvolvido no Motor de Fluxo de Atividade o mecanismo de gestão/controlo/avanço do fluxo de atividades de um dado pedido.

- Pré-Requisitos
	- Existência de Serviços
	- Existência de formularies
	- Existência de pedidos
- Requisitos
	- Existe colaborador
	- Existência de atividades 
	- Existência de um ou mais pedidos não terem atividades atribuidas.
	- Existência de um ou mais atividades de um pedido não estarem aprovadas
- Pós-Requisitos
	- o pedido se encontrar no estado finalizado 

A interpretação feita deste requisito foi no sentido é que esta Us é responsável por manter e avançar o estado de um pedido feito

# 2. Análise

	A análise foi realizada tendo em conta as reuniões com o Cliente e as respostas dadas no Fórum para esclarecimento de dúvidas.
	* O motor de fluxo é responsavel por todos pedidos desde quando foram criado até ao seu estado de concluido o motor de fluxo
	é responsavel por criar o workflow que o pedido segui, tambem é responsavel por fazer a mudança do estado do pedido e das 
	atividades do pedido. E tambem caso exista tambem uma atividade manual anterior a uma atividade automatica atividade automática 
	fica num estado de espera ativa até atividade manual estiver comcluida e depois é que é mandada para o executor de tarefas 
	automáticas para ser executada e depois processa a resposta do executor de atividades automáticas e depois de tudas as atividades do
	pedido faz a mudança do estado do pedido.

# 3. Design

*Nesta secção a equipa deve descrever o design adotado para satisfazer a funcionalidade. Entre outros, a equipa deve apresentar diagrama(s) de realização da funcionalidade, diagrama(s) de classes, identificação de padrões aplicados e quais foram os principais testes especificados para validar a funcionalidade.*

*Para além das secções sugeridas, podem ser incluídas outras.*


## 3.3. Padrões Aplicados
Os padrões que foram aplicados foram os padroes de rcomp para a comunicação entre servidores e aplicações.
## 3.4. Testes 

**Teste 1:** Verifica se o id recebido pela parte da aplicação não é null
**Teste 2:** Caso um serviço conter uma atividade de aprovação e essa atividade tiver decisão reprovada o estado do pedido 
referente aquele serviço fica com o estado de "REJEITADO".
**Teste 3:** Caso todas as atividades estiverem no estado done e não ter nenhuma atividade com a decisão reprovada o estado do pedido vira para concluído


# 4. Implementação

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integração/Demonstração

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observações

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*



