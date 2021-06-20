package eapli.base.ordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.*;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.base.ordermanagement.domain.repository.FormRepository;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


@UseCaseController
public class CreateFormController {
    private final AuthorizationService authz;
    private final FormRepository formRepository;
    private FormBuilder formBuilder;
    private AttributeBuilder attributeBuilder;

    public CreateFormController() {
        this.authz = AuthzRegistry.authorizationService();
        this.formRepository = PersistenceContext.repositories().forms();
        this.formBuilder = new FormBuilder();
        this.attributeBuilder = new AttributeBuilder();
    }

    public void addAttribute(Long id, Description description, Description name, Description label, Description regularexpression, TypeofData dataType) {
        attributeBuilder.withId(id).withDescription(description).withLabel(label).withRegularExpression(regularexpression)
                .withName(name).withTypeofData(dataType);
        formBuilder.withAttribute(attributeBuilder.build());
    }

    public Form saveForm(Description name, Description script, String formType) {
        formBuilder.withName(name).withScript(script).withFormType(formType);
        return formRepository.save(formBuilder.build());
    }
}
