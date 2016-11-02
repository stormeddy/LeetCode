import javax.xml.soap.Node;

/*Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6*/
public class FlattenBinaryTreetoLinkedList {

//	  Definition for a binary tree node.
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	public void flatten(TreeNode root) {
        preOrder(root);
        
    }
    
    private TreeNode preOrder(TreeNode root){
        if (root==null) {
			return null;
		}
        TreeNode le=root.left;
        TreeNode ri=root.right;
        root.right=preOrder(le);
        root.left=preOrder(ri);
        TreeNode x=root;
        TreeNode y=null;
        while (x!=null) {
			y=x;
			x=x.right;
		}
        y.right=root.left;
        root.left=null;
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
