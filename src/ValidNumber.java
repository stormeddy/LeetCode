
import java.util.regex.Pattern;

/*Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.*/
public class ValidNumber {
	public boolean isNumber(String s) {
        String reg="[-+]?([0-9]+((\\.[0-9]*)?)|\\.[0-9]+)(e[-+]?[0-9]+)?";
//        String reg="(e[-+]?[0-9]+)?";
        return Pattern.matches(reg,s);
    }
	
	
	public static void main(String[] args) {
		ValidNumber vn=new ValidNumber();
//		System.out.println(vn.isNumber(".e4"));
		System.out.println(vn.isNumber("0e"));
	}
}
