
/*Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.*/
import java.util.Stack;


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> s;
    TreeNode x;
    public BSTIterator(TreeNode root) {
        s=new Stack<TreeNode>();
        x=root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty()||x!=null;
    }

    /** @return the next smallest number */
    public int next() {
        while(x!=null){
                s.push(x);
                x=x.left;
            }
            x=s.pop();
            int ret=x.val;
            x=x.right;
            return ret;
    }
    
    
    public static void main(String[] args) {
    	TreeNode t=new TreeNode(1);
		BSTIterator b=new BSTIterator(t);
		while (b.hasNext()) {
			System.out.println(b.next());
		}
	}
    static class TreeNode {
    	 int val;
    	 TreeNode left;
    	 TreeNode right;
    	 TreeNode(int x) { val = x; }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
