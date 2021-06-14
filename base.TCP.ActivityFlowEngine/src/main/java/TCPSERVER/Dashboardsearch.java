package TCPSERVER;

import eapli.base.catalogmanagement.application.SearchActivity;
import eapli.base.catalogmanagement.domain.Activity;
import eapli.base.taskmanagement.domain.ManualTask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Dashboardsearch {
    private SearchActivity searchActivity;

    public Dashboardsearch() {
        this.searchActivity = new SearchActivity();
    }

    public String[] data(Integer number, String option){
        List<ManualTask> activityList=searchActivity.prepareTask(number);
        switch (option){
            case "3":
                return preparelistofActivitysincomplete( activityList);
            case "4":
                return allActivitys(activityList);
            case "5":
                String[] result=new String[0];
                try {
                    result= activitysByPriority(activityList);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return result;
            default:
                return new String[1];
        }
    }
    private String[] preparelistofActivitysincomplete(List<ManualTask> activityList ){
        int cont=0;
        for (ManualTask a: activityList) {
            if (a.state().toString().equals("PENDING")){
                cont++;
            }
        }
        String[] temp=new String[cont];
        int y=0;
        for (int i = 0; i < activityList.size(); i++) {
            if (activityList.get(i).state().toString().equals("PENDING")){
                ManualTask activity=activityList.get(i);
                    temp[y]="Activity N: " +activity.identity()+" Priority: "+activity.priority()+
                            " DeadLine: " +activity.deadline().toString();
                y++;
            }
        }
        return temp;
    }
    private List<ManualTask> prepareremaningTestbydate(List<ManualTask>activityList) throws ParseException {
        List<ManualTask> temp=new ArrayList<>();
        for (ManualTask a: activityList) {
            if (a.deadline().Date().after(new Date()) && a.state().equals("PENDING")){
                temp.add(a);
            }
        }
        return temp;
    }


    private List<ManualTask>prepareactitivityByPriority(List<ManualTask>activityList) throws ParseException {
        List<ManualTask> temp=new LinkedList<>(activityList);
        List<ManualTask> resoluction=new ArrayList<>();
        ManualTask tempactivity=null;
        Long priority=99999L;
       while (temp.size()!=0){
            tempactivity=temp.get(0);
           for (ManualTask ma: temp) {
               if (tempactivity.priority()> ma.priority()){
                   tempactivity=ma;
               }
           }
           temp.remove(tempactivity);
           resoluction.add(tempactivity);

       }
        return resoluction;
    }
    private String[] activitysByPriority(List<ManualTask>activityList) throws ParseException {
        List<ManualTask> listofactivitysbypriority=prepareactitivityByPriority(activityList);
        String[] result=new String[activityList.size()];
        int i=0;
        for (ManualTask activity:listofactivitysbypriority) {
                result[i]="Activity N: " +activity.identity()+" Priority: "+activity.priority()+
                        " DeadLine: " +activity.deadline().toString();
            i++;
        }
        return result;
    }
    private String[] allActivitys(List<ManualTask>activityList){

        String[] temp=new String[activityList.size()];
        int i=0;
        for (ManualTask activity:activityList) {
                temp[i]="Activity N: " +activity.identity()+" Priority: "+activity.priority()+
                        " DeadLine: " +activity.deadline().toString();

            i++;
        }
        return temp;
    }
}
