package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.catalogmanagement.application.CreateCatalogController;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.clientusermanagement.domain.ClientUser;
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
    private final CreateCatalogController createCatalogController=new CreateCatalogController();

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
    return true;
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
    private List<ClientUser> allCollaborators(){
        List<ClientUser> collaborats=new ArrayList<>();
        Iterator<ClientUser> iterator=createCatalogController.allColaborators().iterator();
        while (iterator.hasNext()){
            collaborats.add(iterator.next());
        }
        return collaborats;
    }
}