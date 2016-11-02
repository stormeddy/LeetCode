import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/*Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ¡Ü k ¡Ü input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

Hint:

How about using a data structure such as deque (double-ended queue)?
The queue size need not be the same as the window¡¯s size.
Remove redundant elements and the queue should store only elements that need to be considered.*/
public class SlidingWindowMaximum {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums==null||k==0) return new int[0];
        ArrayDeque<Integer> deque=new ArrayDeque<Integer>();
        int[] ans=new int[nums.length-k+1];
        for (int i = 0; i < k; i++) {
        	deque.offer(nums[i]);
		}
        int max=myMax(deque);
        ans[0]=max;
        int out,in;
        for (int i = k; i < nums.length; i++) {
			in=nums[i];
        	out=deque.poll();
        	deque.offer(in);
        	if (out<max) {
				if (in>max) {
					ans[i-k+1]=in;
					max=in;
				}else {
					ans[i-k+1]=max;
				}
			}else {
				max=myMax(deque);
				ans[i-k+1]=max;
			}
			
		}
        return ans;
        
       
    }
	
	private static int myMax(ArrayDeque<Integer> deque){
		Iterator<Integer> iterator=deque.iterator();
		int max=Integer.MIN_VALUE;
		int k;
		while (iterator.hasNext()) {
			k=iterator.next();
			if (k>max) {
				max=k;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(SlidingWindowMaximum.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
	}

}
