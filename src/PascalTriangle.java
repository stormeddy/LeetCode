import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
public class PascalTriangle {

	 public static List<List<Integer>> generate(int numRows) {
	        
	        List<List<Integer>> list=new ArrayList<List<Integer>>();
	        if(numRows==0) return list;
	        
	            ArrayList<Integer> t=new ArrayList<>();
	            t.add(1);
	            list.add(t);
	        
	        for(int j=2;j<=numRows;j++){
	            ArrayList<Integer> s=new ArrayList<>(j);
	            s.add(0,1);
	            
	            for(int k=1;k<=j-2;k++){
	                s.add(k,list.get(j-2).get(k)+list.get(j-2).get(k-1));
	            }
	            s.add(j-1,1);
	            list.add(s);
	        }
	        return list;
	    }
	 
	 public static List<Integer> getRow(int rowIndex) {
	        List<Integer> pre=new ArrayList<>(rowIndex+1);
	        List<Integer> cur=new ArrayList<>(rowIndex+1);
	        if(rowIndex==0) {cur.add(1); return cur;}
	        pre.add(1);pre.add(1);
	        cur.add(1);cur.add(1);
	        for(int i=2;i<=rowIndex;i++){
	        	cur.clear();
	            cur.add(0,1);
	            for(int k=1;k<=i-1;k++){
	                cur.add(pre.get(k)+pre.get(k-1));
	            }
	            cur.add(1);
	            pre.add(0);
	            Collections.copy(pre,cur);
	        }
	        return cur;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(generate(10));
		System.out.println(getRow(10));
		
	}

}
