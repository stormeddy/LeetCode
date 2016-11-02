/*A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Examples:
Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?*/
public class WiggleSubsequence {

	public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if (n<=1) {
			return n;
		}
        int[] dp=new int[n+1];
        boolean[] up=new boolean[n+1];
        int[] lasti=new int[n+1];
        
        dp[1]=1;
        lasti[1]=0;
        int j=1;
        while (j<n && nums[0]==nums[j]) {
			++j;
		}
        if (j==n) {
			return 1;
		}
        if (nums[0]<nums[j]) {
			dp[j+1]=dp[1]+1;
			lasti[j+1]=j;
			up[j+1]=true;
		}else {
			dp[j+1]=dp[1]+1;
			lasti[j+1]=j;
			up[j+1]=false;
		}
        int pre=j;
        for (int i = j+1; i < n; i++) {
			int cur=nums[i];
			if (cur==nums[pre]) {
				dp[i+1]=dp[pre+1];
				lasti[i+1]=lasti[pre+1];
				up[i+1]=up[pre+1];
			}else if (nums[pre]<cur) {
				if (up[pre+1]) {
					dp[i+1]=dp[pre+1];
					lasti[i+1]=i;
					up[i+1]=true;
				}else {
					dp[i+1]=dp[pre+1]+1;
					lasti[i+1]=i;
					up[i+1]=true;
				}
			}else {
				if (!up[pre+1]) {
					dp[i+1]=dp[pre+1];
					lasti[i+1]=i;
					up[i+1]=false;
				}else {
					dp[i+1]=dp[pre+1]+1;
					lasti[i+1]=i;
					up[i+1]=false;
				}
			}
			pre=i;
		}
        return dp[n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WiggleSubsequence ws=new WiggleSubsequence();
//		int[] nums={1,2,3,4,5,6,7,8,9};
		int[] nums={1,17,5,10,13,15,10,5,16,8};
//		int[] nums={1,7,4,9,2,5};
		int res=ws.wiggleMaxLength(nums);
		System.out.println(res);
	}

}
