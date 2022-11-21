package Servidor;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Time implements ITime {
	
	public int getHour() {
		Calendar date = new GregorianCalendar();
		int hour = date.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
	
	public int getMinute() {
		Calendar date = new GregorianCalendar();
		int minute = date.get(Calendar.MINUTE);
		return minute;
	}
	
	public int getSeconds() {
		Calendar date = new GregorianCalendar();
		int second = date.get(Calendar.SECOND);
		return second;
	}

}