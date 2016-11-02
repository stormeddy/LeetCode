/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.*/
public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
//        return helper(matrix,0,0,matrix.length-1,matrix[0].length-1,target);
//    }
//    
//    public boolean helper(int[][] s,int i,int j,int p,int q,int target){
//    	if (i>p||j>q) return false;		
//        if(i==p&&j==q) return target==s[i][j];
//        int k=(i+p)/2;
//        int r=(j+q)/2;
//        if(target<=s[k][r]) return helper(s,i,j,k,r,target);
//        else if(k+1<s.length&&r+1<s[0].length&&target>=s[k+1][r+1]) return helper(s,k+1,r+1,p,q,target);
//        else return helper(s,i,r+1,k,q,target)||helper(s,k+1,j,p,r,target);
//    }
        int line=0;
        int len=matrix.length;
        int col=matrix[0].length;
        while (line<len && col>0){
            int num= matrix[line][col-1];
            if (num>target) col--;
            if (num<target) line++;
            if (num==target) return true;
        }

        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[][] s={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
					
			Search2DMatrixII t=new Search2DMatrixII();
			System.out.println(t.searchMatrix(s, 17));
	}

}
