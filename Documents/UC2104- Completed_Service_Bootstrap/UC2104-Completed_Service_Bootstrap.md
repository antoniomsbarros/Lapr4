# UC 2104 - Bootstrap Servicos Completos

# 1. Requisitos
**2104** - Como Gestor de Serviços HelpDesk (GSH), eu pretendo que, para efeitos de demonstração, o sistema contemple a possibilidade de 
        ser inicializado (bootstrap) com alguma informação relativa a serviços completamente especificados.

	* Demo2104.2 criar um serviço competo para carregá-lo quando corremos o Bootstrap do projeto
 	* Demo2104.3 verificar a persistência dos dados para armazenar na respetiva tabela da Base de 
                 Dados de Serviços completos.
A interpretação feita deste requisito foi no sentido de criar um bootstrap com alguma informação relativa a serviços 
completamente especificados.

##1.1 Pré-Requisitos
Para definir o bootstrap de Serviços Completos, é pré-requisito que:
- Exista um gestor de Gestor de Serviços de Help desk (GSH) registado no sistema.
- Seja possivel gerar um Formulário resultante do relatório do serviço criado.




**Seja atribuido/disponibilizado aquando da criação de um serviço completo, de:**
        
        * Titulo
        * Descrição Curta
        * Descrição Longa
        * Icone
        * Catalogo
        * Keyword
        * Feedback (POSITIVO)
        * Form
Para tal, necessitamos de criar o serviço completo (com todos os campos preenchidos), 
        
        - Exista um feedback positivo; 
        - Esteja associado um formulário, 
        - Exista/m uma/várias keywords;
        - Tenha um catalogo atribuido.

