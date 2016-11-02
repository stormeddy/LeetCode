import java.time.Year;
import java.util.ArrayList;


public class PalindromLinkedList {

	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	 public static boolean isPalindrome(ListNode head) {
	        ArrayList<Integer> a=new ArrayList<>();
	        while(head!=null){
	            a.add(head.val);
	            head=head.next;
	        }
	        int n=a.size();
	        int x,y;
	        for(int i=0;i<n/2;i++){
	            if(!a.get(i).equals(a.get(n-i-1))) return false;
	        }
	        return true;
	        
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={-16557,-8725,-29125,28873,-21702,15483,-28441,-17845,-4317,-10914,-10914,-4317,-17845,-28441,15483,-21702,28873,-29125,-8725,-16557};
		ListNode head=new ListNode(a[0]),tail=head;
		for (int i = 1; i < a.length; i++) {
			ListNode x=new ListNode(a[i]);
			tail.next=x;
			tail=x;
		}
		System.out.println(isPalindrome(head));
		
		String s="sjfo";
		System.out.println(s.indexOf('j'));
		StringBuilder sb=new StringBuilder(s);
		sb.insert(0, sb);
		s.indexOf("s");
	}

}
