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
public class JpaFunctionRepository extends JpaAutoTxRepository<Function, Long, Long>
        implements FunctionRepository {

    public JpaFunctionRepository(final TransactionalContext autoTx) {
        super(autoTx, "functioncode");
    }

    public JpaFunctionRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "functioncode");
    }

    @Override
    public Optional<Function> findFunctionbyID(Long uniquecode) {
        final Map<String, Object> params = new HashMap<>();
        params.put("code", uniquecode);
        return matchOne("e.code=:uniquecode", params);
    }



    @Override
    public Iterable<Function> activeFunctions() {
        return match("e.active=true");
    }

}
