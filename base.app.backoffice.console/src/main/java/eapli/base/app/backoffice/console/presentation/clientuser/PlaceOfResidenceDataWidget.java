package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.framework.io.util.Console;

/**
 *
 * @author marly
 */
public class PlaceOfResidenceDataWidget {

    private String country;
    private String county;
    private String District;
    private String City;
    private String street;
    private Long doorNumber;
    private Long floorNUmber;
    private String PostalCode;

    public void show() {
        country = Console.readLine("País: ");
        county = Console.readLine("Concelho: ");
        District = Console.readLine("Distrito: ");
        City = Console.readLine("Cidade:: ");
        street = Console.readLine("Rua: ");
        doorNumber = Console.readLong("Número da Porta: ");
        floorNUmber = Console.readLong("Andar: ");
        PostalCode = Console.readLine("Código Postal: ");
    }
}
