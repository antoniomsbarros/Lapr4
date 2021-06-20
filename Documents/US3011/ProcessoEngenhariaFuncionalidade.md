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

A análise desta US foi em relação ao enunciado, tendo também reunião com o cliente em que foi perguntado tudo
o tipo de dados que o cliente queria que tivessem representados no dashboard.
Em que a resposta do cliente foi que tem de amostrar todas as atividades do colaborador, todas as atividades que se encontram incompletas e 
também todas as atividades incompletas ordenadas pela sua prioridade. Tambem foi pedido pelo cliente 
a implementacam de um protocolo de aplicação de mais precisamente o protocolo SDP2021. E que tambem foi pedido que o dashboard 
unicamente se encontre disponível no localhost do colaborador e que tambem se mantenha sempre atualizado.

* Protocolo SDP2021: é o formato com que o tudas as comunicações entre a aplicação e os servidores tem de seguir desde a 
a comunicação da aplicação do cliente com o servidor do motor de Fluxo de atividades e vice-versa, a forma como o motor de 
  fluxo de atividade tem de comunicar com o servidor de executor de tarefas automáticas e vice-versa.
  


# 3. Design

*Nesta secção a equipa deve descrever o design adotado para satisfazer a funcionalidade. Entre outros, a equipa deve apresentar diagrama(s) de realização da funcionalidade, diagrama(s) de classes, identificação de padrões aplicados e quais foram os principais testes especificados para validar a funcionalidade.*

*Para além das secções sugeridas, podem ser incluídas outras.*

## 3.1. Realização da Funcionalidade

![SDUS3011](SDUS3011.jpg)
## 3.4. Testes 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

**Teste 1:** Se o colaborador não tiver task o dashboard deve mostrar uma mensagem a avisar que o colaborador não tem atividades 
atribuidas a ele e tambem não teve nenhuma task.

**Test 2:** Se o colaborador tiver o dashboard deve mostrar a task deve aparecer o id da task, o deadline, e a prioridade

**Test 3:** Se o servidor do dashboard não estiver ligado mostra uma pagina de erro de impossivel de conseguir se conectar.

	

# 4. Implementação

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integração/Demonstração

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observações

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*



