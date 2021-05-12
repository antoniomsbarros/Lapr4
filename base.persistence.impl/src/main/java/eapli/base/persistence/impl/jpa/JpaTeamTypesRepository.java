package eapli.base.persistence.impl.jpa;

import eapli.base.Application;

import eapli.base.teamManagement.domain.TeamType;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.base.teamManagement.repositories.TeamTypeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaTeamTypesRepository extends JpaAutoTxRepository<TeamType, Uniquecode, Uniquecode> implements TeamTypeRepository {
    public JpaTeamTypesRepository(TransactionalContext autoTx) {
        super(autoTx, "singleInternalcode");
    }

    public JpaTeamTypesRepository(String name) {
        super(name, Application.settings().getExtendedPersistenceProperties(), "singleInternalcode");
    }

    @Override
    public Optional<TeamType> findByColor(Description color){
        final Map<String, Object> params = new HashMap<>();
        params.put("color", color);
        return matchOne("e.teamtype.cor=:color", params);
    }


}
