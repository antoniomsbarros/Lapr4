package eapli.base.infrastructure.bootstrapers.demo;


import eapli.base.catalogmanagement.application.CreateCatalogController;
import eapli.base.catalogmanagement.application.CreateServiceController;
import eapli.base.catalogmanagement.domain.*;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.ordermanagement.application.CreateFormController;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.TypeofData;
import eapli.base.taskmanagement.application.AddManualTaskController;
import eapli.base.taskmanagement.domain.*;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ServicesForDemonstrationBootstrapp implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogBootstrapper.class);
    private final CreateCatalogController createCatalogController= new CreateCatalogController();
    private CreateServiceController createServiceController;
    private CreateFormController formController;
    private final AddManualTaskController addManualTaskController = new AddManualTaskController();


    @Override
    public boolean execute() {
        List<Team> teams=teams();
        List<ClientUser> clientUsers=allCollaborators();

        //Exemplos de Serviços para Demonstração Final ao Cliente
        //Exemplo 1
        this.createServiceController = new CreateServiceController();
        createCatalog(Description.valueOf("Titulo Servico Exemplo 1"), Description.valueOf("Descricao curta Servico Exemplo 1"),
                Description.valueOf("Descricao longa Servico Exemplo 1"),Description.valueOf("Icone Servico exemplo 1"),
                teams , clientUsers.get(0));
        createExampleService1(Description.valueOf("Pedido de Ausência Futura"), Description.valueOf("ex1"),
                Description.valueOf("ex1"), Description.valueOf("S_Blue"),
                catalogs().get(1),"y","ex1","ex1","ex1", clientUsers);

        //Exemplo 2
        createCatalog(Description.valueOf("Titulo Servico Exemplo 2"),Description.valueOf("Descricao Curta Servico Exemplo 2"),
                Description.valueOf("Descricao Longa Servico Exemplo 2"),Description.valueOf("Icone Servico Exemplo 2"),
                teams,clientUsers.get(0));
        createExampleService2(Description.valueOf("Autorização para Aplicação de Desconto"),Description.valueOf("ex2"),Description.valueOf("ex2"),Description.valueOf("S_Red"),
                catalogs().get(2),"y","ex2","ex2","ex2",clientUsers);

        return true;
    }

    public void createExampleService1(Description title,Description smalldescription, Description fulldescription,
                                      Description icon, Catalog choosenCatalog,String enableFeedback,String keyword,String formName, String scriptName, List<ClientUser> lstCollabs){

        String pedido ="REQUEST";
        String aprovacao ="APROVATION";
        String resolucao ="RESOLUTION";

        createServiceController.createService(title,smalldescription,fulldescription,icon,choosenCatalog);

        createServiceController.addKeyword(new Keyword(keyword));
        createServiceController.addKeywordListToService();
        createServiceController.setFeedback(enableFeedback);

        createServiceController.checkIfServiceIsComplete(title,smalldescription,fulldescription,icon,enableFeedback);

        createServiceController.addAttribute(Long.valueOf("1"),  Description.valueOf("desc1"),  Description.valueOf("Período de ausência (data inicio)"),  Description.valueOf("label"),
                Description.valueOf("((0[1-9]|1[0-9]|2[0-9]|3[0-1])\\/(01|0[3-9]|1[0-2])\\/(20[0-9][0-9]))|((0[1-9]|1[0-9]|2[0-8]|29)\\/02\\/(20[0-9][0-9]))"), TypeofData.valueOf("String"));
        createServiceController.addAttribute(Long.valueOf("2"),  Description.valueOf("desc2"),  Description.valueOf("Período de ausência (data fim)"),  Description.valueOf("label2"),  Description.valueOf("((0[1-9]|1[0-9]|2[0-9]|3[0-1])\\/(01|0[3-9]|1[0-2])\\/(20[0-9][0-9]))|((0[1-9]|1[0-9]|2[0-8]|29)\\/02\\/(20[0-9][0-9]))"), TypeofData.valueOf("String"));
        createServiceController.addAttribute(Long.valueOf("3"),  Description.valueOf("desc3"),  Description.valueOf("Tipo Ausencia"),  Description.valueOf("label3"),  Description.valueOf("(Ferias|Justificada|Nao Justificada)"), TypeofData.valueOf("String"));
        createServiceController.addAttribute(Long.valueOf("4"),  Description.valueOf("desc4"),  Description.valueOf("Justificação"),  Description.valueOf("label4"),  Description.valueOf("([a-zA-Z0-9]+ *)*"), TypeofData.valueOf("String"));

        createServiceController.saveForm(Description.valueOf(formName),Description.valueOf(scriptName), pedido);
        Calendar date = Calendar.getInstance();
        date.set(2022,2,2);
        //Task1
        formController = new CreateFormController();
        formController.addAttribute(Long.valueOf("5"),  Description.valueOf("d"),  Description.valueOf("Decisao"),  Description.valueOf("l"),  Description.valueOf("([a-zA-Z0-9]+ *)*"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("6"),  Description.valueOf("d2"),  Description.valueOf("Tento fundamentando a decisao"),  Description.valueOf("l2"),  Description.valueOf("([a-zA-Z0-9]+ *)*"), TypeofData.valueOf("String"));
        Form at1 = formController.saveForm(Description.valueOf("ex2"),Description.valueOf("script2"),aprovacao);
        Responsable responsable1 = new Responsable(Long.valueOf("1"), lstCollabs.get(0), new Delegaction(Long.valueOf("1"), Description.valueOf("Justificacao"), Designation.valueOf("Alternativa")), teams().get(0));
        Task t1 = addManualTaskController.addManualTask(new Deadline(date), 3,responsable1 ,Description.valueOf("Comentarioex1"), Description.valueOf("Decisaoex1"), at1, new ArrayList<>());
        //Task 2
        formController = new CreateFormController();
        formController.addAttribute(Long.valueOf("7"),  Description.valueOf("d"),  Description.valueOf("Dias de férias já gozados no ano"),  Description.valueOf("l"),  Description.valueOf("[0-9]{1,2}"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("8"),  Description.valueOf("d2"),  Description.valueOf("Dias de férias gozados do período solicitado"),  Description.valueOf("l2"),  Description.valueOf("[0-9]*"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("9"),  Description.valueOf("d3"),  Description.valueOf("Dias de férias totais"),  Description.valueOf("l2"),  Description.valueOf("[0-9]*"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("10"),  Description.valueOf("d4"),  Description.valueOf("Dias de falta justificadas já ocorridas no ano"),  Description.valueOf("l2"),  Description.valueOf("[0-9]*"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("11"),  Description.valueOf("d5"),  Description.valueOf("Dias de faltas justificadas do período solicitado"),  Description.valueOf("l2"),  Description.valueOf("[0-9]*"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("12"),  Description.valueOf("d6"),  Description.valueOf("Dias de faltas justificadas totais"),  Description.valueOf("l2"),  Description.valueOf("[0-9]*"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("13"),  Description.valueOf("d7"),  Description.valueOf("Dias de falta não justificadas já ocorridas no ano"),  Description.valueOf("l2"),  Description.valueOf("[0-9]*"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("14"),  Description.valueOf("d8"),  Description.valueOf("Dias de faltas não justificadas do período solicitado"),  Description.valueOf("l2"),  Description.valueOf("[0-9]*"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("15"),  Description.valueOf("d9"),  Description.valueOf("Dias de faltas não justificadas totais"),  Description.valueOf("l2"),  Description.valueOf("[0-9]*"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("16"),  Description.valueOf("d10"),  Description.valueOf("Comentario"),  Description.valueOf("l2"),  Description.valueOf("([a-zA-Z0-9]+ *)*"), TypeofData.valueOf("String"));
        Form at2 = formController.saveForm(Description.valueOf("ex3"),Description.valueOf("script3"),resolucao);

        Responsable responsable2 = new Responsable(Long.valueOf("2"), lstCollabs.get(1), new Delegaction(Long.valueOf("2"), Description.valueOf("Justificacao2"), Designation.valueOf("Alternativa2")), teams().get(0));
        Task t2 = addManualTaskController.addManualTask(new Deadline(date), 4,responsable2 ,Description.valueOf("Comentarioex2"), Description.valueOf("Decisaoex2"), at2, new ArrayList<>());
        Map<Long, Task> map = new HashMap<>();
        List<Sequence> lstSeq = new ArrayList<>();
        map.put(Long.valueOf("1"), t1);
        map.put(Long.valueOf("2"), t2);


        //Task out
        Task automaticTask= createServiceController.saveAutomaticTask(date, 2, "C:/ola/ola.exe");
        formController = new CreateFormController();
        formController.addAttribute(Long.valueOf("17"),  Description.valueOf("d"),  Description.valueOf("Dias de férias já gozados no ano"),  Description.valueOf("l"),  Description.valueOf("[0-9]{1,2}"), TypeofData.valueOf("String"));
        Form at3 = formController.saveForm(Description.valueOf("ex3"),Description.valueOf("script3"),resolucao);


        map.put(Long.valueOf("3"), automaticTask);

        lstSeq = createServiceController.saveSequence(map);
        Workflow workflow = createServiceController.saveWorkflow(lstSeq);
        createServiceController.saveService(workflow);

    }

    public void createExampleService2(Description title,Description smalldescription, Description fulldescription,
                                      Description icon, Catalog choosenCatalog,String enableFeedback,String keyword,String formName, String scriptName, List<ClientUser> lstCollabs){

        String pedido ="REQUEST";
        String aprovacao ="APROVATION";
        String resolucao ="RESOLUTION";

        this.createServiceController = new CreateServiceController();
        createServiceController.createService(title,smalldescription,fulldescription,icon,choosenCatalog);

        createServiceController.addKeyword(new Keyword(keyword));
        createServiceController.addKeywordListToService();
        createServiceController.setFeedback(enableFeedback);

        createServiceController.checkIfServiceIsComplete(title,smalldescription,fulldescription,icon,enableFeedback);

        createServiceController.addAttribute(Long.valueOf("40"),  Description.valueOf("a40"),  Description.valueOf("Código Interno Cliente"),  Description.valueOf("label40"),
                Description.valueOf("[B-DF-HJ-NP-TV-Z]{3}[0-9]{3}"), TypeofData.valueOf("String"));
        createServiceController.addAttribute(Long.valueOf("41"),  Description.valueOf("a41"),  Description.valueOf("Nome"),  Description.valueOf("label41"),  Description.valueOf("([a-zA-Z0-9]+ *)*"), TypeofData.valueOf("String"));
        createServiceController.addAttribute(Long.valueOf("42"),  Description.valueOf("a42"),  Description.valueOf("Tipo de Desconto"),  Description.valueOf("label42"),  Description.valueOf("([a-zA-Z0-9]+ *)*"), TypeofData.valueOf("String"));
        createServiceController.addAttribute(Long.valueOf("43"),  Description.valueOf("a43"),  Description.valueOf("Recorrência"),  Description.valueOf("label43"),  Description.valueOf("(Unica|Ate Data Limite)"), TypeofData.valueOf("String"));
        createServiceController.addAttribute(Long.valueOf("44"),  Description.valueOf("a44"),  Description.valueOf("Percentagem de Desconto"),  Description.valueOf("label44"),  Description.valueOf("[0-9]*"), TypeofData.valueOf("String"));
        createServiceController.addAttribute(Long.valueOf("45"),  Description.valueOf("a45"),  Description.valueOf("Valor de Desconto"),  Description.valueOf("label45"),  Description.valueOf("[0-9]*"), TypeofData.valueOf("String"));
        createServiceController.addAttribute(Long.valueOf("46"),  Description.valueOf("a46"),  Description.valueOf("Identificação da Fatura"),  Description.valueOf("label46"),  Description.valueOf("[a-zA-Z0-9]+"), TypeofData.valueOf("String"));
        createServiceController.addAttribute(Long.valueOf("47"),  Description.valueOf("a47"),  Description.valueOf("Data Limite"),  Description.valueOf("label47"),  Description.valueOf("((0[1-9]|1[0-9]|2[0-9]|3[0-1])\\/(01|0[3-9]|1[0-2])\\/(20[0-9][0-9]))|((0[1-9]|1[0-9]|2[0-8]|29)\\/02\\/(20[0-9][0-9]))"), TypeofData.valueOf("String"));
        createServiceController.addAttribute(Long.valueOf("48"),  Description.valueOf("a48"),  Description.valueOf("Fundamentação do pedido "),  Description.valueOf("label48"),  Description.valueOf("([a-zA-Z0-9]+ *)*"), TypeofData.valueOf("String"));

        createServiceController.saveForm(Description.valueOf(formName),Description.valueOf(scriptName), pedido);
        Calendar date = Calendar.getInstance();
        date.set(2022,3,2);
        //Task1
        this.formController = new CreateFormController();
        formController.addAttribute(Long.valueOf("49"),  Description.valueOf("a49"),  Description.valueOf("Decisao"),  Description.valueOf("label49"),  Description.valueOf("([a-zA-Z0-9]+ *)*"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("50"),  Description.valueOf("a50"),  Description.valueOf("Tento fundamentando a decisao"),  Description.valueOf("label50"),  Description.valueOf("([a-zA-Z0-9]+ *)*"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("51"),  Description.valueOf("a51"),  Description.valueOf("Percentagem de Desconto"),  Description.valueOf("label51"),  Description.valueOf("[0-9]*"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("52"),  Description.valueOf("a52"),  Description.valueOf("Valor de Desconto"),  Description.valueOf("label52"),  Description.valueOf("[0-9]*"), TypeofData.valueOf("String"));
        formController.addAttribute(Long.valueOf("53"),  Description.valueOf("a53"),  Description.valueOf("Data Limite"),  Description.valueOf("label53"),  Description.valueOf("((0[1-9]|1[0-9]|2[0-9]|3[0-1])\\/(01|0[3-9]|1[0-2])\\/(20[0-9][0-9]))|((0[1-9]|1[0-9]|2[0-8]|29)\\/02\\/(20[0-9][0-9]))"), TypeofData.valueOf("String"));
        Form at1 = formController.saveForm(Description.valueOf("ex4"),Description.valueOf("script2"),aprovacao);
        Responsable responsable1 = new Responsable(Long.valueOf("1"), lstCollabs.get(0), new Delegaction(Long.valueOf("1"), Description.valueOf("Justificacao"), Designation.valueOf("Alternativa")), teams().get(0));
        Task t1 = addManualTaskController.addManualTask(new Deadline(date), 3,responsable1, Description.valueOf("Comentarioex1"), Description.valueOf("Decisaoex1"), at1, new ArrayList<>());

        Map<Long, Task> map = new HashMap<>();
        List<Sequence> lstSeq = new ArrayList<>();
        map.put(Long.valueOf("1"), t1);

        //Task out
        Task automaticTask= createServiceController.saveAutomaticTask(date, 3, "C:/ola/ola.exe");
        this.formController = new CreateFormController();
        formController.addAttribute(Long.valueOf("54"),  Description.valueOf("a54"),  Description.valueOf("Dias de férias já gozados no ano"),  Description.valueOf("label54"),  Description.valueOf("[0-9]{1,2}"), TypeofData.valueOf("String"));
        Form at3 = formController.saveForm(Description.valueOf("ex3"),Description.valueOf("script3"),resolucao);


        map.put(Long.valueOf("3"), automaticTask);

        lstSeq = createServiceController.saveSequence(map);
        Workflow workflow = createServiceController.saveWorkflow(lstSeq);
        createServiceController.saveService(workflow);

    }

    private List<Team> teams(){
        List<Team> teams=new ArrayList<>();
        Iterator<Team> iterator=createCatalogController.allTeams().iterator();
        while (iterator.hasNext()){
            teams.add(iterator.next());
        }
        return teams;
    }

    private List<Catalog> catalogs(){
        List<Catalog> catalogs = new ArrayList<>();
        Iterator<Catalog> iterator = createServiceController.getCatalogs().iterator();
        while(iterator.hasNext()){
            catalogs.add(iterator.next());
        }
        return catalogs;
    }

    private List<ClientUser> allCollaborators(){
        List<ClientUser> collaborats=new ArrayList<>();
        Iterator<ClientUser> iterator=createCatalogController.allColaborators().iterator();
        while (iterator.hasNext()){
            collaborats.add(iterator.next());
        }
        return collaborats;
    }

    private Catalog createCatalog(final Description title, Description shortdescription, Description longdescription, Description icone,
                                  List<Team> team, ClientUser responsiblecollaborator){
        Catalog catalog=null;
        try {
            catalog=createCatalogController.addCatalog(title,shortdescription,  longdescription,  icone, team, responsiblecollaborator);
        }catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)",title, shortdescription, longdescription, icone);
            LOGGER.trace("Assuming existing record", e);
        }
        return catalog;
    }
}
