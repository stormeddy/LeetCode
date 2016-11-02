/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]*/
public class SpiralMatrixII {

	public int[][] generateMatrix(int n) {
        int i=0;
        int j=0;
        int[][] r=new int[n][n];
        int k=1;
        while(k<=n*n){
            while(j<n&&r[i][j]==0) {r[i][j]=k;j++;k++;}
            j--;i++;
            while(i<n&&r[i][j]==0) {r[i][j]=k;i++;k++;}
            i--;j--;
            while(j>=0&&r[i][j]==0) {r[i][j]=k;j--;k++;}
            j++;i--;
            while(i>=0&&r[i][j]==0) {r[i][j]=k;i--;k++;}
            i++;j++;
        }
        return r;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrixII s=new SpiralMatrixII();
		s.generateMatrix(4);
	}

}
