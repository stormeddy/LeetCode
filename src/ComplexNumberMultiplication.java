/*Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:

The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.*/
public class ComplexNumberMultiplication {

	public String complexNumberMultiply(String x, String y) {
        String[] sx=x.split("\\+");
        int a=Integer.parseInt(sx[0]);
        String bs=sx[1].substring(0, sx[1].length()-1);
        int b=Integer.parseInt(bs);
        
        
        String[] sy=y.split("\\+");
        int c=Integer.parseInt(sy[0]);
        String ds=sy[1].substring(0, sy[1].length()-1);
        int d=Integer.parseInt(ds);
        
        StringBuffer sb= new StringBuffer();
        int re=a*c-b*d;
        int vi=a*d+b*c;
        sb.append(re);
        sb.append('+');
        sb.append(vi);
        sb.append('i');
        return sb.toString();
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexNumberMultiplication cnm=new ComplexNumberMultiplication();
		String x="1+-1i";
		String y="0+0i";
		System.out.println(cnm.complexNumberMultiply(x, y));
	}

}
