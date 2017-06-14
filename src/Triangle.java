import java.util.ArrayList;
import java.util.List;

/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).*/
public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		int n=triangle.size();
        List<Integer> ret=new ArrayList<Integer>(n);
        ret.add(triangle.get(0).get(0));
        for(int i=1;i<n;i++){
            List<Integer> a=triangle.get(i);
            int len=a.size();
            int pre=ret.get(0);
            ret.set(0,pre+a.get(0));
            for(int j=1;j<ret.size();j++){
                int temp=Integer.min(ret.get(j),pre)+a.get(j);
                pre=ret.get(j);
                ret.set(j,temp);
            }
            ret.add(pre+a.get(len-1));
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<ret.size();i++){
            if(ret.get(i)<min) min=ret.get(i);
        }
        return min;
        
/*      int len = triangle.size();
        int[] dp = new int[len];
        for(int i = len-1;i >= 0; i--){
            for(int j = 0; j <= i; j++){
                if(i == len-1) dp[j]= triangle.get(i).get(j);
                else{
                    dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
                }
            }
        }
        return dp[0];*/
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ret=new ArrayList<Integer>(10);
		System.out.println(ret.size());
	}

}
