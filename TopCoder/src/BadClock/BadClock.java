/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=1969
*/
package BadClock;

public class BadClock {
	final int SECONDS_IN_12_HOURS = 43200;

	public double nextAgreement(String trueTime, String skewTime, int hourlyGain) {
		int trueSecond = convertToSecond(trueTime);
		int skewSecond = convertToSecond(skewTime);
		int secondDiff = diff(trueSecond, skewSecond);
		if (secondDiff * hourlyGain < 0) {
			secondDiff = complement(secondDiff);
		}
		hourlyGain = Math.abs(hourlyGain);
		return (double) secondDiff / hourlyGain;
	}

	int diff(int second1, int second2) {
		return (second1 - second2 + SECONDS_IN_12_HOURS) % SECONDS_IN_12_HOURS;
	}

	int complement(int second) {
		return SECONDS_IN_12_HOURS - second;
	}

	int convertToSecond(String time) {
		int hour = Integer.parseInt(time.substring(0, 2));
		int minute = Integer.parseInt(time.substring(3, 5));
		int second = Integer.parseInt(time.substring(6));
		return hour * 3600 + minute * 60 + second;
	}
	
	public static void main(String args[]) {
		String trueTime = "03:03:02";
		String skewTime = "03:01:47";
		int hourlyGain = -5;
		
		System.out.println(new BadClock().nextAgreement(trueTime, skewTime, hourlyGain));
	}
}