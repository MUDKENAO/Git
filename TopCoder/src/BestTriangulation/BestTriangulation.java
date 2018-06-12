/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=5923
*/
package BestTriangulation;

public class BestTriangulation {
	public double maxArea(String[] vertices) {
		Point points[] = new Point[vertices.length];
		for (int i = 0; i < points.length; i++) {
			String fields[] = vertices[i].split(" ");
			points[i] = new Point(
					Integer.parseInt(fields[0]),
					Integer.parseInt(fields[1]));
		}
		double result = -1;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				for (int k = j
						+ 1; k < points.length; k++) {
					double area = Math
							.abs(points[i].x * points[j].y
									- points[i].y
											* points[j].x
									+ points[j].x
											* points[k].y
									- points[j].y
											* points[k].x
									+ points[k].x
											* points[i].y
									- points[k].y
											* points[i].x)
							/ 2.0;
					result = Math.max(result, area);
				}
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		
		String vertices[] = {"10000 3469", "9963 712", "9957 634", "9834 271", "9700 165",
				 "9516 46", "8836 4", "1332 57", "229 628", "171 749",
				 "52 1269", "30 1412", "7 4937", "35 8676", "121 9917",
				 "2247 9960", "3581 9986", "6759 9995", "9486 9998", "9888 9890",
				 "9914 9318", "9957 8206", "9998 6402"} ;
		
		System.out.println(new BestTriangulation().maxArea(vertices));
		
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
