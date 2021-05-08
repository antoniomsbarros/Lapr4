package eapli.base.ordermanagement.domain;

import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Objects;

@Entity

public class Attribute{
    @Id
    @GeneratedValue
    private Long attributecode;
    @Version
    private Long version;
    @AttributeOverride(name = "value", column = @Column(name = "description"))
    private Description description;
    @AttributeOverride(name = "value", column = @Column(name = "name"))
    private Description name;
    @AttributeOverride(name = "value", column = @Column(name = "label"))
    private Description label;
    @AttributeOverride(name = "value", column = @Column(name = "responce"))
    private Description responce;
    private TypeofData typeofData;

    public Attribute() {
    }

    public Attribute(Description description, Description name, Description label, Description responce, TypeofData typeofData) {
        Preconditions.noneNull(description, name, label, responce, typeofData);
        if (description.toString().length()>100){
            throw new IllegalArgumentException(
                    "the complete description cant be more then 100 characters"
            );
        }
        if (name.toString().length()>50){
            throw new IllegalArgumentException(
                    "the complete description cant be more then 100 characters"
            );
        }
        this.description = description;
        this.name = name;
        this.label = label;
        this.responce = responce;
        this.typeofData = typeofData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return attributecode.equals(attribute.attributecode) &&
                version.equals(attribute.version) && description.equals(attribute.description)
                && name.equals(attribute.name) && label.equals(attribute.label) && responce.equals(attribute.responce)
                && typeofData == attribute.typeofData;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributecode, version, description, name, label, responce, typeofData);
    }

    @Override
    public String toString() {
        return ", description=" + description +
                ", name=" + name +
                ", label=" + label +
                ", Responce=" + responce +
                ", typeofData=" + typeofData;
    }
}
