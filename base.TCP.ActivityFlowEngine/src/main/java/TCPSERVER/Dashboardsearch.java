package TCPSERVER;

import eapli.base.catalogmanagement.application.SearchActivity;
import eapli.base.catalogmanagement.domain.Activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Dashboardsearch {
    private SearchActivity searchActivity;

    public Dashboardsearch() {
        this.searchActivity = new SearchActivity();
    }

    public String[] data(Integer number, String option){
        List<Activity> activityList=searchActivity.prepareactivity(number);
        switch (option){
            case "3":
                return preparelistofActivitysincomplete( activityList);
            case "4":
                return allActivitys(activityList);
            case "5":
                return preparelistofActivitysincomplete(activityList);
            default:
                return new String[1];
        }
    }
    private String[] preparelistofActivitysincomplete(List<Activity> activityList ){
        int cont=0;
        for (Activity a: activityList) {
            if (a.state().toString().equals("EMRESOLUCAO")){
                cont++;
            }
        }
        String[] temp=new String[cont];
        int y=0;
        for (int i = 0; i < activityList.size(); i++) {
            if (activityList.get(i).state().toString().equals("EMRESOLUCAO")){
                Activity activity=activityList.get(i);
                if (activity.criticalitylevel()==null){
                    temp[y]="ActivitY N: " +activity.identity()+" Priority: "+activity.priorityofActivity()+
                            " DeadLine: " +activity.deadline();
                }else{
                    temp[y]="ActivitY N: " +activity.identity()+" Priority: "+activity.priorityofActivity()+
                            " DeadLine: " +activity.deadline()+"criticality: "+activity.criticalitylevel().print();
                }
                y++;
            }
        }
        return temp;
    }
    private List<Activity> prepareremaningTestbydate(List<Activity>activityList){
        List<Activity> temp=new ArrayList<>();
        for (Activity a: activityList) {
            if (a.date().after(Calendar.getInstance()) && a.state().equals("EMRESOLUCAO")){
                temp.add(a);
            }
        }
        return temp;
    }
    private List<Activity>prepareactitivityByPriority(List<Activity>activityList){
        List<Activity> temp=prepareremaningTestbydate(activityList);
        List<Activity> resoluction=new ArrayList<>();
        Activity tempactivity=null;
        Long priority=99999L;
        for (Activity a: activityList) {
            for (Activity a1:activityList) {
                if (a1.priorityofActivity()<priority && !resoluction.contains(a1)){
                    priority=a1.priorityofActivity();
                    tempactivity=a1;
                }
            }
            resoluction.add(tempactivity);
        }
        return resoluction;
    }
    private String[] activitysByPriority(List<Activity>activityList){

        List<Activity> listofactivitysbypriority=prepareactitivityByPriority(activityList);
        String[] result=new String[activityList.size()];
        int i=0;
        for (Activity activity:listofactivitysbypriority) {
            if (activity.criticalitylevel()==null){
                result[i]="Activity N: " +activity.identity()+" Priority: "+activity.priorityofActivity()+
                        " DeadLine: " +activity.deadline();
            }else {
                result[i]="Activity N: " +activity.identity()+" Priority: "+activity.priorityofActivity()+
                        " DeadLine: " +activity.deadline()+"criticality: "+activity.criticalitylevel().print();
            }
            i++;
        }
        return result;
    }
    private String[] allActivitys(List<Activity>activityList){

        String[] temp=new String[activityList.size()];
        int i=0;
        for (Activity activity:activityList) {
            if (activity.criticalitylevel()==null){
                temp[i]="Activity N: " +activity.identity()+" Priority: "+activity.priorityofActivity()+
                        " DeadLine: " +activity.deadline();
            }else {
                temp[i]="Activity N: " +activity.identity()+" Priority: "+activity.priorityofActivity()+
                        " DeadLine: " +activity.deadline()+"criticality: "+activity.criticalitylevel().print();
            }
            i++;
        }
        return temp;
    }
}
