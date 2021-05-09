package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;

import eapli.base.teamManagement.domain.TeamType;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.base.teamManagement.repositories.TeamTypeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaTeamTypesRepository
        extends JpaAutoTxRepository<TeamType, Uniquecode, Uniquecode>
        implements TeamTypeRepository {
    public JpaTeamTypesRepository(TransactionalContext autoTx) {
        super(autoTx, "singleInternalcode");
    }

    public JpaTeamTypesRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "singleInternalcode");
    }

    @Override
    public Optional<TeamType> findByColor(Description color){
        final Map<String, Object> params = new HashMap<>();
        params.put("cor", color);
        return matchOne("e.teamtype.cor=:color", params);
    }


    @Override
    public Iterable<TeamType> findAll() {
        return findAll();
    }
}
