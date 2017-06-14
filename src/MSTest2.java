/*Little Hi runs a web server. Sometimes he has to deny access from a certain set of malicious IP addresses while his friends are still allow to access his server. To do this he writes N rules in the configuration file which look like:

allow 1.2.3.4/30
deny 1.1.1.1
allow 127.0.0.1
allow 123.234.12.23/3
deny 0.0.0.0/0
Each rule is in the form: allow | deny address or allow | deny address/mask.

When there comes a request, the rules are checked in sequence until the first match is found. If no rule is matched the request will be allowed. Rule and request are matched if the request address is the same as the rule address or they share the same first mask digits when both written as 32bit binary number.

For example IP "1.2.3.4" matches rule "allow 1.2.3.4" because the addresses are the same. And IP "128.127.8.125" matches rule "deny 128.127.4.100/20" because 10000000011111110000010001100100 (128.127.4.100 as binary number) shares the first 20 (mask) digits with 10000000011111110000100001111101 (128.127.8.125 as binary number).

Now comes M access requests. Given their IP addresses, your task is to find out which ones are allowed and which ones are denied.

输入
Line 1: two integers N and M.

Line 2-N+1: one rule on each line.

Line N+2-N+M+1: one IP address on each line.

All addresses are IPv4 addresses(0.0.0.0 - 255.255.255.255). 0 <= mask <= 32.



For 40% of the data: 1 <= N, M <= 1000.

For 100% of the data: 1 <= N, M <= 100000.

输出
For each request output "YES" or "NO" according to whether it is allowed.

样例输入
5 5
allow 1.2.3.4/30
deny 1.1.1.1
allow 127.0.0.1
allow 123.234.12.23/3
deny 0.0.0.0/0
1.2.3.4
1.2.3.5
1.1.1.1
100.100.100.100
219.142.53.100
样例输出
YES
YES
NO
YES
NO*/

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


public class MSTest2 {

	public static void insert(String s,HashMap<String, Boolean> map) {
		if(s.split(" ")[0].equals("allow")){
			map.put(s.split(" ")[1], true);
		}else if (s.split(" ")[0].equals("deny")) {
			map.put(s.split(" ")[1], false);
		}
	}
	
	public static boolean cal(String t,HashMap<String, Boolean> map){
		if (map.containsKey(t)) {
			return map.get(t);
		}else {
			for (Entry<String, Boolean> entry : map.entrySet()) {  	
				String s=entry.getKey();
				if (binaryCompare(s, t)) {
					return map.get(s);
				}				
			}
		}			
		return true;
	}
	
	public static String myToBinaryString(int i){
		StringBuffer s=new StringBuffer(Integer.toBinaryString(i));
		for (int j = s.length(); j < 8; j++) {
			s.insert(0, 0);
		}
		return s.toString();
	}
	
	public static boolean binaryCompare(String s,String t) {
		int i = s.length()-1;
		for (; i >=0; i--) {
			if (s.charAt(i)=='/') {
				break;
			}
		}
		if (i==-1) {
			return false;
		}else {
			int mask=Integer.parseInt(s.substring(i+1));
			String[] shelp=s.replaceAll("/","\\.").split("\\.");
			String[] thelp=t.split("\\.");
			if (mask>=0&&mask<=8) {
				Integer.toHexString(Integer.parseInt(shelp[0]));
			}
			
			StringBuffer sa=new StringBuffer("");
			StringBuffer ta=new StringBuffer("");
			for (int j = 0; j < 4; j++) {
				 sa=sa.append(myToBinaryString(Integer.parseInt(shelp[j])));
				 ta=ta.append(myToBinaryString(Integer.parseInt(thelp[j])));
			}
			if (sa.substring(0, mask).equals(ta.substring(0, mask))) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		String num=in.nextLine();
		int N=Integer.parseInt(num.split(" ")[0]);
		int M=Integer.parseInt(num.split(" ")[1]);
		HashMap<String, Boolean> map=new HashMap<String, Boolean>();
		boolean[] ans=new boolean[M];
		for (int i = 0; i < N; i++) {
			String s=in.nextLine();
			insert(s,map);
		}
		for (int i = 0; i < M; i++) {
			String s=in.nextLine();
			ans[i]=cal(s,map);			
		}
		for (int i = 0; i < ans.length; i++) {
			if (ans[i]) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

}
