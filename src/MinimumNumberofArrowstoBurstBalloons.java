import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ¡Ü x ¡Ü xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.

Example:

Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) 
and another arrow at x = 11 (bursting the other two balloons).*/
public class MinimumNumberofArrowstoBurstBalloons {

	public int findMinArrowShots(int[][] points) {
		int n=points.length;
		if (n==0) {
			return 0;
		}
        Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
		});
        
        
        int[] end=new int[n];
        int[] gp=new int[n];
        int k=1;
        end[0]=points[0][1];
        gp[0]=1;
        for (int i = 1; i < n; i++) {
			if (end[i-1]<points[i][0]) {
				++k;
				end[i]=points[i][1];
				gp[i]=k;
				
			}else {
				
				if (points[i][1]<end[i-1]) {
					end[i]=points[i][1];
					
				}else {
					end[i]=end[i-1];
				}
				gp[i]=k;
			}
		}
        return k;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] points={{10,16}, {2,8}, {1,6}, {7,12}};
		MinimumNumberofArrowstoBurstBalloons mnabb=new MinimumNumberofArrowstoBurstBalloons();
		int res=mnabb.findMinArrowShots(points);
		System.out.println(res);
	}

}
