/*IMPORTANT:
Solutions which uses a BigInteger library or converting the input strings to another type (such as integer) will result in disqualification of all submissions to this problem.
After the contest ends, users can view accepted submissions code and report cheating solutions.

Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.*/
public class AddStrings {

	public String addStrings(String num1, String num2) {
		
		while (num1.length()<num2.length()) {
			num1='0'+num1;			
		}
		while (num2.length()<num1.length()) {
			num2='0'+num2;			
		}
        char[] n1=num1.toCharArray();
        char[] n2=num2.toCharArray();
        int[] sum=new int[n1.length+1];
        for (int i = n1.length-1; i >= 0; i--) {
			int d1=n1[i]-'0';
			int d2=n2[i]-'0';
			sum[i+1]=d1+d2;
		}
        int carry=0;
        for (int i = sum.length-1; i >= 0; i--) {
        	int tmp=(sum[i]+carry)%10;
        	carry=(sum[i]+carry)/10;
        	sum[i]=tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : sum) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddStrings as=new AddStrings();
		String num1="4";
		String num2="43";
		String sum=as.addStrings(num1, num2);
		System.out.println(sum);
	}

}
