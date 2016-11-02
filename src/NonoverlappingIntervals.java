import java.util.Arrays;
import java.util.Comparator;

/*Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.*/
public class NonoverlappingIntervals {

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

	public int eraseOverlapIntervals(Interval[] intervals) {
		int n=intervals.length;
		if (n<=1) {
			return 0;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
		});
		
		
		int[] dp=new int[n];
		dp[0]=1;
		Interval pre=intervals[0];
		for (int i = 1; i < n; i++) {
			Interval cur=intervals[i];
			if (pre.end>cur.start) {
				dp[i]=dp[i-1];
				if (cur.end<pre.end) {
					pre=cur;
				}
			}else {
				pre=cur;
				dp[i]=dp[i-1]+1;
			}
		}
		return n-dp[n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NonoverlappingIntervals ni=new NonoverlappingIntervals();
		int[] start={1,2,3,1};
		int[] end={2,3,4,3};
		Interval[] intervals=new Interval[end.length];
		for (int i = 0; i < end.length; i++) {
			intervals[i]=ni.new Interval(start[i], end[i]);
		}
		
		System.out.println(ni.eraseOverlapIntervals(intervals));
	}

}
