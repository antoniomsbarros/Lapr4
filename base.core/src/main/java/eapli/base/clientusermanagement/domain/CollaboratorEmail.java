package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class CollaboratorEmail implements ValueObject {

    private static final long serialVersionUID = 1L;
    private String email;

    public CollaboratorEmail() {
    }

    public CollaboratorEmail(final String email) {
        Preconditions.noneNull(email,"the Email cant be null");
        if (!isValidEmailAddress(email)){
            throw  new IllegalArgumentException("The email dont exist");
        }
        this.email = email;
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
    public String email(){
        return  email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollaboratorEmail that = (CollaboratorEmail) o;
        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "email='" + email;
    }
}
