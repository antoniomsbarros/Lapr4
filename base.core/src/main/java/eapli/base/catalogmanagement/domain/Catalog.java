package eapli.base.catalogmanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import javax.swing.*;
import java.util.List;

@Entity
public class Catalog implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long identifier;

    @AttributeOverride(name = "value", column = @Column(name = "shortdescription"))
    private Description shortdescription;
    @AttributeOverride(name = "value", column = @Column(name = "longdescription"))
    private Description longdescription;
    @AttributeOverride(name = "value", column = @Column(name = "title"))
    private Description title;

    private ImageIcon icone;

    @OneToMany()
    private List<Team> team;
    @OneToOne()
    private ClientUser responsiblecollaborator;
    @OneToOne
    private Criticalitylevel criticalitylevel;

    public Catalog() {

    }

    //TODO verificar icone
    //temporario
    public Catalog(Description shortdescription, Description longdescription, Description title, List<Team> team, ClientUser responsiblecollaborator, Criticalitylevel criticalitylevel) {
        this.shortdescription = shortdescription;
        this.longdescription = longdescription;
        this.title = title;
        this.team = team;
        this.responsiblecollaborator = responsiblecollaborator;
        this.criticalitylevel = criticalitylevel;
    }

    public Catalog(Description title, Description shortdescription, Description longdescription, ImageIcon icone,
                   List<Team> team, ClientUser responsiblecollaborator , Criticalitylevel criticalitylevel) {
        Preconditions.noneNull(responsiblecollaborator,title,icone,shortdescription, longdescription,team);
        if (shortdescription.toString().length()>40){
            throw new IllegalArgumentException(
                    "the short description cant be more then 40 characters"
            );
        }
        if (longdescription.toString().length()>100){
            throw new IllegalArgumentException(
                    "the complete description cant be more then 100 characters"
            );
        }
        if (title.toString().length()>50){
            throw new IllegalArgumentException(
                    "the complete description cant be more then 100 characters"
            );
        }
        this.title=title;
        this.shortdescription = shortdescription;
        this.longdescription = longdescription;
        this.icone = icone;
        this.team=team;
        this.responsiblecollaborator=responsiblecollaborator;
        this.criticalitylevel=criticalitylevel;
    }

    @Override
    public boolean sameAs(Object other) {
        if(!(other instanceof Catalog)){
            return false;
        }
        Catalog temp= (Catalog) other;
        return identity().equals(temp.identity()) && shortdescription.equals(temp.shortdescription)
                && longdescription.equals(temp.longdescription) && icone.equals(temp.icone);
    }

    @Override
    public Long identity() {
        return this.identifier;
    }
    public Description Title(){
        return  this.title;
    }
    public List<Team> ListofTeams(){
        return team;
    }
    public  Description shortdescription(){
        return  shortdescription;
    }
    public  Description longdescription(){
        return  longdescription;
    }
    public  ImageIcon icon (){
        return  icone;
    }
    public ClientUser responsiblecollaborator(){
        return responsiblecollaborator;
    }
    public Criticalitylevel criticalitylevel(){
        return criticalitylevel;
    }
}
