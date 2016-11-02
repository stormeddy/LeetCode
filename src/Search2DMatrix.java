/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]*/

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int u=0,d=m-1;
        while(u<d){
            int mid=(u+d)/2;
            if(matrix[mid][n-1]>=target) d=mid;
            else u=mid+1;
        }
        if(u>=m) return false;
        int l=0,r=n-1;
        while(l<r){
            int mid=(l+r)/2;
            if(matrix[u][mid]>=target) r=mid;
            else l=mid+1;
        }
        if(l>=n) return false;
        return matrix[u][l]==target;
    }
    
    public static void main(String[] args) {
		Search2DMatrix t=new Search2DMatrix();
		int[][] s={{1,3}};
		boolean ret=t.searchMatrix(s, 3);
		System.out.println(ret);
//		Arrays.binarySearch(s, 3);
	}
}
