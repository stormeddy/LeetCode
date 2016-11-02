import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*Given a text file file.txt that contains list of phone numbers (one per line), write a one liner bash script to print all valid phone numbers.

You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)

You may also assume each line in the text file must not contain leading or trailing white spaces.

For example, assume that file.txt has the following content:

987-123-4567
123 456 7890
(123) 456-7890
Your script should output the following valid phone numbers:
987-123-4567
(123) 456-7890*/
public class ValidPhoneNumbers {
	
	public static  void Solution(String s) {
//		File file=new File("file.txt");
//		BufferedReader reader=new BufferedReader(new FileReader(file));
//		String s=null;
//		while ((s=reader.readLine()) != null!) {
			if (s.matches("((\\d{3}-)|(\\(\\d{3}\\) )){1}\\d{3}-\\d{4}")) {
				System.out.println(s);
			}
//		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution("123-456-7890");
		Solution("(123) 456-7890");
		Solution("123 456-7890");
	}

}
