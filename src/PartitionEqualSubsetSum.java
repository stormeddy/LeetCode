import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Both the array size and each of the array element will not exceed 100.

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.*/
public class PartitionEqualSubsetSum {

	public boolean canPartition(int[] nums) {
		Arrays.sort(nums);
		int s=0;
		for (int i = 0; i < nums.length; i++) {
			s+=nums[i];
		}
		if (s%2==1) {
			return false;
		}
		int half=s/2;

		return search(nums, 0, nums.length-1, half);
    }
	
	
	private boolean search(int[] nums,int l,int r,int target){
		boolean res=false;
		for (int i = r; i >= l; i--) {
			if (nums[i]>target) {
				continue;
			}else if (nums[i]==target) {
				return true;
			}else {
				res= search(nums, l, r-1, target-nums[i]);
				if (res) {
					return res;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionEqualSubsetSum pess=new PartitionEqualSubsetSum();
//		int[] nums={1,5,5,11};
		int[] nums={71,70,66,54,32,63,38,98,4,22,61,40,6,8,6,21,71,36,30,34,44,60,89,53,60,
				    56,73,14,63,37,15,58,51,88,88,32,80,32,10,89,67,29,68,65,34,15,88,8,57,
				    78,37,63,73,65,47,39,32,74,31,44,43,4,10,8,96,22,58,87,29,99,79,13,96,
				    21,62,71,34,55,72,3,96,7,36,64,30,6,14,87,12,90,40,13,29,21,94,33,99,86,4,100};
		boolean res=pess.canPartition(nums);
		System.out.println(res);
	}

}
