import java.util.Arrays;
import java.util.HashMap;


public class TwoSum {
/*	Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution.

	Example:
	Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].*/
	
	 public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		int[] ans=new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target-nums[i])) {
				ans[0]=map.get(target-nums[i]);
				ans[1]=i;
				break;
			}
			map.put(nums[i], i);
		}
	    return ans;  
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{11,15,2,7}, 9)));
	}

}
