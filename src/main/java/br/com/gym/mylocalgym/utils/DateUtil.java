package br.com.gym.mylocalgym.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Luciano
 */
public class DateUtil {
        
    public static LocalDate convertDateToLocalDate(Date date){
        
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        
    } 
    
}
