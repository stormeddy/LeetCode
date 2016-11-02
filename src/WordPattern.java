import java.util.HashMap;

/*Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.*/
public class WordPattern {

	 public static boolean wordPattern(String pattern, String str) {
		 	if (pattern.equals("")) {
				return false;
			}
	        String[] s1=pattern.split("");
	        String[] s2=str.split(" ");
	        HashMap<String,String> map1=new HashMap<>();
	        HashMap<String,String> map2=new HashMap<>();
	        if (s1.length!=s2.length) {
				return false;
			}
	        for(int i=0;i<s1.length;i++){
	            if(map1.containsKey(s1[i])&&!map1.get(s1[i]).equals(s2[i])){
	                return false;
	            }
	            if (map2.containsKey(s2[i])&&!map2.get(s2[i]).equals(s1[i])) {
					return false;
				}
	            map1.put(s1[i],s2[i]);
	            map2.put(s2[i], s1[i]);
	        }
	        return true;
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(wordPattern("abba", "dog dog dog dog")
				);
	}

}
