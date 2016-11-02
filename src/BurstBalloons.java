/*Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167*/
public class BurstBalloons {

	 public static int maxCoins(int[] nums) {
	        int[] newnums = new int[nums.length + 2];
	        int n = 1;
	        for (int x : nums) if (x > 0) newnums[n++] = x;
	        newnums[0] = newnums[n++] = 1;


	        int[][] memo = new int[n][n];
	        return burst(memo, newnums, 0, n - 1);
	    }

	    public static int burst(int[][] memo, int[] nums, int left, int right) {
	        if (left + 1 == right) return 0;
	        if (memo[left][right] > 0) return memo[left][right];
	        int ans = 0;
	        for (int i = left + 1; i < right; ++i)
	        	//i为最后一个burst的气球
	            ans = Math.max(ans, nums[left] * nums[i] * nums[right] + burst(memo, nums, left, i) + burst(memo, nums, i, right));
	        memo[left][right] = ans;
	        return ans;
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxCoins(new int[]{3,1,5,8}));

	}

}
