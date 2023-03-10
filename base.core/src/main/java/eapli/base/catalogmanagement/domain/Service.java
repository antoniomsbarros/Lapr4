package eapli.base.catalogmanagement.domain;


import eapli.base.ordermanagement.domain.Form;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Service implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long uniquecode;

    @AttributeOverride(name = "value", column = @Column(name = "title"))
    private Description title;

    @AttributeOverride(name = "value", column = @Column(name = "fulldescription"))
    private Description fulldescription;

    @AttributeOverride(name = "value", column = @Column(name = "smalldescription"))
    private  Description smalldescription;

    @AttributeOverride(name = "value", column = @Column(name = "requirefeedback"))
    private String requirefeedback;

    @AttributeOverride(name = "value", column = @Column(name = "icon"))
    private Description icon;

    @ElementCollection
    private Set<Keyword> keyword;

    @ManyToOne(optional = false)
    private Catalog catalog;

    @OneToMany()
    private List<Form> form;

    private boolean completedService;
/*
    @OneToOne(optional = false)
    private Criticalitylevel criticalitylevel;

 */
    @OneToOne()
    private Workflow workflow;

    public Service() {
    }

    public Service(final List<Form> form,/*final Criticalitylevel criticalitylevel,*/ final Description title,final Description fulldescription,
                   final Description smalldescription,final String requirefeedback, final Set<Keyword> keyword,
                   final Description icon,final Catalog catalog, boolean completedService,Workflow workflow) {
        Preconditions.noneNull(form,title,fulldescription, smalldescription, requirefeedback, icon/*, criticalitylevel*/);
        if (title.length()>50){
            throw new IllegalArgumentException("the title of the service is superior to 50 caracters");
        }
        if (smalldescription.length()>40){
            throw new IllegalArgumentException("the small description of the service is superior to 40 caracters");
        }
        if (fulldescription.length()>500){
            throw new IllegalArgumentException("the full description of the service is superior to 500 caracters");
        }
        if (!requirefeedback.equals("y") && !requirefeedback.equals("no") && !requirefeedback.equals("NA")){
            throw new IllegalArgumentException("Require feedback must be 'y'(yes) or 'n'(no). Or 'NA'(not filled).");
        }
        this.form=form;
        this.title = title;
        this.fulldescription = fulldescription;
        this.smalldescription = smalldescription;
        this.requirefeedback = requirefeedback;
        this.keyword = keyword;
        this.icon = icon;
        this.catalog = catalog;
        this.completedService = completedService;
        //this.criticalitylevel=criticalitylevel;
        this.workflow=workflow;
    }


    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Service)){
            return false;
        }
        Service service=(Service) other;
        if (this==service){
            return true;
        }
        return identity().equals(service.identity()) && title.equals(service.title)
                && fulldescription.equals(service.fulldescription) && smalldescription.equals(service.smalldescription)
                && requirefeedback.equals(service.requirefeedback) && keyword.equals(service.keyword)
                && catalog.equals(service.catalog) && completedService==service.completedService;
    }

    @Override
    public Long identity() {
        return uniquecode;
    }
    public Description title() {
        return title;
    }
    public Description fulldescription() {
        return fulldescription;
    }
    public Description smalldescription() {
        return smalldescription;
    }
    public String requirefeedback() {
        return requirefeedback;
    }
    public Set<Keyword> keyword() { return keyword; }
    public Description icon() {
        return icon;
    }
    public List<Form> form() { return form; }
    public Catalog servicecatalog() {
        return catalog;
    }
    public boolean isCompleted() {
        return completedService;
    }

    public Workflow workflow(){
        return workflow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return uniquecode.equals(service.uniquecode) && title.equals(service.title)
                && fulldescription.equals(service.fulldescription) && smalldescription.equals(service.smalldescription)
                && requirefeedback.equals(service.requirefeedback) && keyword.equals(service.keyword)
                && icon.equals(service.icon) && catalog.equals(service.catalog) && completedService==service.completedService;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniquecode, title, fulldescription, smalldescription, requirefeedback, keyword, icon, catalog, completedService);
    }

    @Override
    public String toString() {
        return "uniquecode=" + uniquecode.toString() + ", title=" + title.toString() + ", fulldescription=" + fulldescription.toString() +
                ", smalldescription=" + smalldescription.toString() + ", requireFeedback=" + requirefeedback +
                ", keyword=" + keyword.toString() +
                ", icon=" + icon.toString() +
                ", CatalogID =" + catalog.identity() +
                ", FORM=" + form.toString() +
                ", Completed?=" + completedService +
                ", Workflow?=" + workflow.toString();
    }

    public String print(){
        return uniquecode.toString() + " - " + title.toString();
    }
}
