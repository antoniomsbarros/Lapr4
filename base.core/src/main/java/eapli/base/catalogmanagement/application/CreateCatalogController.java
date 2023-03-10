package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.CatalogBuilder;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import javax.swing.*;
import java.util.List;

@UseCaseController
public class CreateCatalogController {

    private final AuthorizationService authz;
    private final CatalogRepository catalogRepository;
    private final ClientUserRepository clientUserRepository;
    private final TeamRepository teamRepository;

    public CreateCatalogController() {
        this.authz= AuthzRegistry.authorizationService();
        this.catalogRepository =PersistenceContext.repositories().catalogs();
        this.clientUserRepository = PersistenceContext.repositories().clientUsers();
        this.teamRepository = PersistenceContext.repositories().team();
    }

    public Catalog addCatalog(final Description title, final Description shortdescription,
                              final Description longdescription, final Description icone,
                              final List<Team> team, final ClientUser responsiblecollaborator){


        final CatalogBuilder catalogBuilder = new CatalogBuilder(title,shortdescription,longdescription,icone,team,responsiblecollaborator);
            catalogBuilder.withTittle(title).withShortDescription(shortdescription)
                    .withLongDescription(longdescription).withIcone(icone).withTeam(team)
                    .withResponsibleCollaborator(responsiblecollaborator);
            return catalogRepository.save(catalogBuilder.build());
    }

    public Iterable<ClientUser> allColaborators(){
        return clientUserRepository.findAll();
    }

    public Iterable<Team> allTeams(){
        return teamRepository.findAll();
    }


}

