import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/*Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
Example 1:
Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
Example 3:
Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.*/
public class FindRightInterval {

	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

	}
	
	public int[] findRightInterval(Interval[] intervals) {
		int n=intervals.length;
		int[] res=new int[n];
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for (int i = 0; i < res.length; i++) {
			res[i]=-1;
			map.put(intervals[i].start, i);
		}
		
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
		});
		for (int i = 0; i < n-1; i++) {
			Interval cur=intervals[i];
			for (int j = i+1; j < n; j++) {
				Interval next=intervals[j];
				if (next.start>=cur.end) {
					res[map.get(cur.start)]=map.get(next.start);
					break;
				}
			}
			
			
		}
		return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
