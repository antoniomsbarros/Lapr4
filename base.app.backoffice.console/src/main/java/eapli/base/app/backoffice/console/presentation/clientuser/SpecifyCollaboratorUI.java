package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.clientusermanagement.application.SpecifyCollaboratorController;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.Placeofresidence;
import eapli.base.funcaomanagement.domain.Function;
import eapli.base.teamManagement.dto.TeamDTO;
import eapli.base.usermanagement.application.AddUserController;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
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

        final String mecanographicNumber = Console.readLine("Mecanographic Number: ");
        final String fullName = Console.readLine("Full Name: ");
        final String email = Console.readLine("Email: ");
        final Calendar birth = Console.readCalendar("Date of Birth: ");
        final Long phoneNumber = Console.readLong("Phone Number: ");
        final String shortname = Console.readLine("Short Name: ");
        Function function = new Function();

        String country = Console.readLine("Country: ");
        String county = Console.readLine("County: ");
        String District = Console.readLine("Distrito: ");
        String  City = Console.readLine("City: ");
        String street = Console.readLine("Street: ");
        Long doorNumber = Console.readLong("Door Number: ");
        Long floorNumber = Console.readLong("Floor Number: ");
        String PostalCode = Console.readLine("Postal Code: ");

        Placeofresidence placeofresidence = new Placeofresidence(country, county, District, City, street, doorNumber,
                floorNumber, PostalCode);

        final Set<Role> roleTypes = new HashSet<>();
        boolean show;
        do {
            show = showRoles(roleTypes);
        } while (!show);

        //final String f = Console.readLine("Do you want to select the function? (y/n): ");
        //if (f == "y"){
            final SelectWidget<Function> functionSelectWidget = new SelectWidget<>("Functions:",
                    specifyCollaboratorController.allFunctions(), new FunctionPrinter());
            if (specifyCollaboratorController.allFunctions().iterator().hasNext()){
                functionSelectWidget.show();
                try {
                    function = functionSelectWidget.selectedElement();
                }catch (NullPointerException e){
                    System.out.println("Invalid Option: " + e);
                }
            }
            else {
                System.out.println("Without Functions!");
            }

       // }

        final String answer = Console.readLine("Do you want to select the hierarchical responsible? (y/n):");
        if (answer.equals("y")){
            final SelectWidget<ClientUser> clientUserSelectWidget = new SelectWidget<>("Collaborators:",
                    specifyCollaboratorController.allCollaborators(), new CollaboratorPrinter());
            if (specifyCollaboratorController.allCollaborators().iterator().hasNext()){
                clientUserSelectWidget.show();
                try {
                    ClientUser clientUser = clientUserSelectWidget.selectedElement();
                    specifyCollaboratorController.specifyCollaboratorWithResponsible(mecanographicNumber, fullName, function, email,
                                                    birth, phoneNumber, shortname, placeofresidence, roleTypes, clientUser);

                }catch (NullPointerException e){
                    System.out.println("Invalid Option: " + e);
                }catch (final IntegrityViolationException | ConcurrencyException e) {
                    System.out.println("That username is already in use.");
                }catch (final IllegalAccessException e) {
                    System.out.println("Object does not exist: " + e);
                }
            }
            else {
                System.out.println("Without Collaborators!");
            }

        }
        else{
            try {
                specifyCollaboratorController.specifyCollaborator(mecanographicNumber, fullName, function, email, birth, phoneNumber,
                        shortname, placeofresidence, roleTypes);
            } catch (final IntegrityViolationException | ConcurrencyException e) {
                System.out.println("That username is already in use.");
            }catch (final IllegalAccessException e) {
                System.out.println("Object does not exist: " + e);
            }
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
