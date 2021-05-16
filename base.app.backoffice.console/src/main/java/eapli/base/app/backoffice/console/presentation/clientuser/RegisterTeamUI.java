package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.teamManagement.application.RegisterTeamController;
import eapli.base.teamManagement.domain.Acronym;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.TeamType;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class RegisterTeamUI extends AbstractUI {
    private RegisterTeamController registerTeamController;

    public RegisterTeamUI() {
        this.registerTeamController =new RegisterTeamController();
    }

    @Override
    protected boolean doShow() {




        String acronmy = Console.readLine("Create one acronym for the team: ");
        String designcao = Console.readLine("Please create Designaction for the Team: ");


        Set<ClientUser> clientUserSet = new HashSet<>();
       ClientUser responsable = null;
        TeamType teamType=null;
        boolean aux = false;
        Map<Integer, TeamType> teamTypeMap=new HashMap<>();
        int position=0;
        Iterator<TeamType> teamIterior=registerTeamController.allteamTypes().iterator();
        while (teamIterior.hasNext()){
            TeamType teamType1=teamIterior.next();
            teamTypeMap.put(position, teamType1);
            System.out.println(position+": "+teamType1);
            position++;
        }

        System.out.println("Insert the number of the collaborator to be Responsable:");
        position=-1;
        while (!teamTypeMap.containsKey(position)){
            position=Console.readInteger("");
        }
        teamType=teamTypeMap.get(position);
        /*while ( aux!=true &&  ) {
            TeamType temp = registerTeamController.allteamTypes().iterator().next();
            System.out.println(temp);
            String answer = Console.readLine("This TeamType (y/n)");
            System.out.println();

            if (answer.equals("y")) {
                System.out.println(answer);
                teamType = temp;
                aux = true;
                System.out.println(aux);
            }
        }*/


        if (teamType==null){
            System.out.println("You didnt select any Team Type");
            return false;
        }


        System.out.println("Select the collaborator responsable for the team: ");
        aux = false;
        Map<Integer, ClientUser> clientUserMap=new HashMap<>();
        Iterator<ClientUser> iterator=registerTeamController.allColaborators().iterator();
        position=0;
        while (iterator.hasNext()) {
            ClientUser temp = iterator.next();
            System.out.println(position+": "+ temp);
            clientUserMap.put(position, temp);
            position++;
        }
        position=-1;
        while (!clientUserMap.containsKey(position)){
            position=Console.readInteger("");
        }
        responsable=clientUserMap.get(position);
            if (responsable == null) {
                System.out.println("You didnt select any collaborator");
                return false;
            }

            List<String> codesused=new ArrayList<>();

            registerTeamController.allTeams().forEach( team->{
                codesused.add(team.identity().Code());
            });

        for (String str: codesused
             ) {
            System.out.println(str);
        }
        String uniquecode=Console.readLine("Insert a Unique Code for the Team: ");
        while (codesused.contains(uniquecode)){
            System.out.println("You cant use this Unique code, please insert other:");
            uniquecode=Console.readLine("");
        }

            if (uniquecode.isEmpty()){
                System.out.println("You didint created a Unique Code");
                return false;
            }

             registerTeamController.registerTeam(uniquecode, responsable, clientUserSet, designcao, acronmy, teamType);
        //System.out.println(team.toString());
            return true;
        }

    @Override
    public String headline() {
        return "Register Team";
    }
}
