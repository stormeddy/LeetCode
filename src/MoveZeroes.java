import java.util.Arrays;

/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.*/
public class MoveZeroes {
	  public static void moveZeroes(int[] nums) {
	        int n=0,z=0;
	        int len=nums.length;
	        while(true){
	            while(z<len&&nums[z]!=0) z++;
	            while(n<len&&nums[n]==0) n++;
	            if(z==len||n==len) break;
	            else if(z<n){int temp=nums[z];nums[z]=nums[n];nums[n]=temp;}
	            else n++;
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,0,1};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		
	}

}
