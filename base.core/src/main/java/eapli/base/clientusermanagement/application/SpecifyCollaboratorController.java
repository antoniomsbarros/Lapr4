package eapli.base.clientusermanagement.application;

import eapli.base.clientusermanagement.domain.*;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.funcaomanagement.aplication.AddFunctionController;
import eapli.base.funcaomanagement.aplication.FunctionService;
import eapli.base.funcaomanagement.domain.Function;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.RandomRawPassword;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author marly
 */
public class SpecifyCollaboratorController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository collaboratorRepository = PersistenceContext.repositories().clientUsers();
    private final AddUserController addUserController = new AddUserController();
    private final FunctionService functionService = new FunctionService();



    public void specifyCollaborator(final String mecanographicNumber, final String fullName, final Function function,
                                    final String email, final Calendar birth, final Long phoneNumber,
                                    final String shortname, final Placeofresidence placeofresidence, Set<Role> roleTypes) throws IllegalAccessException {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.RRH_MANAGER,
               BaseRoles.ADMIN);

        Optional<Function> optionalFunction = functionService.findbyName(function.Name());

        if (!optionalFunction.isPresent()){
            throw new IllegalAccessException("ERROR: Function does not exist!");
        }

        Optional<ClientUser> collaboratorExist = collaboratorRepository.findByMecanographicNumber(new MecanographicNumber(mecanographicNumber));

        if (collaboratorExist.isPresent()){
            throw new IllegalAccessException("ERROR: This Collaborator already exist!");
        }

        RandomPassword randomPassword = new RandomPassword();
        System.out.println("PALAVRA-PASSE: " + randomPassword.toString());

        String[] name = shortname.split(" ", 2);

        try{
            SystemUser systemUser = this.addUserController.addUser(email, randomPassword.toString(), name[0], name[1],
                    email, roleTypes);
            final ClientUser colaborador = new ClientUser(new MecanographicNumber(mecanographicNumber),
                    Description.valueOf(fullName), optionalFunction.get(), new CollaboratorEmail(email), new Dateofbirth(birth),
                    phoneNumber, Designation.valueOf(shortname), placeofresidence, systemUser);
            collaboratorRepository.save(colaborador);
            System.out.println("\nCollaborator saved!");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("\nERROR: Collaborator shortname too short!");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }

    public void specifyCollaboratorWithResponsible(final String mecanographicNumber, final String fullName,
                                                   final Function function, final String email, final Calendar birth,
                                                   final Long phoneNumber, final String shortname,
                                                   final Placeofresidence placeofresidence, Set<Role> roleTypes,
                                                   final ClientUser clientUser) throws IllegalAccessException {

       authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.RRH_MANAGER,
                BaseRoles.ADMIN);

        Optional<Function> optionalFunction = functionService.findbyName(function.Name());
        Optional<ClientUser> optionalClientUser = collaboratorRepository.findByMecanographicNumber(clientUser.mecanographicNumber());

        if (!optionalFunction.isPresent()){
            throw new IllegalAccessException("ERROR: Function does not exist!");
        }

        if (!optionalClientUser.isPresent()){
            throw new IllegalAccessException("ERROR: Collaborator Responsible does not exist!");
        }

        Optional<ClientUser> collaboratorExist = collaboratorRepository.findByMecanographicNumber(new MecanographicNumber(mecanographicNumber));

        if (collaboratorExist.isPresent()){
            throw new IllegalAccessException("ERROR: This Collaborator already exist!");
        }

        RandomPassword randomPassword = new RandomPassword();
        System.out.println("PALAVRA-PASSE: " + randomPassword.toString());

        String[] name = shortname.split(" ", 2);
        try{
            SystemUser systemUser = this.addUserController.addUser(email, randomPassword.toString(), name[0], name[1],
                    email, roleTypes);
            final ClientUser colaborador = new ClientUser(new MecanographicNumber(mecanographicNumber),
                    Description.valueOf(fullName), optionalFunction.get(), new CollaboratorEmail(email), new Dateofbirth(birth),
                    phoneNumber, Designation.valueOf(shortname), placeofresidence, systemUser, optionalClientUser.get());
            collaboratorRepository.save(colaborador);
            System.out.println("\nCollaborator saved with Responsible!");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("\nERROR: Collaborator shortname too short!");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }

    public Iterable<Function> allFunctions(){ return functionService.functions();}

    public Iterable<ClientUser> allCollaborators(){ return collaboratorRepository.findAllActive();}

}
