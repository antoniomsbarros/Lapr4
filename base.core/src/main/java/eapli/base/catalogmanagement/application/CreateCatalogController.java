package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.CatalogBuilder;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import javax.swing.*;
import java.util.List;

@UseCaseController
public class CreateCatalogController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CatalogRepository catalogRepository = PersistenceContext.repositories().catalogs();
    private final ListCollaboratorService lcsCollaborator = new ListCollaboratorService();
    private final ListTeamsService ltsTeam = new ListTeamsService();

    public Catalog addCatalog(final Description title, final Description shortdescription,
                              final Description longdescription, final ImageIcon icone,
                              final List<Team> team, final ClientUser responsiblecollaborator){


        final CatalogBuilder catalogBuilder = new CatalogBuilder(title,shortdescription,longdescription,icone,team,responsiblecollaborator);
            catalogBuilder.withTittle(title).withShortDescription(shortdescription)
                    .withLongDescription(longdescription).withIcone(icone).withTeam(team)
                    .withResponsibleCollaborator(responsiblecollaborator);
            return catalogRepository.save(catalogBuilder.build());
    }



}

