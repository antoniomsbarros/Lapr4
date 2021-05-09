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
import eapli.framework.general.domain.model.Description;
import eapli.base.ordermanagement.domain.FormBuilder;

import java.util.List;
import java.util.Set;

public class CreateServiceController {

    private final CatalogRepository catalogRepository = PersistenceContext.repositories().catalogs();
    private final FormRepository formRepository = PersistenceContext.repositories().forms();
    private final ServiceRepository serviceRepository = PersistenceContext.repositories().services();
    private ServiceBuilder serviceBuilder;
    private FormBuilder formBuilder;
    private AttributeBuilder attributeBuilder;
    private Set<Keyword> lstKeywords;
    private Description feedback;
    private List<Attribute> lstAttribute;
    private List<Form> lstForm;

    public void createService(Description title,Description smalldescription, Description fulldescription, Description icon){
        serviceBuilder.withTitle(title);
        serviceBuilder.withSmallDescription(smalldescription);
        serviceBuilder.withFullDescription(fulldescription);
        serviceBuilder.withIcon(icon);
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
        return catalogRepository.getAllCatalogs();
    }

    public void addForm(Description name) {
        formBuilder.withName(name);
    }

    public void addAttribute(Description description, Description name, Description label, Description regularexpression, Description script) {
        attributeBuilder.withDescription(description);
        attributeBuilder.withName(name);
        attributeBuilder.withLabel(label);
        attributeBuilder.withRegularExpression(regularexpression);
        attributeBuilder.withScript(script);
    }

    public void addAttributeType(TypeofData dataType) {
        attributeBuilder.withTypeofData(dataType);
        lstAttribute.add(attributeBuilder.build());
    }

    public Form saveForm() {
        formBuilder.withAttribute(this.lstAttribute);
        Form f = formBuilder.build();
        lstForm.add(f);
        return formRepository.save(f);
    }

    public Service saveService() {
        serviceBuilder.withForm(lstForm);
        return serviceRepository.save(serviceBuilder.build());
    }

}
