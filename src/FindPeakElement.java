import java.util.Arrays;

/*A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ¡Ù num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -¡Ş.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.*/
public class FindPeakElement {

	public int findPeakElement(int[] nums) {
        int start=0, end=nums.length-1;
        while(end>start){
            int mid=(start+end)/2;
            if(nums[mid] < nums[mid+1])  start=mid+1;
            else end=mid;
        }
        return start;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPeakElement f=new FindPeakElement();
		int[] a={2,4,5,3,6,7,8};
		int ret=f.findPeakElement(a);
		System.out.println(ret);
//		Arrays.sort(a);
	}

}
