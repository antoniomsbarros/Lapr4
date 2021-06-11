package eapli.base.taskmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.general.domain.model.Description;
import eapli.framework.time.util.Calendars;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author marly
 */
@Entity
public class AutomaticTask extends Task implements  DomainEntity<Long> {

    private Description scriptPath;

    public AutomaticTask() {

    }

    public AutomaticTask(TaskState state, Deadline deadline, Integer priority, Description scriptPath){

        super(state, deadline, priority);

        try {
            if (Calendars.now().compareTo(deadline.Date())==1) {
                throw new IllegalArgumentException("Invalid DeadLine!");
            }
        }catch (NullPointerException | IllegalArgumentException e){
            System.out.println("Invalid DeadLine: " + e);
        }
        /*
        File file = new File(scriptPath.toString());
        if(!file.isFile()){
            throw new IllegalArgumentException("The file " + scriptPath.toString() + " does not exist");
        }
        */
        this.scriptPath = scriptPath;
    }

    public void executeScript() throws IOException {
        Preconditions.noneNull(scriptPath.toString());
        Preconditions.nonEmpty(scriptPath.toString());

        File file = new File(scriptPath.toString());
        if(!file.isFile()){
            throw new IllegalArgumentException("The file " + scriptPath.toString() + " does not exist");
        }

        if(isLinux()){
            System.out.println("\tCommand: " + Arrays.toString(new String[]{"/bin/sh", "-c", scriptPath.toString()}));
            Runtime.getRuntime().exec(new String[] {"/bin/sh", "-c", scriptPath.toString()}, null);
            System.out.println("\tProcess Completed.");
        }else if(isWindows()){
            System.out.println("\tCommand: " + "cmd /c start " + scriptPath.toString());
            Runtime.getRuntime().exec("cmd /c start " + scriptPath.toString());
            System.out.println("\tProcess Completed.");
        }
    }

    public static boolean isLinux(){
        String os = System.getProperty("os.name");
        return os.toLowerCase().contains("linux");
    }

    public static boolean isWindows(){
        String os = System.getProperty("os.name");
        return os.toLowerCase().contains("windows");
    }

    @Override
    public String toString() {
        return "AutomaticTask{" +
                "scriptPath=" + scriptPath +
                '}';
    }
    public Description script(){
        return this.scriptPath;
    }
}
