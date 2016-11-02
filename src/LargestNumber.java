import java.util.Arrays;
import java.util.Comparator;


/*Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.*/
public class LargestNumber {

	public static String largestNumber(int[] nums) {
		int N = nums.length;
	    String[] strs = new String[N];
	    for(int i = 0; i< N; i++){
	        strs[i] = String.valueOf(nums[i]);
	    }

	    Arrays.sort(strs, new Comparator<String>(){
	        public int compare(String i, String j){
	            String str1 = i + j;
	            String str2 = j + i;
	            return str2.compareTo(str1);
	        }
	        });

	    if(strs[0].equals("0")) return "0";
	    StringBuilder sb = new StringBuilder();
	    for(String s: strs) sb.append(s);
	    return sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LargestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}));
	}

}
