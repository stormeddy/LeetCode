package jingdong;


import java.util.Scanner;

public class Ti2 {

	private static boolean overlap(int[] a,int[] b,int i,int p){
		return a[i]<=a[p] && a[p]<=b[i];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			b[i] = in.nextInt() + a[i];

		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int k = 0;
				for (int p = 0; p < n; p++) {
					if (overlap(a,b,i,p)||overlap(a, b, j, p)) {
						k++;
					}
				}
				if (k>ans) {
					ans=k;
				}
				

			}
		}
		System.out.println(ans);
	}


}
/*
 4
 2 2
 3 1
 5 2
 7 3
 output 4
 */
