import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/*Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]*/
public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> judge=new HashSet<List<Integer>>();
        backTrack(sets,judge,new ArrayList<Integer>(),candidates,0,target,candidates.length);
//        Collections.sort(sets, new Comparator<List<Integer>>() {
//
//			@Override
//			public int compare(List<Integer> o1, List<Integer> o2) {
//				// TODO Auto-generated method stub
//				int len1=o1.size();
//				int len2=o2.size();
//				for(int i=0;i<Integer.min(len1, len2);i++){
//					if(o1.get(i)<o2.get(i)) return -1;
//					else if(o1.get(i)>o2.get(i)) return 1;
//					else ;
//				}
//				return len1<len2?-1:(len1>len2?1:0);
//			}
//		});
//        for(int i=sets.size()-1;i>=1;i--){
//            if(sets.get(i).toString().equals(sets.get(i-1).toString())) sets.remove(i);
//        }
        return sets;
    }
    public void backTrack(List<List<Integer>> sets,HashSet<List<Integer>> judge,List<Integer> path,int[] nums,int sum,int target,int index){
        if(sum==target&&!judge.contains(path)){
            sets.add(new ArrayList<Integer>(path));
            judge.add(path);
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=index-1;i>=0;i--){
            sum += nums[i];
            path.add(0,nums[i]);
            backTrack(sets,judge,path,nums,sum,target,i);
            sum -= nums[i];
            path.remove(0);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={4,1,1,4,4,4,4,2,3,5};
		int target=10;
		CombinationSumII c=new CombinationSumII();
		System.out.println(c.combinationSum2(a, target));
	}

}
