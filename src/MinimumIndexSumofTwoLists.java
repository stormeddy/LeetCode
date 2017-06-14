import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.*/
public class MinimumIndexSumofTwoLists {

	public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> m1=new HashMap<String, Integer>();
        for (int i=0;i<list1.length;i++) {
			m1.put(list1[i], i);
		}
        
        HashMap<String, Integer> m2=new HashMap<String, Integer>();
        for (int i=0;i<list2.length;i++) {
			m2.put(list2[i], i);
		}
        
        HashMap<String, Integer> m=new HashMap<String, Integer>();
        for (String t : m1.keySet()) {
			if (m2.containsKey(t)) {
				m.put(t, m1.get(t)+m2.get(t));
			}
		}
        
        int min=Integer.MAX_VALUE;
        for (String t : m.keySet()) {
			if (m.get(t)<min) {
				min=m.get(t);
			}
		}
        
        ArrayList<String> ret=new ArrayList<String>();
        for (String t : m.keySet()) {
			if (m.get(t)==min) {
				ret.add(t);
			}
		}
        
        return (String[])ret.toArray(new String[ret.size()]);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
