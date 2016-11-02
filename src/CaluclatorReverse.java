import java.util.Stack;


public class CaluclatorReverse {

	public double calculate(String s) {
        if (s == null) return 0;
        s = s.trim().replaceAll(" +", "");
        int length = s.length();
        
        double res = 1.0;
        double preVal = 1.0; // initial preVal is 0
        char sign = '*'; // initial sign is +
        char presign='*';
        int i = 0;
        while (i < length) {
            double curVal = 0;
            boolean flag=true;
            while (i < length && (int)s.charAt(i) <= 57 && (int)s.charAt(i) >= 48) { // int
                curVal = curVal*10 + (s.charAt(i) - '0');
                i++;
                flag=false;
            }
            if (flag) {
				//meet '('
            	presign=sign;
            	sign='(';
			}
            if (sign == '*') {
            	if (presign=='*') {
            		res *= preVal;  // update res
                    preVal = curVal;
				}else {
					res /= preVal;  // update res
                    preVal = curVal;
				}
            	presign='*';
                
            } else if (sign == '/') {
            	if (presign=='*') {
            		res *= preVal;  // update res
                    preVal = curVal;
				}else {
					res /= preVal;  // update res
                    preVal = curVal;
				}
            	presign='/';

            } else if (sign == '+') {
                preVal = preVal + curVal; // not update res, combine preVal & curVal and keep loop
            } else if (sign == '-') {
                preVal = preVal - curVal; // not update res, combine preVal & curVal and keep loop
            }
            if (i < length) { // getting new sign
                sign = s.charAt(i);
                i++;
            }
        }
        if (presign=='/') {
        	res /= preVal;
		}else {
			res *= preVal;
		}

        return res;
    }
	
	
	public static void main(String[] args) {
		CaluclatorReverse cr=new CaluclatorReverse();
		String s="1/5+4-2*4";
		double res=cr.calculate(s);
		System.out.println(res);
		
	}
}
