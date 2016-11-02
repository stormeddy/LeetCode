
import java.util.Scanner;

public class ChengZhangZhi {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int [] day = new int [100];
		int [] task = new int [100];
		int res = 0;
		while(in.hasNextLine()){
			String string = in.nextLine().trim();
			if(string.equals("")) break;
			String[] strs = string.split(" ");
			if("1".equals(strs[0])){
				int start = Integer.parseInt(strs[1]);
				int end = Integer.parseInt(strs[2]);
				int ex = 0;
				if(strs[3].charAt(0)!='гн'){
					ex = Integer.parseInt(strs[3]);
				}else{
					System.out.println();
					ex = 0-Integer.parseInt(strs[3].substring(1));
				}
					
				for (int i = start; i <= end; i++) {
					if(ex>day[i]||day[i]==0){
						day[i] = ex;
						res+=ex;
					}
				}
			}else{
				int p = Integer.parseInt(strs[1]);
				int ex = Integer.parseInt(strs[2]);
				if(ex>task[p]||day[p]==0){
					day[p] = ex;
					res+=ex;
				}
			}
		}
		System.out.println(res);
	}
}
/*	
	1 1 5 10
	2 3 4
	1 4 6 -5
	*/
/*	
	1 1 5 10
	1 1 5 11
	1 1 5 12
	*/