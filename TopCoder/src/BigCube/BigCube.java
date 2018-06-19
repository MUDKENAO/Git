	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=2823
	 
	* @author Z.SUN
	* @version 2018年6月19日 下午1:48:48
	*/

package BigCube;

public class BigCube {

	public String largestCube(String[] range) {
		long intervals[][] = new long[range.length][2];
		long limit = -1;
		for (int i = 0; i < intervals.length; i++) {
			String fields[] = range[i].split("-");
			for (int j = 0; j < fields.length; j++) {
				intervals[i][j] = Long.parseLong(fields[j]);
			}
			limit = Math.max(limit, intervals[i][1]);
		}
		for (int i = (int) Math.ceil(Math.pow(limit, 1.0 / 3)); i >= 0; i--) {
			long cube = (long) i * i * i;
			for (long interval[] : intervals) {
				if (cube >= interval[0] && cube <= interval[1]) {
					return cube + "";
				}
			}
		}
		return "";
	}

	public static void main(String args[]){
		String range[] = {"0-0","2-2","3-3","4-4","5-5","6-6","7-7","9-9","10-10","12-12",
				 "14-14","16-16","18-18","20-20","22-22","24-24","26-26","28-28",
				 "30-30","32-32","34-34","36-36","38-38","40-40","42-42","44-44",
				 "46-46","48-48","50-50","52-52","54-54","56-56","58-58","60-60",
				 "62-62","65-65","67-67","69-69","71-71","73-73","75-75","77-77",
				 "79-79","81-81","83-83","85-85","87-87","89-89","99-99",
				  "999970000300000-999999999999999" };
		System.out.println(new BigCube().largestCube(range));
	}

}
