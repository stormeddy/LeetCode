
public class ValidPerfectSquare {

	public static boolean isPerfectSquare(int num) {
		if(num==1) return true;
        int l=0,r=num/2;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(mid*mid==num) return true;
            else if(mid<num/mid) l=mid+1;
            else r=mid-1;
        }
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPerfectSquare(5));
	}

}
