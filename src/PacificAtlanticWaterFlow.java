import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).*/
public class PacificAtlanticWaterFlow {

//	public List<int[]> pacificAtlantic(int[][] matrix) {
//		
//		List<int[]> res=new ArrayList<int[]>();
//		
//		int m=matrix.length;
//		if(m==0) return res;
//		int n=matrix[0].length;
//		boolean[][] pac=new boolean[m][n];
//		boolean[][] atl=new boolean[m][n];
//		boolean[][] touched_pac = new boolean[m][n];
//		boolean[][] touched_atl = new boolean[m][n];
//		
//		for (int i = 0; i < m; i++) {
//			pac[i][0]=true;
//			touched_pac[i][0]=true;
//			atl[i][n-1]=true;
//			touched_atl[i][n-1]=true;
//		}
//		for (int j = 0; j < n; j++) {
//			pac[0][j]=true;
//			touched_pac[0][j]=true;
//			atl[m-1][j]=true;
//			touched_atl[m-1][j]=true;
//		}
//        for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				boolean fp = false, fa = false;
//				
//				fa = search_at(matrix, i, j, touched_atl, atl);
//				fp = search_pa(matrix, i, j, touched_pac, pac);
//				if (fa && fp) {
//					res.add(new int[] { i, j });
//				}
//			}
//		}
//        return res;
//    }
//	
//	private boolean search_pa(int[][] matrix,int p,int q, boolean[][] touched_pac, boolean[][] pac){
//		int m=matrix.length;
//		int n=matrix[0].length;
//		touched_pac[p][q]=true;
//		if (p==0||q==0) {
//			pac[p][q]=true;
//			return true;
//		}
//		if ( (pac[p][q-1]&&matrix[p][q-1]<=matrix[p][q]) || (pac[p-1][q]&&matrix[p-1][q]<=matrix[p][q]) ) {
//			pac[p][q]=true;
//			return true;
//		}
//		if (p<m-1 && matrix[p+1][q]<=matrix[p][q] && pac[p+1][q]) {
//			pac[p][q]=true;
//			return true;
//		}
//		if (q<n-1 && matrix[p][q+1]<=matrix[p][q] && pac[p][q+1]) {
//			pac[p][q]=true;
//			return true;
//		}
//		
//		
//		boolean left=false;
//		if (matrix[p][q-1]<=matrix[p][q] && !touched_pac[p][q-1]) {
//			left=search_pa(matrix, p, q-1, touched_pac, pac);
//			if (left) {
//				pac[p][q]=true;
//				return true;
//			}
//			
//		}
//		boolean up=false;
//		if (matrix[p-1][q]<=matrix[p][q] && !touched_pac[p-1][q]) {
//			up=search_pa(matrix, p-1, q, touched_pac, pac);
//			if (up) {
//				pac[p][q]=true;
//				return true;
//			}
//		}
//		boolean right=false;
//		boolean down=false;
//		if (p<m-1 && matrix[p+1][q]<=matrix[p][q] && !touched_pac[p+1][q]) {
//			down=search_pa(matrix, p+1, q, touched_pac,pac);
//			if (down) {
//				pac[p][q]=true;
//				return true;
//			}
//		}
//		if (q<n-1 && matrix[p][q+1]<=matrix[p][q] && !touched_pac[p][q+1]) {
//			right=search_pa(matrix, p, q+1, touched_pac,pac);
//			if (right) {
//				pac[p][q]=true;
//				return true;
//			}
//		}
//		pac[p][q]=false;
//		return false;
//	}
//	
//	private boolean search_at(int[][] matrix,int p,int q, boolean[][] touched_atl, boolean[][] atl){
//		int m=matrix.length;
//		int n=matrix[0].length;
//		touched_atl[p][q]=true;
//		if (p==m-1||q==n-1) {
//			atl[p][q]=true;
//			return true;
//		}
//		if ( (atl[p+1][q] && matrix[p+1][q]<=matrix[p][q] ) || (atl[p][q+1] && matrix[p][q+1]<=matrix[p][q] )) {
//			atl[p][q]=true;
//			return true;
//		}
//		if (p>0 && matrix[p-1][q]<=matrix[p][q] && atl[p-1][q]) {
//			atl[p][q]=true;
//			return true;
//		}
//		if (q>0 && matrix[p][q-1]<=matrix[p][q] && atl[p][q-1]) {
//			atl[p][q]=true;
//			return true;
//		}
//		
//		boolean down=false;
//		if (matrix[p+1][q]<=matrix[p][q] && !touched_atl[p+1][q]) {
//			down=search_at(matrix, p+1, q, touched_atl, atl);
//			if (down) {
//				atl[p][q]=true;
//				return true;
//			}
//		}
//		boolean right=false;
//		if (matrix[p][q+1]<=matrix[p][q] && !touched_atl[p][q+1]) {
//			right=search_at(matrix, p, q+1, touched_atl, atl);
//			if (right) {
//				atl[p][q]=true;
//				return true;
//			}
//		}
//		boolean left=false;
//		boolean up=false;
//		if (p>0 && matrix[p-1][q]<=matrix[p][q] && !touched_atl[p-1][q]) {
//			up=search_at(matrix, p-1, q, touched_atl, atl);
//			if (up) {
//				atl[p][q]=true;
//				return true;
//			}
//		}
//		if (q>0 && matrix[p][q-1]<=matrix[p][q] && !touched_atl[p][q-1]) {
//			left=search_at(matrix, p, q-1, touched_atl, atl);
//			if (left) {
//				atl[p][q]=true;
//				return true;
//			}
//		}
//		atl[p][q]=false;
//		return false;
//	}

