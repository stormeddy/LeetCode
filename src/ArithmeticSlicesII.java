import java.util.Arrays;



public class ArithmeticSlicesII {

	public int numberOfArithmeticSlices(int[] A) {
		if(A == null) return 0;
        int n = A.length;
        if(n < 3) return 0;
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(map[i], -1);
        }
        int res = 0;
        for(int i = 0; i < n-2; i++) {
            for(int j = i+1; j < n-1; j++) {
                res += dfs(A, i, j, map);
            }
        }
        return res;
    }
    
    private int dfs(int[] A, int s1, int s2, int[][] map) {
        int n = A.length;
        if(s2 >= A.length - 1) return 0;
        if(map[s1][s2] >= 0) return map[s1][s2];
        int count = 0;
        long diff = (long) A[s2] - (long)A[s1];
        for(int i = s2 + 1; i < n-1; i++) {
            if((long)A[i] - (long)A[s2] != diff) continue;
            count += 1 + dfs(A, s2, i, map);
        }
        if((long) A[n-1] - (long)A[s2] == diff) count++;
        map[s1][s2] = count;
        return count;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArithmeticSlicesII as=new ArithmeticSlicesII();
		int[] a={2, 4, 6, 8, 10};
//		int[] a={0,2000000000,-294967296};
//		int[] a={79,20,64,28,67,81,60,58,97,85,92,96,82,89,46,50,15,2,36,44,54,
//		          2,90,37,7,79,26,40,34,67,64,28,60,89,46,31,9,95,43,19,47,64,48,
//		          95,80,31,47,19,72,99,28,46,13,9,64,4,68,74,50,28,69,94,93,3,80,
//		          78,23,80,43,49,77,18,68,28,13,61,34,44,80,70,55,85,0,37,93,40,
//		          47,47,45,23,26,74,45,67,34,20,33,71,48,96};
		int res=as.numberOfArithmeticSlices(a);
		System.out.println(res);
	}

}
