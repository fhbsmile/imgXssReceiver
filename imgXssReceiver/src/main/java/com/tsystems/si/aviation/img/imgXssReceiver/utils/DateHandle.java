package com.tsystems.si.aviation.img.imgXssReceiver.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHandle {
	static SimpleDateFormat fmtShortDate = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat fmtStandardDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	static SimpleDateFormat fmtLongDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    public static Date getDateByString_fmtShortDate(String timeString){
   	 Date date =null;
   	 try {
			 date = fmtShortDate.parse(timeString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

   	 return date;
    }
    
    public static Date getDateByString_fmtStandardDate(String timeString){
      	 Date date =null;
      	 try {
   			 date = fmtStandardDate.parse(timeString);
   		} catch (ParseException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		} 

      	 return date;
       }
    
    public static String getStringByDate_fmtStandardDate(Date date){
    	String dateString =null;
  			dateString = fmtLongDate.format(date);
     	 return dateString;
      }
}
