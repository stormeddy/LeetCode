import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/*We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Note: The length of the input array will not exceed 20,000.*/
public class LongestHarmoniousSubsequence {

	public int findLHS(int[] nums) {
        TreeMap<Integer, Integer> m=new TreeMap<Integer, Integer>();
        for(int i:nums){
        	m.put(i, m.getOrDefault(i, 0)+1);
        }
        int res=0;
        Set<Integer> s=m.keySet();
        for (Integer c: s) {
			if (s.contains(c+1)) {
				res=Math.max(res, m.get(c)+m.get(c+1));
			}
		}
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
