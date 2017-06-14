import java.util.HashMap;

/*Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:
Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True
Note:

All the input integers are in the range [-10000, 10000].
A valid square has four equal sides with positive length and four equal angles (90-degree angles).
Input points have no order.*/
public class ValidSquare {

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] d=new long[6];
        int[][] p={p1,p2,p3,p4};
        int k=0;
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
        for (int i = 0; i < p.length-1; i++) {
			for (int j = i+1; j < p.length; j++) {
				d[k]=dist(p[i], p[j]);
				min=Math.min(min, d[k]);
				max=Math.max(max, d[k]);
				k++;
				
			}
		}
        HashMap<Long, Integer> m=new HashMap<Long, Integer>();
        for (long cur : d) {
			m.put(cur, m.getOrDefault(cur, 0)+1);
		}
        if (m.size()==2) {
			if (m.get(max)==2 && m.get(min)==4&& max==2*min) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
        
    }
    
    private long dist(int[] p,int[] q){
    	long a=p[0];
    	long b=q[0];
    	long c=p[1];
    	long d=q[1];
        return (a-b)*(a-b)+(c-d)*(c-d);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p1={0,0};
		int[] p2={0,1};
		int[] p3={1,0};
		int[] p4={1,1};
		ValidSquare vs=new ValidSquare();
		System.out.println(vs.validSquare(p1, p2, p3, p4));
	}

}
