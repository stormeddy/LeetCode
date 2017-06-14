import java.util.HashMap;
import java.util.Scanner;

//Problem Description:
//小B准备开始新的职业生涯，由于大数据异常火爆，小B也打算去凑凑热闹，她应聘了一家数据处理公司。这不，面试官考察她的数据分析和编码能力。
//给了小B两个整数序列M和N，均按非递减顺序排列。面试官的问题是能否从序列M中找到p个连续元素构成一个子序列，同时从序列N中找到q个连续元素构成另一个子序列，使得它们满足条件：p个元素中的任何一个元素均小于q个元素中的任何一个？
//小B请你帮忙分析并编写这个程序。
//输入
//输入有若干组，每组包含四行，第一行为两个正整数na和nb（1<=na，nb<=100000），分别表示两个序列中元素的个数，第二行为p和q(1<=p<=na,1<=q<=nb），第三行为序列M，包含na个整数，第四行为序列N，包含nb个整数。
//输出
//对每组测试数据，单独输出一行，若能够找到则输出“YES”，否则输出“NO”（不含引号）。
//
//样例输入
//3 3
//2 1
//1 2 3
//3 4 5
//5 2
//3 1
//1 1 1 1 1
//2 2
//样例输出
//NO
//YES
public class MSTest6 {
	
	private HashMap<String, Integer> map;
	
	public void cal(String name,int score) {
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int num=Integer.parseInt(in.nextLine());
		int[] ans=new int[num];
		for (int i = 0; i < num; i++) {
			int n=in.nextInt();
			String s=in.nextLine();
			String name=s.split(s)[0];
			int score=Integer.parseInt(s.split(s)[1]);
			
//			System.out.println(s);
		}
		for (int i = 0; i < num; i++) {
			System.out.println(ans[i]);
		}
		
	}
	
}
