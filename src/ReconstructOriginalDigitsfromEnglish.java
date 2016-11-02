
/*Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"*/
public class ReconstructOriginalDigitsfromEnglish {

	public String originalDigits(String s) {
        int[] cnt=new int[26];
        for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			++cnt[c-'a'];
		}
        int[] num=new int[10];
        num[0]=cnt['z'-'a'];
        num[2]=cnt['w'-'a'];
        num[6]=cnt['x'-'a'];
        num[8]=cnt['g'-'a'];
        num[7]=cnt['s'-'a']-num[6];
        num[5]=cnt['v'-'a']-num[7];
        num[4]=cnt['f'-'a']-num[5];
        num[3]=cnt['h'-'a']-num[8];
        num[1]=cnt['o'-'a']-num[0]-num[2]-num[4];
        num[9]=cnt['i'-'a']-num[5]-num[6]-num[8];
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < num.length; i++) {
			int k=num[i];
			if (k>0) {
				while (k>0) {
					sb.append(i);
					--k;
				}
			}
		}
        return sb.toString();
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReconstructOriginalDigitsfromEnglish rodfe=new ReconstructOriginalDigitsfromEnglish();
//		String s="fviefuro";
		String s="owoztneoerzero";
		System.out.println(rodfe.originalDigits(s));
	}

}
