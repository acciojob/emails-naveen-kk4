package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings// daa 1 sec wait //

    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);
        calendar = new ArrayList<Meeting>();

    }

    public void addMeeting(Meeting meeting){
       calendar.add(meeting);

    }

    public int findMaxMeetings(){
        if(calendar.size()==0)return 0;
        if(calendar.size()==1)return 1;


        Collections.sort(calendar,(x,y)->{
            if(x.getEndTime().compareTo(y.getEndTime())<0)return -1;
            return 1;
        });
        LocalTime start = calendar.get(0).getEndTime();
        int count = 1;
        for(int i = 1;i<calendar.size();i++){
            LocalTime currS = calendar.get(i).getStartTime();
            LocalTime currE = calendar.get(i).getEndTime();
            if(currS.compareTo(start)>0){
                count++;
                start = currE;
            }
        }
        return count;



        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

    }
}
