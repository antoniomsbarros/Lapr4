package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.catalogmanagement.application.CreateCatalogController;
import eapli.base.catalogmanagement.application.CreateServiceController;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Keyword;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.TypeofData;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CatalogBootstrapper implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            CatalogBootstrapper.class);
    private final CreateCatalogController createCatalogController= new CreateCatalogController();
    private final CreateServiceController createServiceController = new CreateServiceController();

    @Override
    public boolean execute() {
    List<Team> teams=teams();
    List<ClientUser> clientUsers=allCollaborators();


    createCatalog(Description.valueOf("Reportar Erro / Falha"), Description.valueOf("Reportar Erro / Falha no sistema"),
            Description.valueOf("Reportar Erro / Falha no sistema"),Description.valueOf("bug icone"), teams , clientUsers.get(0));

    createCatalog(Description.valueOf("Cotações e Descontos"), Description.valueOf("Cotações e Descontos"),
            Description.valueOf("Cotações e Descontos"),Description.valueOf("%"),  teams, clientUsers.get(1));

    createCatalog(Description.valueOf("Alteração Dados Pessoais"), Description.valueOf("Alteração Dados Pessoais"),
            Description.valueOf("Alteração Dados Pessoais"),Description.valueOf("###"),  teams, clientUsers.get(2));

    createCatalog(Description.valueOf("Férias e Justificações"), Description.valueOf("Férias e Justificações"),
                Description.valueOf("Férias e Justificações"),Description.valueOf("=)"),  teams, clientUsers.get(3));


        List<Catalog> catalogs = catalogs();
        createCompletedServices(Description.valueOf("CompletedService1"), Description.valueOf("Srvc1Desc"),
                Description.valueOf("This is the Service1 description"), Description.valueOf("S_Green"),
                catalogs.get(0),"Y","KW1","Form1","Script1", Long.valueOf("50"));

            createCompletedServices(Description.valueOf("CompletedService2"), Description.valueOf("Srvc2Desc"),
                    Description.valueOf("This is the Service2 description"), Description.valueOf("S_Blue"),
                    catalogs.get(1),"Y","KW2","Form2","Script2", Long.valueOf("31"));

            createCompletedServices(Description.valueOf("CompletedService3"), Description.valueOf("Srvc3Desc"),
                    Description.valueOf("This is the Service3 description"), Description.valueOf("S_Yellow"),
                    catalogs.get(2), "Y","KW3","Form3","Script3", Long.valueOf("32"));

            createCompletedServices(Description.valueOf("CompletedService4"), Description.valueOf("Srvc4Desc"),
                    Description.valueOf("This is the Service4 description"), Description.valueOf("S_Blue"),
                    catalogs.get(3),"Y","KW4","Form4","Script4", Long.valueOf("33"));

    return true;
    }



    public void createCompletedServices(Description title,Description smalldescription, Description fulldescription,
                                        Description icon, Catalog choosenCatalog,String enableFeedback,String keyword ,String formName, String scriptName, Long id){


        createServiceController.createService(title,smalldescription,fulldescription,icon,choosenCatalog);

        createServiceController.addKeyword(new Keyword(keyword));
        createServiceController.addKeywordListToService();
        createServiceController.setFeedback(enableFeedback);

        createServiceController.checkIfServiceIsComplete(title,smalldescription,fulldescription,icon,enableFeedback);

        createServiceController.addAttribute(id,  Description.valueOf("desc"),  Description.valueOf("name"),  Description.valueOf("label"),  Description.valueOf("reg"), TypeofData.valueOf("String"));


        createServiceController.saveForm(Description.valueOf(formName),Description.valueOf(scriptName));

        createServiceController.saveService();
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


}
