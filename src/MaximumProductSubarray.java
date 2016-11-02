/*Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.*/
public class MaximumProductSubarray {

	public static int maxProduct(int[] nums) throws Exception {
		if(nums == null || nums.length == 0)
	    {
	        throw new Exception("Invalid input");
	    }

	    int max = nums[0];
	    int min = nums[0];
	    int result = nums[0];

	    for(int i = 1; i < nums.length; i++)
	    {
	        int prev_max = max;
	        int prev_min = min;
	        max = Math.max(nums[i],Math.max(prev_max*nums[i], prev_min*nums[i]));
	        min = Math.min(nums[i],Math.min(prev_max*nums[i], prev_min*nums[i]));
	        result = Math.max(result, max);
	    }

	    return result;
	    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(maxProduct(new int[]{2,3,-2,4}));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
