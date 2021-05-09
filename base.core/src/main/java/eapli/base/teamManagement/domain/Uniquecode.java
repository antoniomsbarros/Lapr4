package eapli.base.teamManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class Uniquecode implements ValueObject, Comparable<Uniquecode> {
        private String code;

    public Uniquecode() {
    }

    public Uniquecode(final String uniqueCode) {
        Preconditions.noneNull(uniqueCode);
        String temp=uniqueCode.toString();
        if (temp.length()>=15){
            throw new IllegalArgumentException(
                    "Max size reach of the UniqueCode"
            );
        }
        for (char c: temp.toCharArray()){
            if (!isAlphaNumeric(c)){
                throw new IllegalArgumentException(
                        "The UniqueCode was to be AlphaNumeric"
                );
            }
        }
        this.code=temp;
    }
    public static boolean isAlphaNumeric(char char1) {
        return (char1 >= 'a' && char1 <= 'z') || (char1 >= 'A' && char1 <= 'Z') || (char1 >= '0' && char1 <= '9');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uniquecode that = (Uniquecode) o;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "uniqueCode='" + code+'\n';
    }

    public static Uniquecode valueOf(String uniquecode){
            return new Uniquecode(uniquecode);
    }
    @Override
    public int compareTo(Uniquecode o) {
        return Long.getLong(code).compareTo(Long.getLong(o.code));
    }

    public String Code() {
        return code;
    }

}
