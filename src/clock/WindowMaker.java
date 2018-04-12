/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.util.Calendar;
import java.util.TimeZone;

public class WindowMaker {
    
     private final TimeZone tz1;
     private final Calendar calendar;

    public WindowMaker() {
        this.tz1 = TimeZone.getTimeZone("US/Eastern");
        this.calendar = Calendar.getInstance(tz1);
    }
    
    public String idocWindow(){
        //int h = calendar.get(Calendar.HOUR_OF_DAY) + 6;
        
        //return "" +h + getMinutes();
        return forwardSixHours()+getMinutes()+getFascia()+
                " "+getDay()+"-"+ getMonth();
    }

    private int getMonth() {
        return calendar.get(Calendar.MONTH)+1;
    }
    
    public String greatlyWindow(){
        //"ORARIO-MM-GG"
        return ""+currTime() + " "
                + getMonth() +"-"+ forwardDays(6);
    }

    private String forwardSixHours(){
        calendar.add(Calendar.HOUR, 6);
        String s = ""+  calendar.get(Calendar.HOUR);
                calendar.add(Calendar.HOUR, -6);
        return s;
        
    }
    
    
    private String forwardDays(int days) {
        calendar.add(Calendar.DAY_OF_MONTH, days);
        String s = ""+  calendar.get(Calendar.DAY_OF_MONTH);

        calendar.add(Calendar.DAY_OF_MONTH, -days);
        return s;
    }
    
    public String getDay(){
        return ""+ calendar.get(Calendar.DAY_OF_MONTH);
    }
    
    private String getMinutes() {
        int m = calendar.get(Calendar.MINUTE);
        String minuti;
        if (m < 10) {
            minuti = "0" + m;
        } else {
            minuti = Integer.toString(m);
        }
        return minuti;
    }
   
      private String currTime(){         
        int h = calendar.get(Calendar.HOUR);  //hour 12h - HOUR_OF_DAY 24h
       
          String fascia = getFascia();

       return "" + h + getMinutes() + fascia;
    }

    private String getFascia() {
        String fascia;
        int ampm = calendar.get(Calendar.AM_PM);
        if (ampm == 1) //pm
        {
            fascia = "pm";
        } else {
            //am
            fascia = "am";
        }
        return fascia;
    }
}

     
        