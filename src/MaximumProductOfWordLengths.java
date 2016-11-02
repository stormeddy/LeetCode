/*Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.*/
public class MaximumProductOfWordLengths {

/*	public int maxProduct(String[] words) {
        int max=0;
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(!common(words[i],words[j])){
                    int temp=words[i].length()*words[j].length();
                    if(temp>max) max=temp;
                }
            }
        }
        return max;
    }
    
    private boolean common(String a,String b){
        for(int i=0;i<a.length();i++){
            if(b.indexOf(a.charAt(i))!=-1) return true;
        }
        return false;
    }*/
	
	private static final int ONE = 1;
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            for (char c : words[i].toCharArray())
                a[i] |= ONE << c - 'a';
        int max = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if ((a[i] & a[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s={"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		System.out.println(new MaximumProductOfWordLengths().maxProduct(s));
	}

}
