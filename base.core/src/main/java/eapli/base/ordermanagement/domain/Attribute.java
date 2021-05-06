package eapli.base.ordermanagement.domain;

import eapli.framework.general.domain.model.Description;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Embeddable
public class Attribute {
    @Id
    @GeneratedValue
    private Long attributecode;

    private Description description;
    private Description name;
    private Description label;
    private Description Responce;

}
