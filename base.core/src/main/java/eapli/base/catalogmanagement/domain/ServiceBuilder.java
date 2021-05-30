package eapli.base.catalogmanagement.domain;

import eapli.base.ordermanagement.domain.Form;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ServiceBuilder implements DomainFactory<Service> {

    private Description title;

    private Description fulldescription;

    private Description smalldescription;

    private String requirefeedback;

    private Set<Keyword> keyword;

    private Description icon;

    private Catalog catalog;

    private boolean completedService;

    //private Criticalitylevel criticalitylevel;

    //private Workflow workflow;

    private List<Form> form;

    public ServiceBuilder() {}

    public ServiceBuilder withTitle(Description t) {
        this.title = t;
        return this;
    }

    public ServiceBuilder withFullDescription(Description d) {
        this.fulldescription = d;
        return this;
    }

    public ServiceBuilder withSmallDescription(Description d) {
        this.smalldescription = d;
        return this;
    }

    public ServiceBuilder withRequireFeedback(String f) {
        this.requirefeedback = f;
        return this;
    }

    public ServiceBuilder withKeyword(Set<Keyword> k) {
        this.keyword = k;
        return this;
    }

    public ServiceBuilder withIcon(Description i) {
        this.icon = i;
        return this;
    }

    public ServiceBuilder withCatalog(Catalog c) {
        this.catalog = c;
        return this;
    }

    public ServiceBuilder withCompletedService(boolean completedService) {
        this.completedService = completedService;
        return this;
    }

    /*public ServiceBuilder withCriticalityLevel(Criticalitylevel c) {
        this.criticalitylevel = c;
        return this;
    }*/
    /*
    public ServiceBuilder withWorkflow(Workflow w) {
        this.workflow = w;
        return this;
    }*/

    public ServiceBuilder withForm(List<Form> f) {
        this.form = f;
        return this;
    }

    @Override
    public Service build() {
        return new Service(this.form,/*this.criticalitylevel,*/this.title,this.fulldescription,this.smalldescription, this.requirefeedback,
                            this.keyword, this.icon, this.catalog, this.completedService/*, this.workflow*/);
    }

}
