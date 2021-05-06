package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Version;
import java.util.Objects;

@Embeddable
public class Placeofresidence implements ValueObject {

    @Version
    private Long version;

    private String country;
    private String county;
    private String District;
    private String City;
    private String street;
    private Long doorNumber;
    private Long floorNUmber;
    private String PostalCode;

    public Placeofresidence() {
    }

    public Placeofresidence(final String country,final String county,final String district,final String city,
                            final String street,final Long doorNumber,final Long floorNUmber,final String postalCode) {
        Preconditions.noneNull(country,county, district, city, street, postalCode, doorNumber, floorNUmber);
        this.country = country;
        this.county = county;
        District = district;
        City = city;
        this.street = street;
        if (doorNumber<0){
            throw new IllegalArgumentException("the number door cant be negative");
        }
        this.doorNumber = doorNumber;
        if (floorNUmber<0){
            throw new IllegalArgumentException("the floor number cant be negative");
        }
        this.floorNUmber = floorNUmber;
        this.PostalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Placeofresidence that = (Placeofresidence) o;
        return version.equals(that.version) && country.equals(that.country)
                && county.equals(that.county) && District.equals(that.District)
                && City.equals(that.City) && street.equals(that.street) && doorNumber.equals(that.doorNumber)
                && floorNUmber.equals(that.floorNUmber) && PostalCode.equals(that.PostalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, country, county, District, City, street, doorNumber, floorNUmber, PostalCode);
    }

    @Override
    public String toString() {
        return ", country='" + country + '\'' +
                ", county='" + county + '\'' +
                ", District='" + District + '\'' +
                ", City='" + City + '\'' +
                ", street='" + street + '\'' +
                ", doorNumber=" + doorNumber +
                ", floorNUmber=" + floorNUmber +
                ", PostalCode='" + PostalCode;
    }
}
