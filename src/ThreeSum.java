import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)*/
public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
        /*Arrays.sort(nums);
        HashSet<List<Integer>> ans=new HashSet<List<Integer>>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			map.put(nums[i],i);
		}
        for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				int t=0-nums[i]-nums[j];
				if (map.containsKey(t)) {
					int k=map.get(t);
					if(k>j){
						ArrayList<Integer> list=new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(t);
						ans.add(list);
					}
				}
			}
		}
        return new ArrayList<List<Integer>>(ans);*/
		  	Arrays.sort(nums);
		    List<List<Integer>> res = new LinkedList<>();
		    for(int i = 0;i< nums.length-2;i++){
		        if(i==0 || (i>0 && nums[i] !=nums[i-1])){
		            int lo = i+1;
		            int hi = nums.length-1;
		            int sum = 0 - nums[i];
		            while(lo<hi){
		                if(nums[lo] + nums[hi]==sum){
		                	res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
		                	while(lo<hi && nums[lo]== nums[lo+1]) lo++;
		                	while(lo<hi && nums[hi] == nums[hi-1]) hi--;
		                	lo++; hi--; 
		                }else if(nums[lo]+nums[hi]<sum) {
		                	while (lo < hi && nums[lo] == nums[lo+1]) lo++;
		                	lo++;
		                }
		                else{
		                	while (lo < hi && nums[hi] == nums[hi-1]) hi--;
		                	hi--;
		                }
		             } 
		        }
		    }
		    return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums));
		
	}

}
