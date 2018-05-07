package com.example.android.guardiannewsfeed.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private DateUtils(){}

    public static String isoDateToNormal(String isoDate){
        SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Date date = new Date();
        try{
            date = sd1.parse(isoDate.replaceAll("Z$", "+0000"));
        } catch(Exception e){
            System.out.println(e.getMessage());
            return "Non-accessible";
        }
        SimpleDateFormat sd2 = new SimpleDateFormat("dd-MM-yyyy");
        return sd2.format(date);
    }
}
