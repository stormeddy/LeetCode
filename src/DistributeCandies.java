import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.

Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
The sister has three different kinds of candies. 
Example 2:
Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
The sister has two different kinds of candies, the brother has only one kind of candies. 
Note:

The length of the given array is in range [2, 10,000], and will be even.
The number in given array is in range [-100,000, 100,000].*/
public class DistributeCandies {

	public static int distributeCandies(int[] candies) {
//        HashMap<Integer,Integer> m=new HashMap<>();
        HashSet<Integer> s=new HashSet<Integer>();
        for(int i:candies){
//            m.put(i,m.getOrDefault(i,0)+1);
            s.add(i);
        }
        if (s.size()>=candies.length/2) {
			return candies.length/2;
		}else {
			return s.size();
		}
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candies={1,1,2,3};
		System.out.println(distributeCandies(candies));
	}

}
