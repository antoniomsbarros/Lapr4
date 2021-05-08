package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.clientusermanagement.application.SpecifyCollaboratorController;
import eapli.base.clientusermanagement.domain.Placeofresidence;
import eapli.base.funcaomanagement.domain.Function;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Calendar;

/**
 *
 * @author marly
 */

public class SpecifyCollaboratorUI extends AbstractUI {

    private final SpecifyCollaboratorController specifyCollaboratorController = new SpecifyCollaboratorController();
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


        try {
            specifyCollaboratorController.specifyCollaborator(mecanographicNumber, fullName, function, email, birth, phoneNumber, shortname, placeofresidence);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That username is already in use.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Especify Collaborator";
    }
}
