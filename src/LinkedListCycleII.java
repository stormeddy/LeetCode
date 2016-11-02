/*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?*/
public class LinkedListCycleII {

	public ListNode detectCycle(ListNode head) {
		ListNode p = head;
		ListNode q = head;
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
			if (p == q) {
				ListNode org = p;
				ListNode t = head;
				while (true) {
					p = org;
					while (p.next != org && t != p) {
						p = p.next;
					}
					if (p != head && p.next == org) {
						if (p == p.next) {
							return p;
						} else {
							t = t.next;
						}
					} else
						return t;
				}
			}
		}
		return null;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListCycleII c=new LinkedListCycleII();
		ListNode n0=new ListNode(3);
		ListNode n1=new ListNode(2);
		ListNode n2=new ListNode(0);
		ListNode n3=new ListNode(-4);
		n0.next=n1;
		n1.next=n2;
		n2.next=n3;
		n3.next=n3;
		ListNode ret=c.detectCycle(n0);
		System.out.println(ret.val);
	}
	
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }

	}
}