	public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<int[]>();
        if(matrix.length == 0 || matrix[0].length == 0) return result;   
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];  // the pacific boolean table
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length]; // the atlantic booean table
        //initially, all the top and left cells are flooded with pacific water
        //and all the right and bottom cells are flooded with atlantic water
        for(int i = 0; i < matrix.length; i++){
            pacific[i][0] = true;
            atlantic[i][matrix[0].length-1] = true;
        }
        for(int i = 0; i < matrix[0].length; i++){
            pacific[0][i] = true;
            atlantic[matrix.length-1][i] = true; 
        }
        //we go around the matrix and try to flood the matrix from 4 side.
        for(int i = 0; i < matrix.length; i++){
            boolean[][] pacificVisited = new boolean[matrix.length][matrix[0].length];
            boolean[][] atlanticVisited = new boolean[matrix.length][matrix[0].length];
            water(pacific, pacificVisited, matrix, i,0);
            water(atlantic, atlanticVisited, matrix, i, matrix[0].length - 1);            
        }
        for(int i = 0; i < matrix[0].length; i++){
            boolean[][] pacificVisited = new boolean[matrix.length][matrix[0].length];
            boolean[][] atlanticVisited = new boolean[matrix.length][matrix[0].length];
            water(pacific, pacificVisited, matrix, 0,i);
            water(atlantic, atlanticVisited, matrix, matrix.length - 1, i);            
        }
        //check the shared points among 2 tables
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    int[] element = {i,j};
                    result.add(element);
                }
            }
        }
        return result;
    }
    //the flood function
    private void water(boolean[][] wet, boolean[][] visited, int[][] matrix, int i , int j){
        wet[i][j] = true;
        visited[i][j] = true;
        int[] x = {0,0,1,-1};
        int[] y = {1,-1,0,0};
        for(int k = 0; k < 4; k++){
            if(i+y[k] >= 0 && i+y[k] < matrix.length && j+x[k] >= 0 && j+x[k] < matrix[0].length 
                && !visited[i+y[k]][j+x[k]] && matrix[i+y[k]][j+x[k]] >= matrix[i][j]){
                water(wet, visited, matrix, i+y[k], j+x[k]);
            }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacificAtlanticWaterFlow pawf=new PacificAtlanticWaterFlow();
//		int[][] matrix={{1  , 2  , 2 ,  3 , 5},
//			        {3  , 2  , 3,  4, 4},
//			       {2  , 4 , 5 , 3 ,  1 } ,
//			        {6 ,7, 1 ,  4 ,  5} ,
//			       {5  , 1 ,  1  , 2  , 4} };
		int[][] matrix = { 
				{ 7, 1, 17, 13, 9, 10, 5, 14, 0, 3 },
				{ 7, 15, 7, 8, 15, 16, 10, 10, 5, 13 },
				{ 18, 9, 15, 8, 19, 16, 7, 5, 5, 10 },
				{ 15, 11, 18, 3, 1, 17, 6, 4, 10, 19 },
				{ 3, 16, 19, 12, 12, 19, 2, 14, 5, 9 },
				{ 7, 16, 0, 13, 14, 7, 2, 8, 6, 19 },
				{ 5, 10, 1, 10, 2, 12, 19, 1, 0, 19 },
				{ 13, 18, 19, 12, 17, 17, 4, 5, 8, 2 },
				{ 2, 1, 17, 13, 14, 12, 14, 2, 16, 10 },
				{ 5, 8, 1, 11, 16, 1, 18, 15, 6, 19 },
				{ 3, 8, 14, 14, 5, 0, 2, 7, 5, 1 },
				{ 17, 1, 9, 17, 10, 10, 10, 7, 1, 16 },
				{ 14, 18, 5, 11, 17, 15, 8, 8, 14, 13 },
				{ 6, 4, 10, 17, 8, 0, 11, 4, 2, 8 },
				{ 16, 11, 17, 9, 3, 2, 11, 0, 6, 5 },
				{ 12, 18, 18, 11, 1, 7, 12, 16, 12, 12 },
				{ 2, 14, 12, 0, 2, 8, 5, 10, 7, 0 },
				{ 16, 13, 1, 19, 8, 13, 11, 8, 11, 3 },
				{ 11, 2, 8, 19, 6, 14, 14, 6, 16, 12 },
				{ 18, 0, 18, 10, 16, 15, 15, 12, 4, 3 },
				{ 8, 15, 9, 13, 8, 2, 6, 11, 17, 6 },
				{ 7, 3, 0, 18, 7, 12, 2, 3, 12, 10 },
				{ 7, 9, 13, 0, 11, 16, 9, 9, 12, 13 },
				{ 9, 4, 19, 6, 8, 10, 12, 6, 7, 11 },
				{ 5, 9, 18, 0, 4, 9, 6, 4, 0, 1 },
				{ 9, 12, 1, 11, 13, 13, 0, 16, 0, 6 },
				{ 7, 15, 4, 8, 15, 17, 17, 19, 15, 1 },
				{ 7, 17, 4, 1, 1, 14, 10, 19, 10, 19 },
				{ 10, 5, 12, 5, 8, 8, 14, 14, 6, 0 },
				{ 16, 10, 10, 7, 13, 4, 0, 15, 18, 0 },
				{ 11, 2, 10, 6, 5, 13, 4, 5, 3, 1 },
				{ 9, 14, 16, 14, 15, 3, 2, 13, 17, 8 },
				{ 19, 2, 10, 1, 2, 15, 12, 10, 2, 5 },
				{ 12, 4, 8, 9, 8, 6, 4, 14, 14, 0 },
				{ 11, 17, 17, 4, 16, 13, 6, 15, 5, 7 },
				{ 12, 18, 1, 3, 9, 10, 7, 1, 1, 1 },
				{ 18, 6, 10, 8, 12, 14, 9, 12, 10, 3 },
				{ 15, 13, 18, 13, 8, 5, 12, 14, 18, 0 },
				{ 15, 4, 8, 9, 19, 18, 6, 19, 12, 0 },
				{ 4, 14, 15, 4, 17, 17, 9, 17, 9, 0 },
				{ 6, 17, 16, 10, 3, 8, 8, 18, 15, 9 },
				{ 3, 8, 4, 2, 13, 0, 2, 8, 8, 2 },
				{ 14, 12, 13, 12, 17, 4, 16, 9, 8, 7 },
				{ 0, 19, 8, 16, 1, 13, 7, 6, 15, 11 },
				{ 1, 13, 16, 14, 10, 4, 11, 19, 9, 13 },
				{ 8, 0, 2, 1, 16, 12, 16, 9, 9, 9 },
				{ 5, 2, 10, 4, 8, 12, 17, 0, 2, 15 },
				{ 11, 2, 15, 15, 14, 9, 11, 19, 18, 11 },
				{ 4, 4, 1, 5, 13, 19, 9, 17, 17, 17 },
				{ 4, 1, 8, 0, 8, 19, 11, 0, 5, 4 },
				{ 8, 16, 14, 18, 12, 2, 0, 19, 0, 13 },
				{ 7, 11, 3, 18, 8, 2, 2, 19, 8, 7 },
				{ 3, 13, 6, 1, 12, 16, 4, 13, 0, 5 },
				{ 12, 1, 16, 19, 2, 12, 16, 15, 19, 6 },
				{ 1, 7, 12, 15, 3, 3, 13, 17, 16, 12 } };
		List<int[]> res=pawf.pacificAtlantic(matrix);
		for (int[] is : res) {
			System.out.println(Arrays.toString(is));
		}
	}

}
