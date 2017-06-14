import java.util.Arrays;

/*Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]*/
public class ReverseStringII {

	public String reverseStr(String s, int k) {
        if(k==1) return s;
        StringBuffer sb=new StringBuffer();
        int n=s.length();
        int c=n/(k*2);
        for(int i=0;i<=c;i++){
            StringBuffer p1=new StringBuffer(s.substring(i*2*k,i*2*k+k));
            sb.append(p1.reverse());
            StringBuffer p2=new StringBuffer(s.substring(i*2*k+k,i*2*k+2*k));
            sb.append(p2);
        }
        int resi=n-c*2*k;
        if(resi<k){
            StringBuffer last=new StringBuffer(s.substring(n-resi,n));
            sb.append(last.reverse());
        }else{
            StringBuffer last=new StringBuffer(s.substring(n-resi,n-resi+k));
            sb.append(last.reverse());
            sb.append(n-resi+k);
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] res=new int[0];
		System.out.println(res.length);
		System.out.println(Arrays.toString(res));
	}

}
