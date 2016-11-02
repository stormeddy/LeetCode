

/*Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F (T and F represent True and False respectively).

Note:

The length of the given string is ¡Ü 10000.
Each number will contain only one digit.
The conditional expressions group right-to-left (as usual in most languages).
The condition will always be either T or F. That is, the condition will never be a digit.
The result of the expression will always evaluate to either a digit 0-9, T or F.
Example 1:

Input: "T?2:3"

Output: "2"

Explanation: If true, then result is 2; otherwise result is 3.
Example 2:

Input: "F?1:T?4:5"

Output: "4"

Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
          -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
          -> "4"                                    -> "4"
Example 3:

Input: "T?T?F:5:3"

Output: "F"

Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
          -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
          -> "F"                                    -> "F"*/
public class TernaryExpressionParser {
	
	public String parseTernary(String expression) {
        char[] a=expression.toCharArray();
        int n=a.length;
        int i=0;
        while (true) {
			char cur=a[i];
			if (cur!='T' && cur!='F') {
				return cur+"";
			}
			if (cur=='T') {
				if (i==n-1 || a[i+1]!='?') {
					return cur+"";
				}
				i=i+2;
			}else if (cur=='F') {
				if (i==n-1 || a[i+1]!='?') {
					return cur+"";
				}
				int judge=0;
				int maohao=0;
				i=i+2;
				while (true) {
					if (a[i]==':') {
						++maohao;
					}
					if (maohao>judge) {
						break;
					}
					if ((a[i]=='T'|| a[i]=='F') && a[i+1]=='?') {
						++judge;
					}
					++i;
				}
				++i;
			}
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TernaryExpressionParser tep=new TernaryExpressionParser();
		String s= "T?T?F:5:3" ;
		System.out.println(tep.parseTernary(s));
	}

}
