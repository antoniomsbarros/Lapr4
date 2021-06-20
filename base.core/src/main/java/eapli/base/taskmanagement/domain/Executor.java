package eapli.base.taskmanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Executor implements DomainEntity<Long>, Serializable {

    @Id
    private Long id;

    @OneToOne()
    private ClientUser executor;

    public Executor(){

    }

    public Executor(Long id, ClientUser executor) {
        this.id = id;
        this.executor = executor;
    }



    @Override
    public String toString() {
        return super.toString();
    }

    public ClientUser executor() {
        return executor;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public boolean hasIdentity(Long otherId) {
        return DomainEntity.super.hasIdentity(otherId);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(Long other) {
        return DomainEntity.super.compareTo(other);
    }
}
