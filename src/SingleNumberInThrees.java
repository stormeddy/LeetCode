import java.util.HashSet;
import java.util.Set;


public class SingleNumberInThrees {

	public static int select(int [] a){
		int ones=0,twos=0;
		int xthree;
		for(int i=0;i<a.length;i++){
			twos|=(ones&a[i]);
			ones^=a[i];
			xthree=~(ones&twos);
			ones=ones&xthree;
			twos=twos&xthree;
		}
		return twos;
	}
	
	public int singleNumber1(int[] nums) {
        Set<Integer> intSet = new HashSet<>(nums.length);
        Set<Integer> seenTwice = new HashSet<>(nums.length);
        for(int n : nums) {
        	if(!intSet.add(n)) {
        		seenTwice.add(n);
        	}
        }
        intSet.removeAll(seenTwice);
        return intSet.iterator().next();
    }
	
	public int singleNumber2(int[] nums) {
	    int ans = 0;
	    for(int i = 0; i < 32; i++) {
	        int sum = 0;
	        for(int j = 0; j < nums.length; j++) {
	            if(((nums[j] >> i) & 1) == 1) {
	                sum++;
	                sum %= 3;
	            }
	        }
	        if(sum != 0) {
	            ans |= sum << i;
	        }
	    }
	    return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={3,2,2,4,4,2,3,1,3,1,1};
		System.out.println(select(a));
	}

}
