/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.*/
public class PartitionList {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	public static ListNode partition(ListNode head, int x) {
        ListNode fh=new ListNode(-1);
        fh.next=head;
        ListNode p=fh;
        ListNode q=head;
        ListNode pre=fh;
        while(q!=null){
            if(q.val<x){
                if(pre!=p){
                    ListNode temp=q.next;
                    pre.next=temp;
                    q.next=p.next;
                    p.next=q;
                    p=p.next;
                    q=temp;
                }else{
                    pre=q;
                    p=pre;
                    q=q.next;
                }
            }else{
                pre=q;
                q=q.next;
            }
        }
        return fh.next;
    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(1);
		n1.next=n2;
		System.out.println(partition(n1, 2).val);
	}

}
