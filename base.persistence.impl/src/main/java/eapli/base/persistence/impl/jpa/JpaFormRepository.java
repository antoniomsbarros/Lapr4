package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.Attribute;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.TypeofData;
import eapli.base.ordermanagement.domain.repository.FormRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaFormRepository extends JpaAutoTxRepository<Form, Long, Long> implements FormRepository {

    //@PersistenceContext
    //private EntityManager entityManager;


    public JpaFormRepository(final TransactionalContext autoTx){
        super(autoTx,"identifier");
    }

    public JpaFormRepository(String name){
        super(name, Application.settings().getExtendedPersistenceProperties(),"identifier");
    }

    public JpaFormRepository(){
        super("identifier", Application.settings().getExtendedPersistenceProperties(),"identifier");
    }

    /*@Transactional
    public Attribute saveAttribute(Long id, Description description, Description name, Description label, Description regularexpression, Description script, TypeofData dataType) {
        entityManager.createNativeQuery("INSERT INTO ATTRIBUTE(ID, DESCRIPTION, LABEL, NAME, REGULAREXPRESSION, SCRIPT, TYPEOFDATA) VALUES(?,?,?,?,?,?,?)")
                    .setParameter(1, id)
                    .setParameter(2,description)
                    .setParameter(3,label)
                    .setParameter(4,name)
                    .setParameter(5,regularexpression)
                    .setParameter(6,script)
                    .setParameter(7,dataType)
                    .executeUpdate();
        return new Attribute(id, description, name, label, regularexpression, script, dataType);
    }*/
}
