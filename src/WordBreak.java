import java.util.HashSet;
import java.util.Set;

/*Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".*/
public class WordBreak {
	public static boolean wordBreak(String s, Set<String> wordDict) {
		// dp[i] stores whether wordBreak( s.substring(0, i) ) is true.
		// If dp[i] is true and wordDict contains the s.substring(i, s.length() ), then we return true;
		  	if(wordDict.contains(s)){ return true;}
		    boolean[] dp = new boolean[s.length()];
		    dp[0] = true;
		    for(int i = 1; i < s.length(); i++){
		        if(wordDict.contains(s.substring(0, i))){
		            dp[i] = true;
		        }
		        else{
		            for(int j = i - 1; j >= 0; j--){
		                if(wordDict.contains(s.substring(j, i)) && dp[j]){
		                    dp[i] = true;
		                    break;
		                }
		            }
		        }
		        if(dp[i] && wordDict.contains(s.substring(i, s.length()))){
		            return true;
		        }
		    }
		    return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aaaaaaa";
		Set<String> set=new HashSet<String>();
		set.add("aaaa");
		set.add("aaa");
//		set.add("a");
		System.out.println(wordBreak(s, set));
	}

}
