package com.sol.Utils;

import java.sql.Date;
import java.util.Calendar;

public class DateUtils {
	
	/**
	 * This method takes year, month and day numbers and returns a a date of sql.Date format
	 * @param year
	 * @param month
	 * @param day
	 * TODO add validations and exception handling
	 */
	public static Date buildSQLDate(int year, int month, int day) {
		
		if (month < 1 || month > 12 || day < 1 || day > 31 || year < 1000) {
	        throw new IllegalArgumentException("Invalid date");
	    }
		
		Calendar calendar = Calendar.getInstance();        
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        
        int maxDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (day > maxDayOfMonth) {
            throw new IllegalArgumentException("Invalid date: day out of range for given month and year");
        }
        calendar.set(Calendar.DAY_OF_MONTH, day);
        
        
        return new Date(calendar.getTimeInMillis());
	}
	

}
