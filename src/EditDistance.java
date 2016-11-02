
import java.util.HashMap;
import java.util.Scanner;

public class EditDistance {

	public enum Op{
		COPY,REPLACE,DELETE,INSERT
	}

	public int editDistance(String x,String y){
		int m=x.length();
		int n=y.length();
		int[][] c=new int[m+1][n+1];
		Op[][] op=new Op[m+1][n+1];
		int[] costInt={0,1,1,1};
		HashMap<Op, Integer> cost=new HashMap<Op, Integer>();
		int cnt=0;
		for (Op ops : Op.values()) {
			cost.put(ops, costInt[cnt]);
			
			cnt++;
		}	
		String[] replace=new String[n];
		String[] insert=new String[n];
		int k=0;
		for (int i = 0; i <= m; i++) {
			c[i][0]=i*cost.get(Op.DELETE);
			op[i][0]=Op.DELETE;
		}
		for (int j = 0; j <= n; j++) {
			c[0][j]=j*cost.get(Op.INSERT);
			op[0][j]=Op.INSERT;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				c[i][j]=Integer.MAX_VALUE;
				if (x.charAt(i-1)==y.charAt(j-1)) {
					c[i][j]=c[i-1][j-1]+cost.get(Op.COPY);
					op[i][j]=Op.COPY;
				}
				if (x.charAt(i-1)!=y.charAt(j-1)&&c[i-1][j-1]+cost.get(Op.REPLACE)<c[i][j]) {
					c[i][j]=c[i-1][j-1]+cost.get(Op.REPLACE);
					op[i][j]=Op.REPLACE;
//					replace[j-1]=y.charAt(i-1);
				}
				if (c[i-1][j]+cost.get(Op.DELETE)<c[i][j]) {
					c[i][j]=c[i-1][j]+cost.get(Op.DELETE);
					op[i][j]=Op.DELETE;
				}
				if (c[i][j-1]+cost.get(Op.INSERT)<c[i][j]) {
					c[i][j]=c[i][j-1]+cost.get(Op.INSERT);
					op[i][j]=Op.INSERT;
//					insert[j-1]=y[j-1];
				}
				
			}
		}
		return c[m][n];
	}
	
	public int editDistance(String[] x,String[] y,int m,int n){
		int[][] c=new int[m+1][n+1];
		Op[][] op=new Op[m+1][n+1];
		int[] costInt={0,1,1,1};
		HashMap<Op, Integer> cost=new HashMap<EditDistance.Op, Integer>();
		int cnt=0;
		for (Op ops : Op.values()) {
			cost.put(ops, costInt[cnt]);
			
			cnt++;
		}	
		String[] replace=new String[n];
		String[] insert=new String[n];
		int k=0;
		for (int i = 0; i <= m; i++) {
			c[i][0]=i*cost.get(Op.DELETE);
			op[i][0]=Op.DELETE;
		}
		for (int j = 0; j <= n; j++) {
			c[0][j]=j*cost.get(Op.INSERT);
			op[0][j]=Op.INSERT;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				c[i][j]=Integer.MAX_VALUE;
				if (x[i-1].equals(y[j-1])) {
					c[i][j]=c[i-1][j-1]+cost.get(Op.COPY);
					op[i][j]=Op.COPY;
				}
				if (!x[i-1].equals(y[j-1])&&c[i-1][j-1]+cost.get(Op.REPLACE)<c[i][j]) {
					c[i][j]=c[i-1][j-1]+cost.get(Op.REPLACE);
					op[i][j]=Op.REPLACE;
					replace[j-1]=y[j-1];
				}
				if (c[i-1][j]+cost.get(Op.DELETE)<c[i][j]) {
					c[i][j]=c[i-1][j]+cost.get(Op.DELETE);
					op[i][j]=Op.DELETE;
				}
				if (c[i][j-1]+cost.get(Op.INSERT)<c[i][j]) {
					c[i][j]=c[i][j-1]+cost.get(Op.INSERT);
					op[i][j]=Op.INSERT;
					insert[j-1]=y[j-1];
				}
				
			}
		}
		return c[m][n];
	}
	
	public static void main(String[] args) {
		EditDistance editDistance=new EditDistance();
		Scanner in=new Scanner(System.in);
		String input=in.nextLine();
		String[] arr=input.split(" ");
		String[] x=arr[0].split("");
		String[] y=arr[1].split("");
		System.out.println(editDistance.editDistance(arr[0], arr[1]));
		System.out.println(editDistance.editDistance(x, y,x.length,y.length));
	}

}
