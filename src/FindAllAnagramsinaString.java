import java.util.ArrayList;
import java.util.List;

/*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".*/
public class FindAllAnagramsinaString {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res=new ArrayList<Integer>();
		if (s.length()<p.length()) {
			return res;
		}
        char[] sa=s.toCharArray();
        char[] sp=p.toCharArray();
        int sl=sa.length;
        int pl=sp.length;
        for (int i = 0; i < sl-pl+1; i++) {
			if (isAnagram(sa,i, sp,0)) {
				res.add(i);
			}
		}
		return res;
    }
	
	private boolean isAnagram(char[] sa,int si, char[] ta,int ti) {
		
		int[] k=new int[26];
		for (int i = 0; i < ta.length; i++) {
			++k[ta[i]-'a'];
			--k[sa[i+si]-'a'];
		}
		for (int i = 0; i < k.length; i++) {
			if (k[i]!=0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindAllAnagramsinaString faas=new FindAllAnagramsinaString();
//		boolean res=faas.isAnagram("ab", "ba");
//		System.out.println(res);
	}

}
