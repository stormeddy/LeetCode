/*Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]*/
public class NumberofBoomerangs {

	public int numberOfBoomerangs(int[][] points) {
        int n=points.length;
        int res=0;
        int[][] dist=new int[n][n];
        for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int aij=points[i][0]-points[j][0];
				int bij=points[i][1]-points[j][1];
				dist[i][j]=aij*aij+bij*bij;
			}
		}
        
        for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				for (int k = j+1; k < n; k++) {
					if (dist[i][j]==dist[i][k]) {
						res+=2;
					}
					if (dist[i][j]==dist[j][k]) {
						res+=2;
					}
					if (dist[j][k]==dist[i][k]) {
						res+=2;
					}
				}
			}
		}
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(Integer.MAX_VALUE);
		
		int[][] points={{0,0},{1,0},{2,0}};
		NumberofBoomerangs nb=new NumberofBoomerangs();
		int res=nb.numberOfBoomerangs(points);
		System.out.println(res);
	}

}
