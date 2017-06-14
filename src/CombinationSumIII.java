import java.util.ArrayList;
import java.util.List;

/*Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]*/
public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        backTrack(sets,new ArrayList<Integer>(),candidates,0,k,n,candidates.length);
        return sets;
    }
    public void backTrack(List<List<Integer>> sets,List<Integer> path,int[] nums,int sum,int size,int target,int index){
        if(sum==target&&path.size()==size){
            sets.add(new ArrayList<Integer>(path));
            return;
        }
        if(sum>target||path.size()>=size){
            return;
        }
        for(int i=index-1;i>=0;i--){
            sum += nums[i];
            path.add(0,nums[i]);
            backTrack(sets,path,nums,sum,size,target,i);
            sum -= nums[i];
            path.remove(0);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumIII c=new CombinationSumIII();
		System.out.println(c.combinationSum3(3, 15));
	}

}
