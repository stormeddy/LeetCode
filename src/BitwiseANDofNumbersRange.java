/*Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.*/
public class BitwiseANDofNumbersRange {

	public static int rangeBitwiseAnd(int m, int n) {
        
        
        if(m<n){
        	if(myLog(m)!=myLog(n)) return 0;
            int mid=m+(n-m)/2;//·ÀÖ¹Òç³ö
            int l=rangeBitwiseAnd(m,mid-1);
            int r=rangeBitwiseAnd(mid+1,n);
            return l&mid&r;
        }else{
            return m;
        }
        
    }
    
    private static int myLog(int m){
        double t=m;
        return (int)(Math.log(m)/Math.log(2));
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rangeBitwiseAnd(4,6));
	}

}
