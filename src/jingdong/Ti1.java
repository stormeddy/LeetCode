package jingdong;

import java.util.Scanner;

public class Ti1 {
	
	
//	public static void main(String[] args) {
//		Scanner in=new Scanner(System.in);
//		int n=in.nextInt();
//		String s=in.nextLine();
//		int res=0;
//		char[] c=s.toCharArray();
//		boolean[] f=new boolean[c.length];
//		for (int i = 0; i < c.length; i++) {
//			char cur=c[i];
//			if (cur=='#'||cur=='X') {
//				continue;
//			}else if (cur>='1'&&cur<='9') {
//				int range=cur-'1'+1;
//				for (int j = i-range; j <= i+range; j++) {
//					if (j>=0 && j<c.length && c[j]=='X' && !f[j]) {
//						res++;
//						f[j]=true;
//					}
//				}
//			}
//		}
//		System.out.println(res);
//	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String str = in.next();
		int res = core(n,str);
		System.out.println(res);
	}

	private static int core(int n, String str) {
		int res = 0;
		int arr[] = new int [n];
		for (int i = 0; i < n; i++) {
			if(str.charAt(i)=='X')
				arr[i]=1;
		}
		for (int i = 0; i < n; i++) {
			if(str.charAt(i)>'0' && str.charAt(i)<='9'){
				int ability = str.charAt(i)-'0';
				int start = i-ability;
				int end = i+ability;
				if(start<0) start=0;
				if(end>n-1) end = n-1;
				for (int j = start; j <= end; j++) {
					if(arr[j]==1){
						res++;
						arr[j]=0;
					}
				}
			}
		}
		return res;
	}
}
