import java.util.PriorityQueue;

/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü array's length.
*/public class KthLargestElementInAnArray {

	public int findKthLargest(int[] nums, int k) {
	    
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.poll();
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={3,2,1,5,6,4};
		KthLargestElementInAnArray k=new KthLargestElementInAnArray();
		System.out.println(k.findKthLargest(a, 6));
	}

}
