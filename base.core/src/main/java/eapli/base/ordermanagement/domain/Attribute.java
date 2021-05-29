package eapli.base.ordermanagement.domain;


import eapli.framework.domain.model.DomainEntity;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Attribute implements DomainEntity<Long> , Serializable {

    @Id
    private Long id;
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

    public Attribute(final Long id, final Description description, final Description name,
                     final Description label, final Description regularexpression,
                     final Description script, TypeofData typeofData) {
        Preconditions.noneNull(description, name, label, typeofData);
        if (description.toString().length()>100){
            throw new IllegalArgumentException(
                    "the complete description cant be more then 100 characters"
            );
        }
        if (name.toString().length()>50){
            throw new IllegalArgumentException(
                    "the complete description cant be more then 50 characters"
            );
        }
        this.id = id;
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
        return  id.equals(attribute.id) && description.equals(attribute.description)
                && name.equals(attribute.name) && label.equals(attribute.label)
                && regularexpression.equals(attribute.regularexpression) && script.equals(attribute.script)
                && typeofData.equals(attribute.typeofData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, name, label, regularexpression, script, typeofData);
    }

    @Override
    public boolean sameAs(Object other) {
        if(!(other instanceof Attribute)){
            return false;
        }
        Attribute attribute=(Attribute) other;
        if (this==attribute){
            return true;
        }
        return id.equals(attribute.id) && description.equals(attribute.description) && name.equals(attribute.name)
                && label.equals(attribute.label) && regularexpression.equals(attribute.regularexpression)
                && script.equals(attribute.script) && typeofData.equals(attribute.typeofData);
    }

    @Override
    public String toString() {
        return  "AttributeCode= " + id +
                ", description=" + description.toString() +
                ", name=" + name.toString() +
                ", label=" + label.toString() +
                ", regularexpression=" + regularexpression.toString() +
                ", script=" + script.toString() +
                ", typeofData=" + typeofData.toString();
    }

    @Override
    public Long identity() {
        return this.id;
    }
}
