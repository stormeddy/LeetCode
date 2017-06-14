/*The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.*/
public class HouseRobberIII {
//	public int rob(TreeNode root) {
//        if(root==null) return 0;
//    rob1(root);
//    return root.val;
//	}	
//	public int rob1(TreeNode root){
//		if(root==null) return 0;
//		int pre=0;
//		root.val+=rob1(root.left)+rob1(root.right);
//		if(root.left!=null)  pre+=root.left.val;
//		if(root.right!=null)  pre+=root.right.val;
//		root.val=Math.max(pre,root.val);
//			return pre;
//    	}
	
	class Profit{
		   int preprofit;
		   int maxprofit;
		   Profit(int pre,int max){
		       preprofit=pre;
		       maxprofit=max;
		   }
		}
		
	public int rob(TreeNode root) {
		return rob1(root).maxprofit;
	}

	public Profit rob1(TreeNode root) {
		if (root == null)
			return new Profit(0, 0);
		int pre = 0, max = root.val;
		Profit left = rob1(root.left), right = rob1(root.right);
		max += left.preprofit + right.preprofit;
		pre = left.maxprofit + right.maxprofit;
		max = Math.max(pre, max);
		return new Profit(pre, max);
	}
		
	public static void main(String[] args) {
		HouseRobberIII h=new HouseRobberIII();
		TreeNode n1=new TreeNode(10);
		TreeNode n2=new TreeNode(8);
		TreeNode n3=new TreeNode(9);
		n1.left=n2;
		n1.right=n3;
		int ret=h.rob(n1);
		System.out.println(ret);
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
