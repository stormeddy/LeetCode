import java.util.ArrayList;


public class ReverseInteger {

	public int reverse(int x) {
//	       if(x>0){
//	           return reversePositive(x);
//	       }else if(x!=Integer.MIN_VALUE){
//	           return -reversePositive(-x);
//	       }else {
//			   return 0;
//	       }
		int y=0;
		int lasty=0;
		while(x!=0){
			lasty=y;
			y=y*10+x%10;
			x=x/10;
		}
		if (y/10!=lasty) {
			return 0;
		}else {
			return y;
		}
	   }
	    
//	    public int reversePositive(int x){
//	        int y=0;
//	        int lasty=0;
//	        while(x!=0){
//	            lasty=y;	            
//	            if(lasty<=Integer.MAX_VALUE/10){
//	            	y=y*10+x%10;
//	            	x=x/10;
//	            }else{
//	                return 0;
//	            }
//	        }
//	        return y;
//	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(Integer.MAX_VALUE);
		System.out.println(new ReverseInteger().reverse(Integer.MIN_VALUE));
	}
}
