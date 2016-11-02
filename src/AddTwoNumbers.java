
public class AddTwoNumbers {
/*	You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8*/
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	 static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	 }
	 
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        int cin=0;
	        ListNode p=new ListNode(0);
	        ListNode q=null;
	        ListNode head=p;
	        while(l1!=null&&l2!=null){
	            q=new ListNode(0);
	            int t=l1.val+l2.val+cin;
	            if(t>=10){
	                q.val=t-10;
	                cin=1;
	            }else{
	                q.val=t;
	                cin=0;
	            }
	            p.next=q;
	            p=p.next;
	            l1=l1.next;
	            l2=l2.next;
	        }
	        while(l2!=null){
	            q=new ListNode(0);
	            int t=l2.val+cin;
	            if(t>=10){
	                q.val=t-10;
	                cin=1;
	            }else{
	                q.val=t;
	                cin=0;
	            }
	            p.next=q;
	            p=p.next;
	            l2=l2.next;
	        }
	        while(l1!=null){
	            q=new ListNode(0);
	            int t=l1.val+cin;
	            if(t>=10){
	                q.val=t-10;
	                cin=1;
	            }else{
	                q.val=t;
	                cin=0;
	            }
	            p.next=q;
	            p=p.next;
	            l1=l1.next;
	        }
	        if (cin==1) {
	        	q=new ListNode(0);
	        	q.val=cin;
	        	p.next=q;
			}
	        return head.next;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={5};
		int[] b={5};
		ListNode p=new ListNode(0);
		ListNode q=new ListNode(0);
		ListNode l1=p;
		ListNode l2=q;
		for (int i = 0; i < a.length; i++) {
			ListNode t=new ListNode(a[i]);
			p.next=t;
			p=p.next;
		}
		for (int i = 0; i < b.length; i++) {
			ListNode t=new ListNode(b[i]);
			q.next=t;
			q=q.next;
		}
		ListNode ans=addTwoNumbers(l1.next, l2.next);
		l1=l1.next;
		l2=l2.next;
		while(l1!=null){
			System.out.print(l1.val+" ");
			l1=l1.next;
		}
		System.out.println();
		while(l2!=null){
			System.out.print(l2.val+" ");
			l2=l2.next;
		}
		System.out.println();
		while(ans!=null){
			System.out.print(ans.val+" ");
			ans=ans.next;
		}
		
	}

}
