import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;


public class RandomPickIndex {

	private HashMap<Integer,Integer> map;
    private LinkedList<ArrayList<Integer>> list;
    
    public RandomPickIndex(int[] nums) {
    	map=new HashMap<Integer, Integer>();
    	list=new LinkedList<ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++){
            int k=nums[i];
            if(!map.containsKey(k)){
                map.put(k,list.size());
                ArrayList<Integer> tmp=new ArrayList<Integer>();
                tmp.add(i);
                list.add(tmp);
            } 
            else{
                
                list.get(map.get(k)).add(i);
            }
        }
    }
    
    public int pick(int target) {
        Random r=new Random();
        int ind=map.get(target);
        int sz=list.get(ind).size();
        int rind=r.nextInt(sz);
        return list.get(ind).get(rind);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num={1,2,3,3,3};
		RandomPickIndex rpi=new RandomPickIndex(num);
		int ret=rpi.pick(2);
		System.out.println(ret);
	}

}
