package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.*;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.*;
import eapli.base.ordermanagement.domain.repository.FormRepository;
import eapli.base.taskmanagement.application.AddAutomaticTaskController;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
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
    private List<Form> lstForms;
    private List<Attribute> lstAttrbutes;
    private CreateSequenceController sequenceController;
    private CreateWorkflow workflowController;
    private AddAutomaticTaskController automaticTaskController;


    public CreateServiceController() {
        this.authz = AuthzRegistry.authorizationService();
        this.catalogRepository = PersistenceContext.repositories().catalogs();
        this.formRepository = PersistenceContext.repositories().forms();
        this.serviceRepository = PersistenceContext.repositories().services();
        this.serviceBuilder = new ServiceBuilder();
        this.formBuilder = new FormBuilder();
        this.attributeBuilder = new AttributeBuilder();
        this.lstKeywords = new HashSet<>();
        this.lstForms = new ArrayList<Form>();
        this.lstAttrbutes = new ArrayList<Attribute>();
        this.sequenceController = new CreateSequenceController();
        this.workflowController = new CreateWorkflow();
        this.automaticTaskController = new AddAutomaticTaskController();
    }

    public void createService(Description title,Description smalldescription, Description fulldescription,
                              Description icon, Catalog choosenCatalog){
        serviceBuilder.withTitle(title).withSmallDescription(smalldescription)
                .withFullDescription(fulldescription).withIcon(icon).withCatalog(choosenCatalog);
    }

    public void checkIfServiceIsComplete(Description title,Description smalldescription, Description fulldescription,
                                         Description icon, String enableFeedback) {
        Description desc = Description.valueOf("NA");
        if (title.equals(desc) || smalldescription.equals(desc) || fulldescription.equals(desc) || icon.equals(desc) || enableFeedback.equals("NA")){
            serviceBuilder.withCompletedService(false);
        } else
            serviceBuilder.withCompletedService(true);
    }

    public void addKeyword(Keyword keyword) {
        lstKeywords.add(keyword);
    }

    public void addKeywordListToService() {
        serviceBuilder.withKeyword(lstKeywords);
    }

    public void setFeedback(String s) {
        serviceBuilder.withRequireFeedback(s);
    }


    public Iterable<Catalog> getCatalogs(){
        return catalogRepository.findAll();
    }

    public Optional<Catalog> getCatalogByIdentifier(Long id) {
        return catalogRepository.findByIdentifier(id);
    }

    public void addAttribute(Long id, Description description, Description name, Description label, Description regularexpression, TypeofData dataType) {
        attributeBuilder.withId(id).withDescription(description).withLabel(label).withRegularExpression(regularexpression)
                .withName(name).withTypeofData(dataType);
        lstAttrbutes.add(attributeBuilder.build());
    }

    public void saveForm(Description name,Description script, String formType) {
        Form f = formBuilder.withName(name).withScript(script).withFormType(formType).build();
        for (Attribute a : lstAttrbutes) {
            f.addListAttributes(a);
        }
        lstForms.add(formRepository.save(f));
        lstAttrbutes = new ArrayList<Attribute>();
    }

    public Task saveAutomaticTask(Calendar deadline, Integer priority, String scriptPath) {
        return automaticTaskController.addAutomaticTask(deadline, priority, scriptPath);
    }

    public List<Sequence> saveSequence(Map<Long, Task> mapTaskAndOrder) {
        List<Sequence> lstSequence = new ArrayList<>();
        for (Long position : mapTaskAndOrder.keySet()) {
            lstSequence.add(sequenceController.createSequence(mapTaskAndOrder.get(position), position));
        }
        return lstSequence;
    }

    public Workflow saveWorkflow(List<Sequence> lstSequence) {
        return workflowController.createWorkflow(lstSequence);
    }

    public Service saveService(Workflow workflow) {
        serviceBuilder.withForm(lstForms).withWorkflow(workflow);
        lstForms = new ArrayList<Form>();
        return serviceRepository.save(serviceBuilder.build());
    }

}
