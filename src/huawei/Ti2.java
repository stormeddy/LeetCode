package huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class Ti2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		while(in.hasNext()){
			String str = in.next();
			list.add(str);
		}
		int res = core(list);
		System.out.println(res);
		in.close();
}

	private static int core(ArrayList<String> list) {
		int []arr = {0,0,0,0,0};
		for(int i = 0;i<list.size();i++){
			for (int j = 0; j < 5; j++) {
				arr[j]+=list.get(i).charAt(j)-'0';
			}
			
		}
		int res = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(res>arr[i])
				res=arr[i];//取最小值
		}
		return res;
	}

	
	
}