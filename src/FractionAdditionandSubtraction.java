import java.util.Collections;

/*Given a string representing an expression of fraction addition and subtraction, you need to return the calculation result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.

Example 1:
Input:"-1/2+1/2"
Output: "0/1"
Example 2:
Input:"-1/2+1/2+1/3"
Output: "1/3"
Example 3:
Input:"1/3-1/2"
Output: "-1/6"
Example 4:
Input:"5/3+1/3"
Output: "2/1"
Note:
The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
Each fraction (input and output) has format ¡Ànumerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
The number of given fractions will be in the range [1,10].
The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.*/
public class FractionAdditionandSubtraction {

	public String fractionAddition(String expression) {
		expression=expression+'+';
        char[] c=expression.toCharArray();
        int flag=1;
        int nom=0;
        int den=10;
        int pre_nom=0;
        int pre_den=10;
        boolean is_nom=true;
        for (int i=0;i<c.length;i++) {
        	char d=c[i];
			if (d=='-') {
				nom=nom*pre_den+flag*den*pre_nom;
				den=den*pre_den;
				int gcd=euclid(nom, den);
				nom=nom/gcd;
				den=den/gcd;
				flag=-1;
			}else if (d>='0'&&d<='9'&&is_nom) {
				if (i<c.length-1&&c[i+1]=='0') {
					i++;
					pre_nom=10;
				}else {
					pre_nom=d-'0';
				}
				is_nom=false;
			}else if (d>='0'&&d<='9'&&!is_nom) {
				if (i<c.length-1&&c[i+1]=='0') {
					i++;
					pre_den=10;
				}else {
					pre_den=d-'0';
				}
				is_nom=true;
			}else if (d=='+') {
				nom=nom*pre_den+flag*den*pre_nom;
				den=den*pre_den;
				int gcd=euclid(nom, den);
				nom=nom/gcd;
				den=den/gcd;
				flag=1;
			}
		}
        StringBuffer sb=new StringBuffer();
        if ((nom<0&&den>0 )||(nom>0&&den<0)) {
			sb.append('-');
		}
        sb.append(Math.abs(nom));
        sb.append('/');
        sb.append(Math.abs(den));
        return sb.toString();
    }
	
	public int euclid(int a,int b){
		if (b==0) {
			return a;
		}else {
			return euclid(b, a%b);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FractionAdditionandSubtraction fas=new FractionAdditionandSubtraction();
//		String expression="-1/2+1/2";
//		String expression="-1/2+1/2+1/3";
		String expression="1/3-1/2";
//		String expression="5/3+1/3";
//		System.out.println(fas.fractionAddition(expression));
		String t="";
		System.out.println(t.isEmpty());
		Collections.singleton(null);
	}

}
