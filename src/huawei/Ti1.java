package huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ti1 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
//        	InputStreamReader isr = new InputStreamReader(System.in);
//            BufferedReader br= new BufferedReader(isr);
            String s = in.nextLine();
            
            StringBuffer sb=new StringBuffer();
            char[] c=s.toCharArray();
            for(int i=0;i<c.length;i++){
            	char cur=c[i];
            	if(cur>='A'&& cur<='Z') {
            		char ap=(char)(cur-'A'+'a');
            		sb.append(ap);
            	}
            	else if(cur>='a' && cur<='z') sb.append(cur);
            }
            System.out.println(sb.toString());
        }
    }

}
