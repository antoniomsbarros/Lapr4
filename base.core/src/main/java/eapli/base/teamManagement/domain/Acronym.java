package eapli.base.teamManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Acronym implements ValueObject,Comparable<Acronym>  {
    private static final long serialVersionUID = 1L;
    private String acronymName;

    protected Acronym(){
    }

    public Acronym(final String acronimo) {
        if (StringPredicates.isNullOrEmpty(acronimo)){
            throw new IllegalArgumentException(
                    "Cant be null or Empty");
        }
        if (acronimo.length()>10){
            throw new IllegalArgumentException(
                    "the acronym exceeded the maximum size of 10 characters");
        }
        for (char c:acronimo.toCharArray()) {
            if (!isAlphaNumeric(c)){
                throw new IllegalArgumentException(
                        "the acronym has to be AlphaNumeric");
            }
        }
        this.acronymName = acronimo;
    }

    public static boolean isAlphaNumeric(char char1) {
        return (char1 >= 'a' && char1 <= 'z') || (char1 >= 'A' && char1 <= 'Z') || (char1 >= '0' && char1 <= '9');
    }

    @Override
    public int compareTo(Acronym o) {
        return acronymName.compareTo(o.acronymName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acronym acronym1 = (Acronym) o;
        return acronymName.equals(acronym1.acronymName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acronymName);
    }

    public static Acronym valueOf(String str){
        return new Acronym(str);
    }
    @Override
    public String toString() {
        return "acronym='" + acronymName;
    }
}
