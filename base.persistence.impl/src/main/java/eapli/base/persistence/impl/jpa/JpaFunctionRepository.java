package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.funcaomanagement.domain.Function;
import eapli.base.funcaomanagement.repositories.FunctionRepository;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author marly
 */
public class JpaFunctionRepository extends JpaAutoTxRepository<Function, Uniquecode, Designation>
        implements FunctionRepository {


    public JpaFunctionRepository(final TransactionalContext autoTx) {
        super(autoTx, "functioncode");
    }

    public JpaFunctionRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "functioncode");
    }

    @Override
    public Optional<Function> findFunctionbyID(Uniquecode uniquecode) {
        final Map<String, Object> params = new HashMap<>();
        params.put("uniquecode", uniquecode);
        return matchOne("e.functioncode=:uniquecode", params);
    }

    @Override
    public Optional<Function> ofIdentity(Uniquecode id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return matchOne("e.functioncode=:id", params);
    }

    @Override
    public void deleteOfIdentity(Uniquecode entityId) {

    }

    @Override
    public Iterable<Function> activeFunctions() {
        return match("e.active=true");
    }

    @Override
    public Optional<Function> lockOfIdentity(Uniquecode id) {
        return Optional.empty();
    }
}
