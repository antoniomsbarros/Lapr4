package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.clientusermanagement.application.SpecifyCollaboratorController;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.Dateofbirth;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.clientusermanagement.domain.Placeofresidence;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.funcaomanagement.aplication.AddFunctionController;
import eapli.base.funcaomanagement.domain.Function;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.AddUserController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class SpecifyCollaboratorBootstrapper implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            SpecifyCollaboratorBootstrapper.class);

    private final AddUserController addUserController = new AddUserController();

    private final SpecifyCollaboratorController specifyCollaboratorController = new SpecifyCollaboratorController();

    private final AddFunctionController addFunctionController = new AddFunctionController();

    @Override
    public boolean execute() {
        Calendar c1 = Calendar.getInstance();
        c1.set(1989,12,4);



        Role [] roleList = addUserController.getRoleTypes();
        Set<Role> roleSet = new HashSet<>();

/**
 * TODO: Iterate through roleList and ADD colab role to roleSet
 */
        Set<Role> v=new HashSet<>();
        v.add(roleList[2]);



      addFunction(Designation.valueOf("Funcao1"), Description.valueOf("Responsavel_Funcao1)"));
      addFunction(Designation.valueOf("Funcao2"), Description.valueOf("Responsavel_Funcao2"));


        specifyCollaborator(
                "112345",
         "Jose Pereira Alves",
         new Function(Designation.valueOf("Funcao1"), Description.valueOf("Responsavel_Funcao1")),
         "colab1@isep.ipp.pt",
         c1,
         Long.valueOf("912345678"),
         "Jose Alves",
         new Placeofresidence("Portugal","Matosinhos","Porto","Porto","R.Costa",
         Long.valueOf("101"),Long.valueOf("0"),"4460-524"),v);

        c1.set(1992,4,2);

        specifyCollaborator( "112346",
                "Filipa Santos Carvalho",
                new Function(Designation.valueOf("Funcao2"), Description.valueOf("Responsavel_Funcao2")),
                "colab2@isep.ipp.pt",
                c1,
                Long.valueOf("962345678"),
                "Filipa Carvalho",
                new Placeofresidence("Portugal","Gaia","Porto","Porto","R.Almada Negreiros",
                        Long.valueOf("276"),Long.valueOf("0"),"4230-512"),v);



        c1.set(1990,5,2);

        specifyCollaborator( "112347",
                "Filipa Santos Oliveira",
                new Function(Designation.valueOf("Funcao2"), Description.valueOf("Responsavel_Funcao2")),
                "colab3@isep.ipp.pt",
                c1,
                Long.valueOf("972345678"),
                "Filipa Oliveira",
                new Placeofresidence("Portugal","Porto","Porto","Porto","R.A Negreiros",
                        Long.valueOf("276"),Long.valueOf("0"),"4260-512"),v);

        c1.set(1988,5,1);

        specifyCollaborator( "112348",
                "Andreia Santos Oliveira",
                new Function(Designation.valueOf("Funcao2"), Description.valueOf("Responsavel_Funcao2")),
                "colab4@isep.ipp.pt",
                c1,
                Long.valueOf("982345678"),
                "Andreia Oliveira",
                new Placeofresidence("Portugal","Porto","Porto","Porto","R.A N",
                        Long.valueOf("276"),Long.valueOf("0"),"4860-512"),v);


    Set<Role> v1=new HashSet<>();
    v1.add(roleList[1]);
        specifyCollaborator( "112349",
                "Antonio Barros",
                new Function(Designation.valueOf("Funcao2"), Description.valueOf("Responsavel_Funcao2")),
                "colab5@isep.ipp.pt",
                c1,
                Long.valueOf("982345678"),
                "Antonio Barros",
                new Placeofresidence("Portugal","Porto","Porto","Porto","R.A N",
                        Long.valueOf("276"),Long.valueOf("0"),"4860-512"),v1);





        return true;

    }

    public void specifyCollaborator(final String mecanographicNumber,final String fullName,
                                    final Function function, final String email,
                                    final Calendar birth, final Long phoneNumber, final String shortname,
                                    final Placeofresidence placeofresidence, Set<Role> roleTypes){


      try{
          specifyCollaboratorController.specifyCollaborator(mecanographicNumber, fullName, function, email, birth, phoneNumber, shortname,
                  placeofresidence, roleTypes);
      } catch (final ConcurrencyException | IntegrityViolationException | IllegalAccessException e) {
          // ignoring exception. assuming it is just a primary key violation
          // due to the tentative of inserting a duplicated user
          System.out.println("ERRO BOOTSTRAP: " + e);
          LOGGER.warn("Assuming {} already exists (activate trace log for details)", fullName);
          LOGGER.trace("Assuming existing record", e);
      }

    }

    public void addFunction (final Designation designation, final Description description){
        try{
            addFunctionController.addFunction(designation,description);
        } catch (final ConcurrencyException | IntegrityViolationException | IllegalAccessException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            System.out.println("ERRO BOOTSTRAP: " + e);
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", description);
            LOGGER.trace("Assuming existing record", e);
        }
    }


}
