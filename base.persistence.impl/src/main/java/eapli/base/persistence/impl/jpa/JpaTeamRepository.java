package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaTeamRepository  extends BasepaRepositoryBase<Team,Uniquecode, Uniquecode> implements TeamRepository {


    public JpaTeamRepository() {
        super("uniquecode");
    }

}
