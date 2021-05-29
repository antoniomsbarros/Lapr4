package eapli.base.catalogmanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.validations.Preconditions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.lang.invoke.MethodHandles;

@Entity
public class Responsable implements DomainEntity<Long>{

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private ClientUser responsable;

    @OneToOne
    private Delegaction delegaction;

    public Responsable() {
    }

    public Responsable(ClientUser responsable, Delegaction delegaction) {
        Preconditions.noneNull(responsable, delegaction);
        this.responsable = responsable;
        this.delegaction = delegaction;
    }

    @Override
    public String toString() {
        return "Responsable{" +
                "id=" + id +
                ", responsable=" + responsable.toString() +
                ", delegaction=" + delegaction.toString() +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        if(!(other instanceof Responsable)){
            return false;
        }
        Catalog temp= (Catalog) other;
        return identity().equals(temp.identity()) && responsable.equals(temp.responsiblecollaborator());
    }

    @Override
    public Long identity() {
        return id;
    }


    public ClientUser responsable() {
        return responsable;
    }
}
