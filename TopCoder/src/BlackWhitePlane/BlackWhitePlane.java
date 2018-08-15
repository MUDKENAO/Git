/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=4497
	 
	* @author Z.SUN
	* @version 2018年8月15日 下午3:54:51
	*/
package BlackWhitePlane;

import java.util.Arrays;

public class BlackWhitePlane {
	public double area(String[] circles) {
		Circle circleArr[] = new Circle[circles.length];
		for (int i = 0; i < circleArr.length; i++) {
			String fields[] = circles[i].split(" ");
			circleArr[i] = new Circle(Integer.parseInt(fields[0]),
					Integer.parseInt(fields[1]), Integer.parseInt(fields[2]));
		}
		Arrays.sort(circleArr);
		double answer = 0;
		for (int i = 0; i < circleArr.length; i++) {
			if (circleArr[i].whiteOrBlack == null) {
				circleArr[i].whiteOrBlack = true;
			}
			answer += (circleArr[i].whiteOrBlack ? 1 : -1)
					* circleArr[i].getArea();
			for (int j = i + 1; j < circleArr.length; j++) {
				if (Circle.contain(circleArr[i], circleArr[j])) {
					circleArr[j].whiteOrBlack = !circleArr[i].whiteOrBlack;
				}
			}
		}
		return answer;
	}
	
	public static void main(String args[]){
	
		String[] circles = {"2549 8482 11", "9175 5927 35", "2747 6177 93", "5512 8791 81", "4487 8456 60",
				 "6899 610 77", "9716 2202 3", "9312 5625 79", "4020 9851 85", "1640 7179 54", 
				 "5761 4348 51","5917 3436 88","6547 386 33","182 7676 1","6329 4496 89"};
		System.out.println(new BlackWhitePlane().area(circles));
	}
	
}

class Circle implements Comparable<Circle> {
	int x;
	int y;
	int r;
	Boolean whiteOrBlack;

	public Circle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public int compareTo(Circle other) {
		return other.r - r;
	}

	double getArea() {
		return Math.PI * r * r;
	}

	static boolean contain(Circle c1, Circle c2) {
		return square(c1.r - c2.r) > square(c1.x - c2.x) + square(c1.y - c2.y);
	}

	static int square(int n) {
		return n * n;
	}
}