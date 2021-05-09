package eapli.base.ordermanagement.domain;

import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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
    @AttributeOverride(name = "value", column = @Column(name = "regularexpression"))
    private Description regularexpression;
    @AttributeOverride(name = "value", column = @Column(name = "script"))
    private Description script;

    private TypeofData typeofData;

    public Attribute() {
    }

    public Attribute(Description description, Description name, Description label, Description regularexpression, Description script, TypeofData typeofData) {
        Preconditions.noneNull(description, name, label, typeofData);
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
        this.regularexpression = regularexpression;
        this.script = script;
        this.typeofData = typeofData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return attributecode.equals(attribute.attributecode) &&
                version.equals(attribute.version) && description.equals(attribute.description)
                && name.equals(attribute.name) && label.equals(attribute.label)
                && regularexpression.equals(attribute.regularexpression) && script.equals(attribute.script)
                && typeofData == attribute.typeofData;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributecode, version, description, name, label, regularexpression, script, typeofData);
    }

    @Override
    public String toString() {
        return ", description=" + description +
                ", name=" + name +
                ", label=" + label +
                ", regularexpression=" + regularexpression +
                ", script=" + script +
                ", typeofData=" + typeofData;
    }
}
