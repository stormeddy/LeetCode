import java.util.Scanner;


public class GeoHash {
	
	
	public String test(int x){
		int lo=-90;
		int hi=90;
		StringBuffer sb=new StringBuffer();
		while (hi-lo>=6) {
			int mid=lo+(hi-lo)/2;
			if (x>=mid) {
				lo=mid;
				sb.append('1');
			}else {
				hi=mid;
				sb.append('0');
			}
		}
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeoHash gh=new GeoHash();
		Scanner in=new Scanner(System.in);		
		int x=in.nextInt();
		System.out.println(gh.test(x));
	}

}
