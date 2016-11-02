import java.util.HashMap;
import java.util.Scanner;


public class SSD {

	HashMap<Long, Long> map;
	public long cal(long n){
		map=new HashMap<Long, Long>();
		long k=0;
		long tmp=((n&1)==0)?n:n-1;
		for (long i = 2; i <= tmp; i=i+2) {
			long t=help(i);			
			k+=t;
		}
		if ((n&1)==1) {
			k+=(n+1)*(n+1)/4;
		}else {
			k+=n*n/4;
		}
		System.out.println(k);
		return k;
	}
	
	public long help(long t){
		long ori=t;
		if (!map.containsKey(t)) {
			while ((t&1)==0) {
				t>>=1;
				if (map.containsKey(t)) {
					map.put(ori, t);
					return map.get(t);
				}
			}
		}
		
		return t;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		SSD ssd=new SSD();
		long n=in.nextLong();
		ssd.cal(n);
	}

}
