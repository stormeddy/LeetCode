package jinritoutiao;

import java.util.HashSet;
import java.util.Scanner;

public class Ti1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		
		int m=in.nextInt();
		HashSet<Integer> s=new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			int t=in.nextInt();
			s.add(t);
		}
		int n=in.nextInt();
		for (int i = 0; i < n; i++) {
			int t=in.nextInt();
			if (s.contains(t)) {
				
				System.out.print(t+" ");
			}
		}
	}

}
