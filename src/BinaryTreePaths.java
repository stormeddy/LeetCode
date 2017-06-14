import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]*/
public class BinaryTreePaths {

	class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	 public List<String> binaryTreePaths(TreeNode root) {
	        List<String> s=new ArrayList<>();
	        helper(root,s);
	        return s;
	    }
	    
	    public void helper(TreeNode root,List<String> s){
	        if(root==null) return;
	        if(root.right!=null&&root.left!=null){
	            helper(root.right,s);
	            s.add(0,new String(root.val+"->"+s.get(0)));
	            helper(root.left,s);
	            s.add(0,new String(root.val+"->"+s.get(0)));
	        }else if(root.right!=null){
	            helper(root.right,s);
	        }else if(root.left!=null){
	            helper(root.left,s);
	        }else{
	            s.add(0,new String(root.val+""));
	        }
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
