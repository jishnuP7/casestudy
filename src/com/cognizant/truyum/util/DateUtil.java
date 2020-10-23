package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date) {
		
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		Date parseDate=new Date();
		try {
			parseDate = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Date not in correct format");
			e.printStackTrace();
		}
		
		
		
		return parseDate;
		
	}

}
