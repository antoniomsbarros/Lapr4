package eapli.base.catalogmanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.framework.validations.Preconditions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Responsable {

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
}
