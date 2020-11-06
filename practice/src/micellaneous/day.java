package micellaneous;

import java.util.*;
import java.util.Date;

public class day {
	
	public Date day(int year, int month,int day) {
		
		Date date= day(year, month, day);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return date;
	}

}
