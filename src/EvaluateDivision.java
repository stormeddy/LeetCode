import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/*Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> euqations, vector<double>& values, vector<pair<string, string>> query . where equations.size() == values.size(),the values are positive. this represents the equations.return vector<double>. . 
The example above: equations = [ ["a", "b"], ["b", "c"] ]. values = [2.0, 3.0]. queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.*/
public class EvaluateDivision {
	
	private static final int WHITE = 0;
	private static final int GRAY = 1;
	private static final int BLACK = 2;
	
	private int[] color;
	private int[] parent;

	public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
		int n=values.length;
		int len=query.length;
		double[] ret=new double[len];
        HashMap<String,Integer> map=new HashMap<>();
        int k=0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < 2; j++) {
        		if (!map.containsKey(equations[i][j])) {
    				map.put(equations[i][j], k);
    				++k;
    			}
			}			
		}
        
        double[][] result=new double[k][k];
        for (int i = 0; i < result.length; i++) {
			result[i][i]=1.0;
		}
        
        for (int i = 0; i < n; i++) {
        	int x=map.get(equations[i][0]);
        	int y=map.get(equations[i][1]);
        	result[x][y]=values[i];
        	result[y][x]=1.0/values[i];
		}
        
        dfs(result);
        
        for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				if (i!=j && result[i][j]==0.0) {
					LinkedList<Integer> path=new LinkedList<Integer>();
					get_path(i, j, path);
					if (path.size()>2) {
						double t=1.0;
						for (int p = 0; p < path.size()-1; p++) {
							t*=result[path.get(p)][path.get(p+1)];
						}
						result[i][j]=t;
						result[j][i]=1.0/t;
					}
					if (result[i][j]==0.0) {
						result[i][j]=-1.0;
						result[j][i]=-1.0;
					}
				}
			}
		}
        
        
		for (int i = 0; i < len; i++) {
			if (map.containsKey(query[i][0]) && map.containsKey(query[i][1])) {
				int x = map.get(query[i][0]);
				int y = map.get(query[i][1]);
				ret[i] = result[x][y];
			} else {
				ret[i] = -1.0;
			}

		}
        return ret;
        
    }
	
	public void dfs(double[][] result){
		int n=result.length;
		color=new int[n];
		parent=new int[n];
		for (int i = 0; i < n; i++) {
			color[i]=WHITE;
			parent[i]=-1;
		}
		for (int i = 0; i < n; i++) {
			if (color[i]==WHITE) {
				dfs_visit(result,i);
			}
		}
	}
	
	public void dfs_visit(double[][] result,int i){
		color[i]=GRAY;
		for (int j = 0; j < result.length; j++) {
			if (j!=i && result[i][j]!=0.0 && color[j]==WHITE) {
				parent[j]=i;
				dfs_visit(result, j);
			}
		}
		color[i]=BLACK;
	}
	
	public void get_path(int u,int v,LinkedList<Integer> paths){
		LinkedList<Integer> path=new LinkedList<Integer>();
		get_src_path(u, v, path);
		if ( parent[u]!=-1 && parent[v]!=-1 && (!path.contains(u)||!path.contains(v)) ) {
			LinkedList<Integer> p1=new LinkedList<Integer>();
			get_src_path(u, p1);
			LinkedList<Integer> p2=new LinkedList<Integer>();
			get_src_path(v, p2);
			if (p1.get(0)==p2.get(0)) {
				Collections.reverse(p1);
				paths.addAll(p1);
				paths.addAll(p2);
			}else {
				return;
			}
			
		}else {
			paths.addAll(path);
		}
	}
	
	public void get_src_path(int v, LinkedList<Integer> path){
		if (parent[v]==-1) {
			path.addFirst(v);
		}else if (parent[v]!=-1) {
			get_src_path( parent[v], path);
			path.add(v);
		}
	}
	
	public void get_src_path(int s,int v, LinkedList<Integer> path){
		if (s==v) {
			path.addFirst(s);
		}else if (parent[v]!=-1) {
			get_src_path(s, parent[v], path);
			path.add(v);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvaluateDivision ed = new EvaluateDivision();
//		String[][] equations = { { "a", "b" }, { "b", "c" } };
//		double[] values = { 2.0, 3.0 };
//		String[][] queries = { { "a", "c" }, { "b", "a" }, { "a", "e" },
//				{ "a", "a" }, { "x", "x" } };

		String[][] equations = { { "x1", "x2" }, { "x2", "x3" } ,
								{"x1","x4"},{"x2","x5"} };
		double[] values = { 3,0.5,3.4,5.6 };
		String[][] queries = { { "x2", "x4" }, { "x1", "x5" }, { "x1", "x3" },
				{ "x5", "x5" }, { "x5", "x1" },{"x3","x4"},{"x4","x3"},{"x6","x6"},{"x0","x0"} };
		
		double[] ret = ed.calcEquation(equations, values, queries);
		System.out.println(Arrays.toString(ret));
	}
}
