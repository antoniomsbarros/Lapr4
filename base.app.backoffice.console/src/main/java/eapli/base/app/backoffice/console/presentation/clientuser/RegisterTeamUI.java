package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.teamManagement.application.RegisterTeamController;
import eapli.base.teamManagement.domain.Acronym;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.TeamType;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RegisterTeamUI extends AbstractUI {
    private RegisterTeamController registerTeamController;

    public RegisterTeamUI() {
        this.registerTeamController =new RegisterTeamController();
    }

    @Override
    protected boolean doShow() {
        //final Acronym acronym=



        String acronmy = Console.readLine("Create one acronym for the team: ");
        String designcao = Console.readLine("Please create Designaction for the Team: ");
        Description responsable= Description.valueOf(Console.readLine("Insert the name Responsave: "));
        Description teamType= Description.valueOf(Console.readLine("Insert the team Descriction"));
        Description clientUserSet=Description.valueOf(Console.readLine("Insert the Collaborators: "));
       /*
               Set<ClientUser> clientUserSet = new HashSet<>();
       ClientUser responsable = null;
        TeamType teamType=null;
        boolean aux = false;
        while (registerTeamController.allteamTypes().iterator().hasNext()) {
            TeamType temp = registerTeamController.allteamTypes().iterator().next();
            System.out.println(temp);
            String answer = Console.readLine("This Collaborator (y/n)");
            if (answer.equals("y")) {
                teamType = temp;
                aux = true;
            }
        }
        if (teamType==null){
            System.out.println("You didnt select any Team Type");
            return false;
        }


        System.out.println("Select the collaborator responsable for the team: ");
        aux = false;

        while (registerTeamController.allColaborators().iterator().hasNext() && !aux) {
            ClientUser temp = registerTeamController.allColaborators().iterator().next();
            System.out.println(temp);
            String answer = Console.readLine("This Collaborator (y/n)");
            if (answer.equals("y")) {
                responsable = temp;
                aux = true;
            }
        }
            if (responsable == null) {
                System.out.println("You didnt select any collaborator");
                return false;
            }
            System.out.println("Select the collaborators for the Team: ");
            while (registerTeamController.allColaborators().iterator().hasNext()) {
                ClientUser temp1 = registerTeamController.allColaborators().iterator().next();
                System.out.println(temp1);
                String answer2 = Console.readLine("This Collaborator (y/n)");
                if (answer2.equals("y")) {
                    clientUserSet.add(temp1);
                }
            }*/
            String uniquecode=Console.readLine("Insert a Unique Code for the Team: ");
            /*List<String> codesused=new ArrayList<>();

            registerTeamController.allTeams().forEach( team->{
                codesused.add(team.identity().Code());
            });
            boolean contains=false;


        System.out.println("Insert a Unique Code for the Team: ");
            while (!contains){
                uniquecode=Console.readLine("");
                if (codesused.contains(uniquecode)){
                    System.out.println("Please insert a UniCode that dont existes: ");
                }else {
                    contains=true;
                }
            }
            if (uniquecode.isEmpty()){
                System.out.println("You didint created a Unique Code");
                return false;
            }*/

            registerTeamController.registerTeam(uniquecode, responsable, clientUserSet, designcao, acronmy, teamType);
            return true;
        }

    @Override
    public String headline() {
        return "Register Team";
    }
}
