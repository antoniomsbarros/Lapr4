package eapli.base.ordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Attribute;
import eapli.base.ordermanagement.domain.AttributeBuilder;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.FormBuilder;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.base.ordermanagement.domain.repository.FormRepository;

import java.util.List;
import java.util.Set;

public class CreatFormController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private FormRepository formRepository= PersistenceContext.repositories().forms();
    private FormBuilder formBuilder=new FormBuilder();
    private AttributeBuilder attributeBuilder=new AttributeBuilder();
    public CreatFormController() {
    }

    public Form createForm(Description name, Description script, List<Attribute> attribute){
        formBuilder.withName(name).withScript(script).withAttribute(attribute);
        return formRepository.save(formBuilder.build());
    }
    /*public Attribute createAttribute(){

    }*/
}
