import java.util.ArrayList;

//Given a singly linked list where elements are sorted in ascending order,
//convert it to a height balanced BST.
public class ConvertSortedListtoBinarySearchTree {
	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
	public TreeNode sortedListToBST(ListNode head) {
		ArrayList<Integer> a=new ArrayList<Integer>();
        ArrayList<Integer> b=new ArrayList<Integer>();
		while (head!=null) {
			a.add(head.val);
			head=head.next;
		}
		if (a.isEmpty()) {
			return null;
		}
		inOrder(a, b, 0, a.size()-1);
		
		TreeNode root=new TreeNode(b.get(0));
		for (int i = 1; i < b.size(); i++) {
			int k=b.get(i);
			TreeNode x=root;
			TreeNode y=null;
			while (x!=null) {
				y=x;
				if (k<x.val) {
					x=x.left;
				}else {
					x=x.right;
				}
			}
			TreeNode z=new TreeNode(k);
			if (k<y.val) {
				y.left=z;
			}else {
				y.right=z;
			}			
		}
		return root;
    }
	public void inOrder(ArrayList<Integer> a,ArrayList<Integer> b,int l,int h) {
		if (l<=h) {
			b.add(a.get((l+h)/2));
			inOrder(a, b,l, (l+h)/2-1);
			inOrder(a, b,(l+h)/2+1,h);
		}
    }
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
//		inOrder(a, 0, a.length-1);
		System.out.println(1<<1);
		System.out.println(3&4&5&6&7);
	}

}
