	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=1739
	 
	* @author Z.SUN
	* @version 2018年8月13日 下午6:21:21
	*/
package Birthday;

import java.util.Arrays;
import java.util.Comparator;

public class Birthday {
	public String getNext(String date, String[] birthdays) {
		for (int i = 0; i < birthdays.length; i++) {
			birthdays[i] = birthdays[i].split(" ")[0];
		}
		Arrays.sort(birthdays, new DateComparator(date));
		return birthdays[0];
	}
	
	public static void main(String args[]){
		String date = "01/02";
		String[] birthdays = {
				 "02/17 Wernie",
				 "10/12 Stefan",
				 "02/17 MichaelJordan",
				 "10/12 LucianoPavarotti",
				 "05/18 WilhelmSteinitz"};
		System.out.println(new Birthday().getNext(date, birthdays));
	}
}

class DateComparator implements Comparator<String> {
	String base;
	
	DateComparator(String base) {
		this.base = base;
	}

	public int compare(String birthday1, String birthday2) {
		return distance(birthday1) - distance(birthday2);
	}

	int distance(String date) {
		return (distanceFromOrigin(date) - distanceFromOrigin(base) + 365)
				% 365;
	}

	int distanceFromOrigin(String date) {
		int month = Integer.parseInt(date.substring(0, 2));
		int day = Integer.parseInt(date.substring(3));
		return (month - 1) * 31 + (day - 1);
	}
}
