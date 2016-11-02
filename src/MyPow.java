
public class MyPow {

	public static double myPow(double x, int n) {
			if (n>=0) {
				return myPowPositive(x, n);
			}else {
				return 1/myPowPositive(x, n);
			}
	}
	
	public static double myPowPositive(double x, int n) {
		if (n==0) {
			return 1;
		}
		double t=myPowPositive(x, n/2);
		double r=t*t;
		if (n%2==0) {				
			return r;
		}else {
			return r*x;
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myPow(3, -3));
//		System.out.println((-1)/2);
		
//		1534236469;
		System.out.println(Integer.MAX_VALUE);
	}

}
