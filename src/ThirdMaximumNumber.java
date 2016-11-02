import java.util.TreeSet;

/*Given an array of integers, return the 3rd Maximum Number in this array, 
if it doesn't exist, return the Maximum Number. The time complexity must be O(n) or less.
*/public class ThirdMaximumNumber {

	public int thirdMax(int[] nums) {
//        int n=nums.length;
//        if(n==1) return nums[0];
//        if(n==2) return Math.max(nums[0],nums[1]);
//        int m=Integer.MIN_VALUE,sm=Integer.MIN_VALUE,tm=Integer.MIN_VALUE;
//        for(int i=0;i<n;i++){
//            int k=nums[i];
//            if(k>m){
//                m=k;
//                sm=m;
//                tm=sm;
//            }else if(k<=m&& k>sm){
//                sm=k;
//                tm=sm;
//            }else if(k<=sm&& k>tm){
//                tm=k;
//            }
//        }
//        return tm;
		TreeSet<Integer> c=new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int k=nums[i];
			c.add(k);
			if (c.size()>3) {
				c.pollFirst();
			}
		}
		if (c.size()<3) {
			return c.pollLast();
		}
		return c.pollFirst();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThirdMaximumNumber tmn=new ThirdMaximumNumber();
		int[] nums={1,2,2,5,3,5};
		int res=tmn.thirdMax(nums);
		System.out.println(res);
	}

}
