import java.util.Random;



public class PrimePair {

	private boolean witness(int a,int n){
		if (n%2==0) {
			//n为偶数
			return true;
		}
		int t=0;
		int u=n-1;
		while ((u&1)==0) {
			t++;
			u>>=1;
		}
//		System.out.println(u+" "+t);
		int[] x=new int[t+1];
		x[0]=modular_exponentiation(a, u, n);
		for (int i = 1; i <= t; i++) {
			x[i]=x[i-1]*x[i-1]%n;
			if (x[i]==1 && x[i-1]!=1 && x[i-1]!=n-1) {
				return true;
			}
		}
		if (x[t]!=1) {
			return true;
		}		
		return false;
	}
	
	public int modular_exponentiation(int a,int b,int n){
		//反复平方法求模取幂
		//从左到右（从高位到低位检查）
		int c=0,d=1;
		String str=Integer.toBinaryString(b);
		for (int i = 0; i < str.length(); i++) {
			c=c*2;
			d=d*d%n;
			if (str.charAt(i)=='1') {
				c=c+1;
				d=d*a%n;
			}
//			System.out.println(d+" "+c);
		}
		return d;
		
		////从右到左（从低位到高位检查）
//		int c=0,d=a,t=1,base=0;
//		String str=Integer.toBinaryString(b);
//		for (int i = str.length()-1; i >= 0; i--) {
//			if (str.charAt(i)=='1') {
////				c=c+1;
//				c=c+(1<<base);
//				t=t*d%n;
//			}			
//			base++;
//			d=d*d%n;
////			System.out.println(t+" "+c);
//		}
//		return t;
	}
	
	public boolean miller_rabin(int n,int s){
		//miller_rabin素数测试
		//返回是否为质数
		if (n==2) {
			return true;
		}
		Random random=new Random();
		for (int j = 1; j <= s; j++) {
			int a=random.nextInt(n-1)+1;//1<=a<=n-1
			if (witness(a, n)) {
				return false;
			}
		}
		return true;
	}
	
	
	public int test(int n){
		int s=5;
		int cnt=0;
		for (int i = 2; i <= n/2; i++) {
			int j=n-i;
			if (miller_rabin(i, s)&&miller_rabin(j, s)) {
				cnt++;
				System.out.println(i+" "+j);
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimePair pp=new PrimePair();
		int n=1000;
		int cnt=pp.test(n);
	}

}
