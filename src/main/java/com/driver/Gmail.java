package com.driver;

import java.io.*;
import java.util.*;
import com.driver.Mails;




public class Gmail extends Email {


    int inboxCapacity;
    List<Mails> trash;
    List<Mails> inbox;//maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.trash = new ArrayList<Mails>();
        this.inbox = new ArrayList<Mails>();


    }

    public void receiveMail(Date date, String sender, String message){
        Mails m = new Mails(date,sender,message);
        if(inbox.size()==inboxCapacity){
            trash.add(inbox.get(0));
            inbox.remove(0);
        }
        inbox.add(m);
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
       Mails a = null;
       for(Mails m : inbox){
           if(m.getMessage().equals(message)){
               a=m;
               break;
           }
       }
       if(a!=null){
           inbox.remove(inbox.indexOf(a));
           trash.add(a);
       }

    }

    public String findLatestMessage(){
        if(inbox.size()==0)return null;
        return inbox.get((inbox.size()-1)).getMessage();
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox

    }

    public String findOldestMessage(){
        if(inbox.size()==0)return null;
        return inbox.get(0).getMessage();

    }

    public int findMailsBetweenDates(Date start, Date end){
       boolean found = false;
       int count = 0;
       for(Mails m: inbox){
           if(m.getDate().compareTo(start) >= 0){
               found=true;
           }

           if(m.getDate().compareTo(end) > 0){
             break;
           }
           if(found)count++;

       }
       return count;

    }

    public int getInboxSize(){
        return inbox.size();

    }

    public int getTrashSize(){
       return trash.size();

    }

    public void emptyTrash(){
        trash.clear();

    }

    public int getInboxCapacity() {
       return this.inboxCapacity;
    }
}
