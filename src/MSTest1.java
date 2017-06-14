/*时间限制:10000ms
单点时限:1000ms
内存限制:256MB
描述
Steven loves reading book on his phone. The book he reads now consists of N paragraphs and the i-th paragraph contains ai characters.

Steven wants to make the characters easier to read, so he decides to increase the font size of characters. But the size of Steven's phone screen is limited. Its width is W and height is H. As a result, if the font size of characters is S then it can only show [W / S] characters in a line and [H / S] lines in a page. ([] is the largest integer no more than x)  

So here's the question, if Steven wants to control the number of pages no more than P, what's the maximum font size he can set? Note that paragraphs must start in a new line and there is no empty line between paragraphs.

输入
Input may contain multiple test cases.

The first line is an integer TASKS, representing the number of test cases.

For each test case, the first line contains four integers N, P, W and H, as described above.

The second line contains N integers a1, a2, ... aN, indicating the number of characters in each paragraph.



For all test cases,

1 <= N <= 103,

1 <= W, H, ai <= 103,

1 <= P <= 106,

There is always a way to control the number of pages no more than P.

输出
For each testcase, output a line with an integer Ans, indicating the maximum font size Steven can set.

样例输入
2
1 10 4 3
10
2 10 4 3
10 10
样例输出
3
2*/


import java.util.Scanner;


public class MSTest1 {

	public static int cal(String s,String t) {
		String[] par=s.split(" ");
		int n=Integer.parseInt(par[0]);
		int p=Integer.parseInt(par[1]);
		int w=Integer.parseInt(par[2]);
		int h=Integer.parseInt(par[3]);
		String[] a=t.split(" ");
		int[] arr=new int[a.length];
		for (int i = 0; i < a.length; i++) {
			arr[i]=Integer.parseInt(a[i]);
		}
		int size=1;
		while (true) {
			int total=0;
			int CPL=w/size;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]%CPL==0) total+=arr[i]/CPL;
				else total+=arr[i]/CPL+1;			
			}
			if (total<=p*(h/size)) {
				size++;
			}else {
				return size-1;
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int num=Integer.parseInt(in.nextLine());
		int[] ans=new int[num];
		for (int i = 0; i < num; i++) {
			String s=in.nextLine();
			String t=in.nextLine();
			ans[i]=cal(s, t);
//			System.out.println(s);
		}
		for (int i = 0; i < num; i++) {
			System.out.println(ans[i]);
		}
		
		

	}

}
