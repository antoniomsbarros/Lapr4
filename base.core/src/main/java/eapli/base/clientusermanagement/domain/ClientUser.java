/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.clientusermanagement.domain;

import javax.persistence.*;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.clientusermanagement.dto.ClientUserDTO;
import eapli.base.funcaomanagement.domain.Function;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.dto.TeamDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.Calendars;

import java.util.ArrayList;
import java.util.List;

/**
 * A Client User.
 *
 * This class represents client users. It follows a DDD approach where User
 * is the root entity of the Base User Aggregate and all of its properties
 * are instances of value objects. A Client User references a System User
 *
 * This approach may seem a little more complex than just having String or
 * native type attributes but provides for real semantic of the domain and
 * follows the Single Responsibility Pattern
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 *
 */
@Entity
public class ClientUser implements AggregateRoot<MecanographicNumber> {

    @Version
    private Long version;

    @EmbeddedId
    private MecanographicNumber mecanographicNumber;

    @ManyToOne(optional = true)
    private Function function;

    @OneToMany()
    private List<Catalog> listcatalog;
    //@OneToMany()
    //private List<Team> list;
    @OneToOne
    private ClientUser clientUser;


    private Description fullName;
    private CollaboratorEmail collaboratorEmail;
    private Dateofbirth dateofbirth;
    private Long phoneNumber;
    private Designation shortname;
    private Placeofresidence placeofresidence;


    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @OneToOne()
    private SystemUser systemUser;

    public ClientUser(MecanographicNumber mecanographicNumber, Function function, List<Catalog> listcatalog,
                      List<Team> list, Description fullName, CollaboratorEmail collaboratorEmail,
                      Dateofbirth dateofbirth, Long phoneNumber, Designation shortname,
                      Placeofresidence placeofresidence, SystemUser systemUser, ClientUser clientUser) {
        if (mecanographicNumber == null || systemUser == null) {
            throw new IllegalArgumentException();
        }
        if (fullName.length() > 80) {
            throw new IllegalArgumentException("The full name has passed the limit of 80 caracteres");
        }
        if (shortname.length() > 30) {
            throw new IllegalArgumentException("The short name Cant passed 30 caracteres");
        }
        this.mecanographicNumber = mecanographicNumber;
        this.function = function;
        this.listcatalog = listcatalog;
        //this.list = list;
        this.fullName = fullName;
        this.collaboratorEmail = collaboratorEmail;
        this.dateofbirth = dateofbirth;
        this.phoneNumber = phoneNumber;
        this.shortname = shortname;
        this.placeofresidence = placeofresidence;
        this.systemUser = systemUser;
        this.clientUser = clientUser;
    }

    public ClientUser(final MecanographicNumber mecanographicNumber, final Description fullName, final Function function,
                      final CollaboratorEmail collaboratorEmail, final Dateofbirth dateofbirth, final Long phoneNumber, final Designation shortname,
                      final Placeofresidence placeofresidence, final SystemUser systemUser, final ClientUser clientUser) {
        if (mecanographicNumber == null || systemUser == null) {
            throw new IllegalArgumentException("mecanographicNumber or systemUser null");
        }
        if (fullName.length() > 80) {
            throw new IllegalArgumentException("The full name has passed the limit of 80 caracteres");
        }
        if (shortname.length() > 30) {
            throw new IllegalArgumentException("The short name Cant passed 30 caracteres");
        }

        try {
            if (!(Calendars.now().compareTo(dateofbirth.Date())==1)) {
                throw new IllegalArgumentException("Invalid Date!");
            }
        }catch (NullPointerException | IllegalArgumentException e){
            System.out.println("Invalid Date: " + e);
        }

        this.mecanographicNumber = mecanographicNumber;
        this.function = function;
        this.listcatalog = new ArrayList<>();
        //this.list = new ArrayList<>();
        this.fullName = fullName;
        this.collaboratorEmail = collaboratorEmail;
        this.dateofbirth = dateofbirth;
        this.phoneNumber = phoneNumber;
        this.shortname = shortname;
        this.placeofresidence = placeofresidence;
        this.systemUser = systemUser;
        this.clientUser = clientUser;
    }

    public ClientUser(final SystemUser user, final MecanographicNumber mecanographicNumber) {
        if (mecanographicNumber == null || user == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.mecanographicNumber = mecanographicNumber;
    }

    protected ClientUser() {
        // for ORM only
    }

    public SystemUser user() {
        return this.systemUser;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public MecanographicNumber mecanographicNumber() {
        return identity();
    }

    public Description fullname() {
        return fullName;
    }

    public CollaboratorEmail email() {
        return collaboratorEmail;
    }


    @Override
    public MecanographicNumber identity() {
        return this.mecanographicNumber;
    }

   // public List<Team> teamList() {      return list;    }

    @Override
    public String toString() {
        return "ClientUser: " + " mecanographicNumber=" + mecanographicNumber + ", listcatalog=" + listcatalog + ", fullName=" + fullName + ", collaboratorEmail=" + collaboratorEmail + ", dateofbirth=" + dateofbirth + ", phoneNumber=" + phoneNumber + ", shortname=" + shortname + ", placeofresidence=" + placeofresidence + ", systemUser=" + systemUser + '\n';
    }

    public ClientUserDTO toDTO() {
        return new ClientUserDTO(mecanographicNumber.toString(), fullName.toString(), collaboratorEmail.email(), dateofbirth.Date(), phoneNumber, shortname.toString(),
                placeofresidence.country(), placeofresidence.county(), placeofresidence.district(), placeofresidence.city(),
                placeofresidence.street(), placeofresidence.doorNumber(), placeofresidence.floorNUmber(), placeofresidence.postalCode());
    }

/*
    public ClientUserDTO toDTO() {
        return new ClientUserDTO(mecanographicNumber.toString(), fullName.toString(), function.Code(), function.Name(),
                function.Description(), collaboratorEmail.email(), dateofbirth.Date(), phoneNumber, shortname.toString(),
                placeofresidence.country(), placeofresidence.county(), placeofresidence.district(), placeofresidence.city(),
                placeofresidence.street(), placeofresidence.doorNumber(), placeofresidence.floorNUmber(), placeofresidence.postalCode());
    }


*//*
    public boolean belongToThisTeamType(Team team) {

        for (Team t:listTeam){
            if (t.teamType().sameAs(team.teamType())){
                return true;
            }
        }
        return false;
    }

    public boolean addTeam(Team team) {

        if(listTeam.isEmpty()){
            listTeam.add(team);
            return true;
        }

        if(belongToThisTeamType(team)){
            return false;
        }

        listTeam.add(team);
        return true;
    }


    public boolean belongToTheTeam(Team team){
        return listTeam.contains(team);
    }

    public List<Team> listOfTeams(){
        return listTeam;
    }

    public CollaboratorEmail collaboratorEmail(){
        return collaboratorEmail;
    }
}
