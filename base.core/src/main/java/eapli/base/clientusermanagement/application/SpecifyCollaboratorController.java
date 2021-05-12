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
                                     final String shortname, final Placeofresidence placeofresidence) {

       authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER,
                BaseRoles.ADMIN, BaseRoles.RRH_MANAGER);

        RandomRawPassword randomRawPassword = new RandomRawPassword();

        final Set<Role> roleTypes = new HashSet<>();
        boolean show;
        do {
            show = showRoles(roleTypes);
        } while (!show);

        SystemUser systemUser = this.addUserController.addUser(email, randomRawPassword.toString(), shortname, shortname, email, roleTypes);


        final ClientUser colaborador = new ClientUser(new MecanographicNumber(mecanographicNumber), Description.valueOf(fullName),
                function, new CollaboratorEmail(email), new Dateofbirth(birth), phoneNumber, Designation.valueOf(shortname),
                placeofresidence, systemUser);

        collaboratorRepository.save(colaborador);

    }

    private boolean showRoles(final Set<Role> roleTypes) {
        // TODO we could also use the "widget" classes from the framework...
        final Menu rolesMenu = buildRolesMenu(roleTypes);
        final MenuRenderer renderer = new VerticalMenuRenderer(rolesMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildRolesMenu(final Set<Role> roleTypes) {
        final Menu rolesMenu = new Menu();
        int counter = 0;
        rolesMenu.addItem(MenuItem.of(counter++, "No Role", Actions.SUCCESS));
        for (final Role roleType : addUserController.getRoleTypes()) {
            rolesMenu.addItem(MenuItem.of(counter++, roleType.toString(), () -> roleTypes.add(roleType)));
        }
        return rolesMenu;
    }
}
