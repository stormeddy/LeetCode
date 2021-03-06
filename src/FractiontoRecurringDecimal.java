import java.util.HashMap;

/*Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
Hint:

No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.*/
public class FractiontoRecurringDecimal {

	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder result = new StringBuilder();
	    String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
	    long num = Math.abs((long) numerator);
	    long den = Math.abs((long) denominator);
	    result.append(sign);
	    result.append(num / den);
	    long remainder = num % den;
	    if (remainder == 0)
	        return result.toString();
	    result.append(".");
	    HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
	    while (!hashMap.containsKey(remainder)) {
	        hashMap.put(remainder, result.length());
	        result.append(10 * remainder / den);
	        remainder = 10 * remainder % den;
	    }
	    int index = hashMap.get(remainder);
	    result.insert(index, "(");
	    result.append(")");
	    return result.toString().replace("(0)", "");
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=1,b=777;
		FractiontoRecurringDecimal frd=new FractiontoRecurringDecimal();
		String res=frd.fractionToDecimal(a, b);
		System.out.println(res);
	}

}
