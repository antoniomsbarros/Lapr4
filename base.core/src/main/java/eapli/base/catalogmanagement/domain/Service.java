package eapli.base.catalogmanagement.domain;


import eapli.base.ordermanagement.domain.Form;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import javax.swing.*;
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




    //@OneToOne(optional = false)
    //private Catalog catalog;
/*
    @OneToOne(optional = false)
    private Criticalitylevel criticalitylevel;

    @OneToOne()
    private Workflow workflow;*/
    @OneToMany()
    private List<Form> form;
    public Service() {
    }

    public Service(final List<Form> form,/*final Criticalitylevel criticalitylevel,*/ final Description title,final Description fulldescription,
                   final Description smalldescription,final String requirefeedback, final Set<Keyword> keyword,
                   final Description icon/*,final Catalog catalog,Workflow workflow*/) {
        Preconditions.noneNull(form,title,fulldescription, smalldescription, keyword/*, criticalitylevel*/);
        if (title.length()>50){
            throw new IllegalArgumentException("the title of the service is superior to 50 caracters");
        }
        if (smalldescription.length()>40){
            throw new IllegalArgumentException("the small description of the service is superior to 40 caracters");
        }
        if (fulldescription.length()>500){
            throw new IllegalArgumentException("the full description of the service is superior to 500 caracters");
        }
        this.form=form;
        this.title = title;
        this.fulldescription = fulldescription;
        this.smalldescription = smalldescription;
        this.requirefeedback = requirefeedback;
        this.keyword = keyword;
        this.icon = icon;
        //this.catalog = catalog;
        //this.criticalitylevel=criticalitylevel;
        //this.workflow=workflow;
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
                && requirefeedback.equals(service.requirefeedback) && keyword.equals(service.keyword);
    }

    @Override
    public Long identity() {
        return uniquecode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return uniquecode.equals(service.uniquecode) && title.equals(service.title)
                && fulldescription.equals(service.fulldescription) && smalldescription.equals(service.smalldescription)
                && requirefeedback.equals(service.requirefeedback) && keyword.equals(service.keyword)
                && icon.equals(service.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniquecode, title, fulldescription, smalldescription, requirefeedback, keyword, icon);
    }

    @Override
    public String toString() {
        return "uniquecode=" + uniquecode.toString() + ", title=" + title.toString() + ", fulldescription=" + fulldescription.toString() +
                ", smalldescription=" + smalldescription.toString() + ", requireFeedback=" + requirefeedback +
                ", keyword=" + keyword.toString() +
                ", icon=" + icon.toString() +
                ", FORM=" + form.toString();
    }
}
