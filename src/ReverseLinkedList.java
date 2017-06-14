import java.util.HashMap;
import java.util.LinkedList;

/*Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?*/
public class ReverseLinkedList {
	
	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public ListNode reverseList(ListNode head) {
        LinkedList<ListNode> s=new LinkedList<>();
        while(head!=null){
            s.offer(head);
            head=head.next;
        }
        ListNode nh=s.pollLast();
        ListNode pre=nh;
        while(!s.isEmpty()){
            ListNode temp=s.pollLast();
            pre.next=temp;
            pre=temp;
        }
        pre.next=null;
        return nh;
    }

	public void print(ListNode head) {
		while (head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList rll=new ReverseLinkedList();
		ListNode n1=rll.new ListNode(1);
		ListNode n2=rll.new ListNode(2);
		n1.next=n2;
		n2.next=null;
		rll.print(n1);
		ListNode nh=rll.reverseList(n1);
		
		rll.print(nh);
//		LinkedList<ListNode> s=new LinkedList<ReverseLinkedList.ListNode>();
//		s.offer(null);
//		System.out.println(s.isEmpty());
//		String s="s";
//		s.toCharArray();
//		HashMap<Character,Integer> map=new HashMap<>();
//		System.arraycopy(src, srcPos, dest, destPos, length);
	}

}
