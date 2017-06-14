/*Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.

Example 1:
Input: 5
Output: 5
Explanation: 
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule. 
Note: 1 <= n <= 109*/
public class NonnegativeIntegerswithoutConsecutiveOnes {

	public int findIntegers(int num) {
		int res=0;
        for (int i = 0; i <= num; i++) {
			if (help(i)) {
				res++;
			}
		}
        return res;
    }
	
	private boolean help(int i){
		int pre=0;
		while (i>0) {
			int cur=i&1;
			if (cur==1&&pre==1) {
				return false;
			}
			pre=cur;
			i>>=1;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NonnegativeIntegerswithoutConsecutiveOnes nn=new NonnegativeIntegerswithoutConsecutiveOnes();
		System.out.println(nn.findIntegers(500000000));
//		System.out.println(Integer.MAX_VALUE);
	}

}
