package eapli.base.ordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.*;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.base.ordermanagement.domain.repository.FormRepository;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

@UseCaseController
public class CreateFormController {
    private final AuthorizationService authz;
    private final FormRepository formRepository;
    private FormBuilder formBuilder;
    private AttributeBuilder attributeBuilder;
    private List<Attribute> lstAttrbutes;

    public CreateFormController(AuthorizationService authz) {
        this.authz = AuthzRegistry.authorizationService();
        this.formRepository = PersistenceContext.repositories().forms();
        this.formBuilder = new FormBuilder();
        this.attributeBuilder = new AttributeBuilder();
        this.lstAttrbutes = new ArrayList<>();
    }
/*
    public void addAttribute(Long id, Description description, Description name, Description label, Description regularexpression, TypeofData dataType) {
        attributeBuilder.withId(id).withDescription(description).withLabel(label).withRegularExpression(regularexpression)
                .withName(name).withTypeofData(dataType);
        lstAttrbutes.add(attributeBuilder.build());
    }
/*
    public Form saveForm(Description name, Description script) {
        formBuilder.withName(name).withScript(script);
        for (Attribute a : lstAttrbutes) {
            formBuilder.withAttribute(a);
        }
        return formRepository.save(formBuilder.build());
    }*/
}
