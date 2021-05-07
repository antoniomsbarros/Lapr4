package eapli.base.catalogmanagement.domain;

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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Team> team;


    public Catalog() {

    }

    public Catalog(Description title, Description shortdescription, Description longdescription, ImageIcon icone,
                   List<Team> team) {
        Preconditions.noneNull(title,icone,shortdescription, longdescription,team);
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

    public String Title(){
        return  this.title.toString();
    }
    public List<Team> ListofTeams(){
        return team;
    }
    public  String shortdescription(){
        return  shortdescription.toString();
    }
    public  String longdescription(){
        return  longdescription.toString();
    }
    public  ImageIcon icon (){
        return  icone;
    }
}
