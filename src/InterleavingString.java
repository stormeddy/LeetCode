/*Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.*/
public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		// char[] a1=s1.toCharArray();
		// char[] a2=s2.toCharArray();
		// char[] a3=s3.toCharArray();
		// int l1=a1.length,l2=a2.length,l3=a3.length;
		// if (l3!=l1+l2) {
		// return false;
		// }
		// int i=l1-1,j=l2-1,k=l3-1;
		// while (k>=0) {
		// char c=a3[k];
		// if (i>=0 && j>=0 && a1[i]==a2[j]) {
		// if (c==a1[i]) {
		// return isInterleave(s1.substring(0, i), s2.substring(0, j+1),
		// s3.substring(0, k))
		// || isInterleave(s1.substring(0, i+1), s2.substring(0, j),
		// s3.substring(0, k));
		// }else {
		// return false;
		// }
		// }else {
		// if (i>=0 && c==a1[i]) {
		// --k;
		// --i;
		// }else if (j>=0 && c==a2[j]) {
		// --k;
		// --j;
		// }else {
		// return false;
		// }
		// }
		//
		// }
		// return true;

		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		char[] a3 = s3.toCharArray();
		if (s3.length() != s1.length() + s2.length())
			return false;

		boolean[][] table = new boolean[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < s1.length() + 1; i++)
			for (int j = 0; j < s2.length() + 1; j++) {
				if (i == 0 && j == 0)
					table[i][j] = true;
				else if (i == 0)
					table[i][j] = (table[i][j - 1] && a2[j - 1] == a3[i + j - 1]);
				else if (j == 0)
					table[i][j] = (table[i - 1][j] && a1[i - 1] == a3[i + j - 1]);
				else
					table[i][j] = (table[i - 1][j] && a1[i - 1] == a3[i + j - 1])
							|| (table[i][j - 1] && a2[j - 1] == a3[i + j - 1]);
			}

		return table[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		//
		// "aabc"
		// "abad"
		// "aabadabc"
		// TODO Auto-generated method stub
		InterleavingString is = new InterleavingString();
		String s1 = "aabc", s2 = "abad";
		// String s3="aadbbcbcac";
		String s3 = "aabadabc";
		System.out.println(is.isInterleave(s1, s2, s3));
	}

}
