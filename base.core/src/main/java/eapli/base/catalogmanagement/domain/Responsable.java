package eapli.base.catalogmanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.lang.invoke.MethodHandles;
import java.util.List;

@Entity
public class Responsable implements DomainEntity<Long>{

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private ClientUser responsable;

    @OneToOne
    private Delegaction delegaction;

    @ManyToOne(optional = true)
    private Team team;

    public Responsable() {
    }

    public Responsable(ClientUser responsable, Delegaction delegaction, Team team) {
        Preconditions.noneNull(responsable, delegaction);
        this.responsable = responsable;
        this.team = team;
        this.delegaction = delegaction;
    }

    @Override
    public String toString() {
        return "Responsable{" +
                "id=" + id +
                ", responsable=" + responsable +
                ", delegaction=" + delegaction +
                ", team=" + team +
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
