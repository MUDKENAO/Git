/**
 * 
 */
package AddTwoNumbers;

import AddTwoNumbers.ListNode;
import java.util.Scanner;



/**
 * @author Z.SUN
 *
 */
public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode num1, ListNode num2){
		ListNode dummy = new ListNode(0), cur = dummy;
		
		for (int carry = 0; num1 != null || num2 != null || carry >0;) {
			int foo1 = num1 != null ? num1.val : 0;
			num1 = num1 != null ? num1.next : null;
			
			int foo2 = num2 != null ? num2.val: 0;
			num2 = num2 != null ? num2.next: null;
			
			int sum = foo1 + foo2 + carry;
			ListNode node = new ListNode(sum%10);
			carry = sum/10;
			cur.next = node;
			cur = node;
		}
		return dummy.next;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode num1 = new ListNode(0), num2 = new ListNode(0);
		ListNode cur1 = num1, cur2 = num2;
		
		System.out.println("input the first list in reverse order, end with ENTER");
		@SuppressWarnings("resource")
		Scanner input1 = new Scanner(System.in);
		while (input1.hasNextInt()) {
			ListNode foo1 = new ListNode(input1.nextInt());
			cur1.next = foo1;
			cur1 = foo1;
			
		}
		
		System.out.println("input the second list, end with ENTER");
		@SuppressWarnings("resource")
		Scanner input2 = new Scanner(System.in);
		while (input2.hasNextInt()) {
			ListNode foo2 = new ListNode(input2.nextInt());
			cur2.next = foo2;
			cur2 = foo2;
		}

		/*
		 * 用num1.next而不是num1, 是为了跳过num1初始化时产生的第一个0值node
		 * */
		ListNode ret = addTwoNumbers(num1.next, num2.next);

		ListNode pt = ret;
		while(ret != null)
		{
			System.out.print(ret.val);
			if (ret.next != null) {
				pt = ret.next;
				ret = pt;
			}else
				break;
			System.out.print("->");
		}
	}

}
