package jinritoutiao;

import java.util.Scanner;

public class Ti4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int[][] a=new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				a[i][j]=in.nextInt();
			}
		}
		int[][] cum=new int[n][n];
		for (int i = 0; i < cum.length; i++) {
			cum[n-1][i]=a[n-1][i];
		}
		
		for (int i = n-2; i >=0; i--) {
			for (int j = i; j >= 0; j--) {
				cum[i][j]=cum[i+1][j]+cum[i+1][j+1];
			}
		}
		
	}

}
