package eapli.base.ordermanagement.domain.repository;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.Attribute;
import eapli.base.ordermanagement.domain.TypeofData;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Description;
import org.springframework.data.jpa.repository.Query;

public interface FormRepository extends DomainRepository<Long, Form> {

    @Query(value = "INSERT INTO ATTRIBUTE(ID, DESCRIPTION, LABEL, NAME, REGULAREXPRESSION, SCRIPT, TYPEOFDATA) VALUES(id, description, label, name, regularexpression, script, dataType) ",nativeQuery = true)
    Attribute saveAttribute(Long id, Description description, Description label, Description name, Description regularexpression, Description script, TypeofData dataType);

}
