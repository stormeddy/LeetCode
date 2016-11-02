/*Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".*/
public class ReverseWordsInString {

	public static String reverseWords(String s) {
		s=s.trim();
        s=s.replaceAll("\\s+"," ");
        String[] string=s.split(" ");
        String res="";
        for (int i = string.length-1; i >=0 ; i--) {
			res=res+string[i]+" ";
		}
        return res.trim();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(reverseWords("  the    sky is blue!  "));
//		System.out.println(4);
	}

}
