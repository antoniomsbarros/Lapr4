package eapli.base.clientusermanagement.application;

import eapli.base.clientusermanagement.domain.*;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.funcaomanagement.domain.Function;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.RandomRawPassword;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author marly
 */
public class SpecifyCollaboratorController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository collaboratorRepository = PersistenceContext.repositories().clientUsers();
    private final AddUserController addUserController = new AddUserController();

    public void specifyCollaborator(final String mecanographicNumber, final String fullName, final Function function,
                                     final String email, final Calendar birth, final Long phoneNumber,
                                     final String shortname, final Placeofresidence placeofresidence, Set<Role> roleTypes) {

       authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER,
                BaseRoles.ADMIN, BaseRoles.RRH_MANAGER);

        RandomPassword randomPassword = new RandomPassword();
        System.out.println("PALAVRA-PASSE: " + randomPassword.toString());

        String[] name = shortname.split(" ", 2);
        try{
            SystemUser systemUser = this.addUserController.addUser(email, randomPassword.toString(), name[0], name[1], email, roleTypes);
            final ClientUser colaborador = new ClientUser(new MecanographicNumber(mecanographicNumber), Description.valueOf(fullName),
                    function, new CollaboratorEmail(email), new Dateofbirth(birth), phoneNumber, Designation.valueOf(shortname),
                    placeofresidence, systemUser);
            collaboratorRepository.save(colaborador);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("\nERROR: Collaborator shortname too short!");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }

}
