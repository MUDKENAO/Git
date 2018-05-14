/*problem statement:
	https://community.topcoder.com/stat?c=problem_statement&pm=3100&rd=5864
*/
package AccessLevel;

public class AccessLevel {
	public String canAccess(int[] rights, int minPermission) {
		String access = "";
		for (int right : rights) {
			access += (right >= minPermission) ? "A" : "D";
		}
		return access;
	}
	
	public static void main(String args[]) {
		int rights[] = {34,78,9,52,11,1};
		int permission = 49;
		
		System.out.println(new AccessLevel().canAccess(rights, permission));
	}
}