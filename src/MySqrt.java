
public class MySqrt {
	
	public static int mySqrt(int x){
		if(x<2) return x;
		double t=x;
		double Err=1e-10;
		double r;
		do {
			r=t;
			t=t/2+x/2.0f/t;
		} while (Math.abs(r-t)>Err);
		int ans=(int)t;
		if (ans*ans==x) {
			return ans;
		}else if ((ans+1)*(ans+1)==x) {
			return ans+1;
		}else {
			return ans;
		}
		
//		version 2
//		int left = 1, right = x / 2;
//		int last_mid=0; //  //记录最近一次mid
//		if (x < 2) return x;
//		while(left <= right) {
//			int mid = left + (right - left) / 2;
//			if(x / mid > mid) { //不要用mid*mid,会溢出
//				left = mid + 1;
//				last_mid = mid;
//			} else if(x / mid < mid) {
//				right = mid - 1;
//			} else {
//				return mid;
//			}
//		}
//		return last_mid;
		
		
//		 version 3
//		 if(x < 4) return x == 0 ? 0 : 1;
//		    int res = 2 * mySqrt(x/4);
//		    if((res+1) * (res+1) <= x && (res+1) * (res+1) >= 0) return res+1;//防止overflow,要判断是否为非负数
//		    return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(325693779));
//		System.out.println(Integer.MAX_VALUE);
	}

}
