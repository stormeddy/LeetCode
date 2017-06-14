import java.util.Arrays;

/*Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.*/

public class PerfectSquares {
	
    public int numSquares(int n) {
        int[] r=new int[n+1];
        int s=(int)Math.floor(Math.sqrt(n));
        for(int i=1;i<=s;i++){
            r[i*i]=1;
        }  
        return helper(n,r);
        
    }
    
    public int helper(int n,int[] r){
    	if(r[n]>0) return r[n];
    	if(n==0) return 0;     
        int ret=Integer.MAX_VALUE;
        int i=1;
        while(i*i<=n){
            int k=helper(i*i,r)+helper(n-i*i,r);
            if(k<ret) {ret=k;r[n]=ret;}
            i++;
        }
        return ret;
    }
    
    public int numSquares2(int n){
    	int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        int i = 0;
        while (++i * i <= n) {
            for (int j = i * i; j < memo.length; j++) {
                memo[j] = Math.min(memo[j], memo[j - (i * i)] + 1);
            }
        }
        return memo[n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectSquares p=new PerfectSquares();
		int ret=p.numSquares(1500);
		System.out.println(ret);
	}

}
