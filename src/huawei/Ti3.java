package huawei;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Ti3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case

            String s = in.nextLine();
            
            
            char[] c=s.toCharArray();
            
            Deque<Long> stack=new ArrayDeque<Long>();
//            stack.push(0);
//            int res=0;
            for(int i=0;i<c.length;i++){
            	char cur=c[i];
            	if((cur>='0'&& cur<='9')) {
            		
            		stack.offer((long) (cur-'0'));            	
            	}else if(cur>='A'&& cur<='F'){
            		stack.offer((long) (cur-'A'+10)); 
				}else if (cur=='+') {
					Long a=stack.pollLast();
					Long b=stack.pollLast();
					stack.push(a+b);
				}else if (cur=='-') {
					Long a=stack.pollLast();
					Long b=stack.pollLast();
					stack.push(b-a);
				}else if (cur=='*') {
					Long a=stack.pollLast();
					Long b=stack.pollLast();
					stack.push(a*b);
				}
            	
            }
            System.out.println(stack.pop());
        }
	}

}
