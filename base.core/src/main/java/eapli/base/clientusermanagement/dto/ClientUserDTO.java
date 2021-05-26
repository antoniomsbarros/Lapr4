package eapli.base.clientusermanagement.dto;

import eapli.base.clientusermanagement.domain.Placeofresidence;
import eapli.base.funcaomanagement.domain.Function;

import java.util.Calendar;

/**
 *
 * @author marly
 */
public class ClientUserDTO {

    public String mecanographicNumber;
    public String fullName;
    public String functioncode;
    public String functionName;
    public String functionDescription;
    public String email;
    public Calendar birth;
    public Long phoneNumber;
    public String shortname;

    public String country;
    public String county;
    public String district;
    public String city;
    public String street;
    public Long doorNumber;
    public Long floorNUmber;
    public String postalCode;

    public ClientUserDTO(){}

    public ClientUserDTO(String mecanographicNumber, String fullName, String functioncode, String functionName, String functionDescription,
                          String email, Calendar birth, Long phoneNumber, String shortname, String country, String county,
                          String district, String city, String street, Long doorNumber, Long floorNUmber, String postalCode){

        this.mecanographicNumber = mecanographicNumber;
        this.fullName = fullName;
        this.functioncode = functioncode;
        this.functionName = functionName;
        this.functionDescription = functionDescription;
        this.email = email;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.shortname = shortname;

        this.country = country;
        this.county = county;
        this.district = district;
        this.city = city;
        this.street =  street;
        this.doorNumber = doorNumber;
        this.floorNUmber = floorNUmber;
        this.postalCode = postalCode;

    }
    public ClientUserDTO(String mecanographicNumber, String fullName, String email, Calendar birth, Long phoneNumber,
                         String shortname, String country, String county, String district, String city, String street,
                         Long doorNumber, Long floorNUmber, String postalCode){

        this.mecanographicNumber = mecanographicNumber;
        this.fullName = fullName;
        this.email = email;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.shortname = shortname;

        this.country = country;
        this.county = county;
        this.district = district;
        this.city = city;
        this.street =  street;
        this.doorNumber = doorNumber;
        this.floorNUmber = floorNUmber;
        this.postalCode = postalCode;

    }



}
