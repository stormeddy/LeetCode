/*Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		Set<Integer> s1 = new HashSet<>();
		Set<Integer> s2 = new HashSet<>();
		Set<Pair> s = new HashSet<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0)
					s.add(new Pair(i, j));
			}
		}
		Iterator<Pair> iter = s.iterator();
		while (iter.hasNext()) {
			Pair p = iter.next();
			int i = p.i;
			int j = p.j;

			if (!s1.contains(i)) {
				for (int k = 0; k < matrix[0].length; k++)
					matrix[i][k] = 0;
				s1.add(i);
			}
			if (!s2.contains(j)) {
				for (int k = 0; k < matrix.length; k++)
					matrix[k][j] = 0;
				s2.add(j);
			}
		}
	}
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a={{1,0},{2,3}};
		SetMatrixZeroes s=new SetMatrixZeroes();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
		s.setZeroes(a);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	
    class Pair{
        int i;
        int j;
        public Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }

}
