/*Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int a1=helper(nums,0,nums.length-2);
        int a2=helper(nums,1,nums.length-1);
        return a1>a2?a1:a2;
    }
    
    public int helper(int[] nums,int start,int end){
        int n=end-start+1;
        int[] r=new int[n+1];
        r[1]=nums[start];
        for(int i=2;i<=n;i++){
            if(r[i-2]+nums[i-1+start]>r[i-1]) r[i]=r[i-2]+nums[i-1+start];
            else r[i]=r[i-1];
        }
        return r[n]; 
    }
}
