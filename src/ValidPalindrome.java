/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.*/
public class ValidPalindrome {

	public static boolean isPalindrome(String s) {
//        s=s.toLowerCase();
//        s=s.replaceAll("[^a-z|0-9]", "");
//        char[] c=s.toCharArray();
//        int n=c.length;
//        for (int i = 0; i < n/2; i++) {
//			if (c[i]!=c[n-1-i]) {
//				return false;
//			}
//		}
//        System.out.println(s);
//		return true;
		for(int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if(!Character.isLetterOrDigit(s.charAt(i))) {
                ++j;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))) {
                --i;
                continue;
            }            
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } 
        }
        return true;
    
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s="A man, a plan, a canal: Panama";
		String s="0P";
		System.out.println(s.toLowerCase());
		System.out.println(isPalindrome(s));
	}

}
