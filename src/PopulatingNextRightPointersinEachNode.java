import java.util.LinkedList;

/*Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL*/
public class PopulatingNextRightPointersinEachNode {

	 public static void connect(TreeLinkNode root) {
	        LinkedList<TreeLinkNode> q1=new LinkedList<>();
	        LinkedList<TreeLinkNode> q2=new LinkedList<>();
	        q1.offer(root);
	        TreeLinkNode pre=null;
	        while(q1.peek()!=null){
	        while(!q1.isEmpty()){
	            if(pre==null){
	                pre=q1.poll();
	                q2.offer(pre.left);
	                q2.offer(pre.right);
	            }
	            else{
	                pre.next=q1.poll();
	                pre=pre.next;
	                q2.offer(pre.left);
	                q2.offer(pre.right);
	            }
	            
	        }
	        pre=null;
	        LinkedList<TreeLinkNode> t=q1;
	            q1=q2;
	            q2=t;
	        }
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode t1=new TreeLinkNode(1);
		TreeLinkNode t2=new TreeLinkNode(2);
		TreeLinkNode t3=new TreeLinkNode(3);
		t1.left=t2;
		t1.right=t3;
		connect(t1);
		
	}
	
	public static class TreeLinkNode {
		      int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
		  }

}
