import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class CollectApples {
	
//	int[] mem;
//	boolean[][] contain;
	
	public int cal(int N,int n,HashSet<Integer> set,ArrayList<int[]> g){
		int[] mem=new int[N+1];
		for (int i = 0; i < mem.length; i++) {
			mem[i]=-1;
		}
		
		int max=0;
		boolean[] visited=new boolean[N+1];
		for (Integer cur:set) {
			int res=dfs(cur, N, n, set, g, visited);
			max=Math.max(res, max);
		}
		
		return max;
	}
	
	public int cal(int N,int n,int[] set,int[][] g){
		ArrayList<int[]> gr=new ArrayList<int[]>();
		for (int i = 0; i < g.length; i++) {
			gr.add(g[i]);
		}
		HashSet<Integer> ss=new HashSet<Integer>();
		for (int c : set) {
			ss.add(c);
		}
		return cal(N, n, set, g);
	}
	
	public int dfs(int cur,int N,int n,HashSet<Integer> set,ArrayList<int[]> g, boolean[] visited){
//		if (mem[cur]!=-1) {
//			return mem[cur];
//		}
		int max=0;
		for (int[] is : g) {
			int res=0;
			if (is[0]==cur) {
				visited[cur]=true;
				if (set.contains(cur)) {
					++res;
				}
				if (!visited[is[1]]) {
					res+=dfs(is[1], N, n, set, g, visited);
//					contain[cur][is[1]]=true;
				}
				visited[cur]=false;
			}else if (is[1]==cur) {
				visited[cur]=true;
				if (set.contains(cur)) {
					++res;
				}
				if (!visited[is[0]]) {
					res+=dfs(is[0], N, n, set, g, visited);
				}
				visited[cur]=false;
//				System.out.println(res);
			}
			max=Math.max(max, res);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int n=in.nextInt();
		HashSet<Integer> set=new HashSet<Integer>();
		int[] app=new int[n];
		for (int i = 0; i < n; i++) {
			app[i]=in.nextInt();
			set.add(app[i]);
		}
		ArrayList<int[]> g=new ArrayList<int[]>();
		while (in.hasNext()) {
			int[] cur=new int[2];
			cur[0]=in.nextInt();
			cur[1]=in.nextInt();
			g.add(cur);
		}
		CollectApples ca=new CollectApples();    
		int res=ca.cal(N, n, set, g);
		System.out.println(res);
	}
/*
8 4
2 3 5 6
1 2
1 3
2 4
2 5
3 6
3 7
6 8

4 3
2 3 4
1 2
1 3
1 4

*/
	
	
}
