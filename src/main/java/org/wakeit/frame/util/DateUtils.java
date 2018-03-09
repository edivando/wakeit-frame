/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

public class DateUtils {


    public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
	
	public static String getWeekDay(Date day){
		Calendar c = Calendar.getInstance();
		c.setTime(day);
		return c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("pt", "BR"));
	}
	
	// Qua|06-Abr
	public static String getMenuFilterDate(Date date){
	    SimpleDateFormat format = new SimpleDateFormat("EEEE | MMMM-dd", new Locale("pt", "BR"));
	    return format.format(date);
	}
	
	/**
	 * 0 SUNDAY <br/>
	 * 1 MONDAY <br/>
	 * 2 TUESDAY <br/>
	 * 3 WEDNESDAY <br/>
	 * 4 THURSDAY <br/>
	 * 5 FRIDAY <br/>
	 * 6 SATURDAY <br/>
	 */
	public static int dayOfWeek(){
		int weekday = now().getDayOfWeek();
		return weekday == 7 ? 0 : weekday;
	}
	
	public static int hourOfDay(){
		return now().getHourOfDay();
	}
	
	public static Date localDate(){
		return now().toDate();
	}
	
	public static Calendar localCalendar(){
		return Calendar.getInstance(TimeZone.getTimeZone("America/Fortaleza"));
	}
	
	public static LocalDateTime now(){
		return LocalDateTime.now(DateTimeZone.forID("America/Fortaleza"));
	}
	
	public static LocalDate day(){
		return LocalDate.now(DateTimeZone.forID("America/Fortaleza"));
	}
	
	public static int getNextMonth(Integer month) {
		if (month == null) {
			return now().getMonthOfYear()+1;
		}
		if (month == 12) {
			return 1;
		} else {
			return ++month;
		}
	}

	public static int getNextYear(Integer month, Integer year) {
		if (month == null) {
			month = 0;
		}
		if(year == null){
			year = now().getYear();
		}
		if (month == 12) {
			return ++year;
		} else {
			return year;
		}
	}
	
	public static Integer getPreviousMonth(Integer month) {
		if (month == null) {
			month = 0;
		}
		if (month == 1) {
			return 12;
		} else {
			return --month;
		}
	}

	public static Integer getPreviousYear(Integer month, Integer year) {
		if (month == null) {
			month = 0;
		}
		if(year == null){
			year = now().getYear();
		}
		if (month == 1) {
			return --year;
		} else {
			return year;
		}
	}
	
	
	public static Date getFirstDayOfMonth(Date date, int amount){
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.MONTH, amount);
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
	    return c.getTime();
	}
	
	public static Date getLastDayOfMonth(Date date, int amount){
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.MONTH, amount);
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
	    return c.getTime();
	}
	
	public static Date getFirstDayOfWeek(Date date, int amount){
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.WEEK_OF_MONTH, amount);
	    c.set(Calendar.DAY_OF_WEEK, c.getActualMinimum(Calendar.DAY_OF_WEEK));
	    return c.getTime();
	}
	
	public static Date getLastDayOfWeek(Date date, int amount){
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.WEEK_OF_MONTH, amount);
	    c.set(Calendar.DAY_OF_WEEK, c.getActualMaximum(Calendar.DAY_OF_WEEK));
	    return c.getTime();
	}
	
	public static Integer getWeek(Date date){
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    return c.get(Calendar.WEEK_OF_YEAR);
	}
	
	public static String getFormattedMonthDescription(int month){
		// TODO: Da pra fazer melhor; Usar Calendar; Colocar na classe DateUtils
		String formattedMonth = "";
		
		switch (month) {
		case 1: formattedMonth = "Janeiro";
			break;
		case 2: formattedMonth = "Fevereiro";
		break;
		case 3: formattedMonth = "Março";
		break;
		case 4: formattedMonth = "Abril";
		break;
		case 5: formattedMonth = "Maio";
		break;
		case 6: formattedMonth = "Junho";
		break;
		case 7: formattedMonth = "Julho";
		break;
		case 8: formattedMonth = "Agosto";
		break;
		case 9: formattedMonth = "Setembro";
		break;
		case 10: formattedMonth = "Outubro";
		break;
		case 11: formattedMonth = "Novembro";
		break;
		case 12: formattedMonth = "Dezembro";
		break;

		default:
			break;
		}
	
		return formattedMonth;	
	}
	
	public static String getFormattedMonth(Integer month){
		if(month < 10){
			return "0"+month;
		}
		return month.toString();
	}
	
	
	public static void main(String[] args){
		System.out.println(getFirstDayOfMonth(day().toDate(), 0));
		System.out.println(getLastDayOfMonth(day().toDate(), 0));
		
		System.out.println(getFirstDayOfWeek(day().toDate(), 0));
		System.out.println(getLastDayOfWeek(day().toDate(), 0));
	}
	
}
