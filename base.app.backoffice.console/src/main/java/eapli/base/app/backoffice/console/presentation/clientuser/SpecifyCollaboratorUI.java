package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.clientusermanagement.application.SpecifyCollaboratorController;
import eapli.base.clientusermanagement.domain.Placeofresidence;
import eapli.base.funcaomanagement.domain.Function;
import eapli.base.usermanagement.application.AddUserController;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
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

public class SpecifyCollaboratorUI extends AbstractUI {

    private final SpecifyCollaboratorController specifyCollaboratorController = new SpecifyCollaboratorController();
    private final AddUserController addUserController = new AddUserController();
    @Override
    protected boolean doShow() {

        final String mecanographicNumber = Console.readLine("Número Mecanográfico: ");
        final String fullName = Console.readLine("Nome completo: ");
        final String email = Console.readLine("Email: ");
        final Calendar birth = Console.readCalendar("Data de Nascimento: ");
        final Long phoneNumber = Console.readLong("Número de telefone: ");
        final String shortname = Console.readLine("Nome curto: ");
        final Function function = new Function();

        String country = Console.readLine("País: ");
        String county = Console.readLine("Concelho: ");
        String District = Console.readLine("Distrito: ");
        String  City = Console.readLine("Cidade:: ");
        String street = Console.readLine("Rua: ");
        Long doorNumber = Console.readLong("Número da Porta: ");
        Long floorNUmber = Console.readLong("Andar: ");
        String PostalCode = Console.readLine("Código Postal: ");

        Placeofresidence placeofresidence = new Placeofresidence(country, county, District, City, street, doorNumber, floorNUmber, PostalCode);

        final Set<Role> roleTypes = new HashSet<>();
        boolean show;
        do {
            show = showRoles(roleTypes);
        } while (!show);

        try {
            specifyCollaboratorController.specifyCollaborator(mecanographicNumber, fullName, function, email, birth, phoneNumber, shortname, placeofresidence, roleTypes);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That username is already in use.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Especify Collaborator";
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
