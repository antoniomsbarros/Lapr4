package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Keyword;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.catalogmanagement.domain.ServiceBuilder;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Attribute;
import eapli.base.ordermanagement.domain.AttributeBuilder;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.TypeofData;
import eapli.base.ordermanagement.domain.repository.FormRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.base.ordermanagement.domain.FormBuilder;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.*;

@UseCaseController
public class CreateServiceController {

    private final AuthorizationService authz;
    private final CatalogRepository catalogRepository;
    private final FormRepository formRepository;
    private final ServiceRepository serviceRepository;
    private ServiceBuilder serviceBuilder;
    private FormBuilder formBuilder;
    private AttributeBuilder attributeBuilder;
    private Set<Keyword> lstKeywords;

    public CreateServiceController() {
        this.authz = AuthzRegistry.authorizationService();
        this.catalogRepository = PersistenceContext.repositories().catalogs();
        this.formRepository = PersistenceContext.repositories().forms();
        this.serviceRepository = PersistenceContext.repositories().services();
        this.serviceBuilder = new ServiceBuilder();
        this.formBuilder = new FormBuilder();
        this.attributeBuilder = new AttributeBuilder();
        this.lstKeywords = new HashSet<>();
    }

    public void createService(Description title,Description smalldescription, Description fulldescription, Description icon){
        serviceBuilder.withTitle(title).withSmallDescription(smalldescription)
                .withFullDescription(fulldescription).withIcon(icon);
    }

    public void addKeyword(Keyword keyword) {
        lstKeywords.add(keyword);
    }

    public void addKeywordListToService() {
        serviceBuilder.withKeyword(lstKeywords);
    }

    public void enableFeedback() {
        serviceBuilder.withRequireFeedback("yes");
    }

    public void disableFeedback() {
        serviceBuilder.withRequireFeedback("no");
    }

    public Iterable<Catalog> getCatalogs(){
        return catalogRepository.findAll();
    }

    public Optional<Catalog> getCatalogByIdentifier(Long id) {
        return catalogRepository.findByIdentifier(id);
    }

    /*public void addForm(Description name) {
        formBuilder.withName(name);
    }*/

    public Attribute addAttribute(Description description, Description name, Description label, Description regularexpression, Description script,TypeofData dataType) {
        return attributeBuilder.withDescription(description).withName(name).withLabel(label)
                .withRegularExpression(regularexpression).withScript(script).withTypeofData(dataType).build();
    }

    public Form saveForm(Description name,Set<Attribute> lstAttributes) {
        formBuilder.withName(name).withAttribute(lstAttributes);
        return formRepository.save(formBuilder.build());
    }

    public Service saveService(/*Optional<Catalog> choosenCatalog, */List<Form> lstForm ) {
        serviceBuilder.withForm(lstForm);
        System.out.println(lstForm);
        //serviceBuilder.withCatalog(choosenCatalog.get());
        return serviceRepository.save(serviceBuilder.build());
    }

}
