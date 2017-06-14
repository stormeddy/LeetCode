package wangyi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Ti1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int k=0;
		int[] cnt=new int[6];
		List<HashSet<Integer>> g=new ArrayList<HashSet<Integer>>();
        while (in.hasNext()) {//注意while处理多个case
//        	InputStreamReader isr = new InputStreamReader(System.in);
//            BufferedReader br= new BufferedReader(isr);
            String s = in.nextLine();      
            
            char[] c=s.toCharArray();
            HashSet<Integer> tm=new HashSet<Integer>();
            for (int i = 0; i < c.length; i++) {
            	int cur=c[i]-'0';
				tm.add(cur);
			}
            k++;
            g.add(tm);
        }
        g.remove(0);
        
        
        int mul=1;
        System.out.println(g);
        System.out.println(mul);
//        for (int i = 0; i < g.size(); i++) {
//			mul*=cnt[i];
//		}
//        System.out.println(mul);
	}

}
