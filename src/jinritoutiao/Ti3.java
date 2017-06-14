package jinritoutiao;

import java.util.HashMap;
import java.util.Scanner;

public class Ti3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, char[][]> m=new HashMap<Character, char[][]>();
		char[][] a0={{'*','*','*','*','*'},
				{'*',' ',' ',' ','*'},
				{'*','*','*','*','*'}};
		m.put('0', a0);
		
		char[][] a1={{'*','*','*','*','*'},
				};
		m.put('1', a1);
		
		char[][] a2={{'*',' ','*','*','*'},
				{'*',' ','*',' ','*'},
				{'*','*','*',' ','*'}};
		m.put('2', a2);
		
		char[][] a3={{'*',' ','*',' ','*'},
				{'*',' ','*',' ','*'},
				{'*','*','*','*','*'}};
		m.put('3', a3);
		
		char[][] a4={{'*','*','*',' ', ' '},
				{' ',' ','*',' ',' '},
				{'*','*','*','*','*'}};
		m.put('4', a4);
		
		char[][] a5={{'*','*','*',' ','*'},
				{'*',' ','*',' ','*'},
				{'*',' ','*','*','*'}};
		m.put('5', a5);
		
		
		char[][] a6={{'*','*','*','*','*'},
				{'*',' ','*',' ','*'},
				{'*',' ','*','*','*'}};
		m.put('6', a6);
		
		char[][] a7={{'*',' ',' ',' ',' '},
				{'*',' ',' ',' ',' '},
				{'*','*','*','*','*'}};
		m.put('7', a7);
		
		char[][] a8={{'*','*','*','*','*'},
				{'*',' ','*',' ','*'},
				{'*','*','*','*','*'}};
		m.put('8', a8);
		
		char[][] a9={{'*','*','*',' ','*'},
				{'*',' ','*',' ','*'},
				{'*','*','*','*','*'}};
		m.put('9', a9);
		
		
		char[][] aplus={{' ',' ','*',' ',' '},
				{' ','*','*','*',' '},
				{' ',' ','*',' ',' '}};
		m.put('+', aplus);
		
		char[][] aminus={{' ',' ','*',' ',' '},
				{' ',' ','*',' ',' '},
				{' ',' ','*',' ',' '}};
		m.put('-', aminus);
		
		char[][] amul={{' ','*',' ','*',' '},
				{' ',' ','*',' ',' '},
				{' ','*',' ','*',' '}};
		m.put('*', amul);
		
		char[][] adiv={{' ',' ',' ','*',' '},
				{' ',' ','*',' ',' '},
				{' ','*',' ',' ',' '}};
		m.put('/', adiv);
		
		char[][] adian={{' ',' ',' ','*','*'},
				{' ',' ',' ','*','*'}
				};
		m.put('.', adian);
		
		char[][] aequ={{' ','*',' ','*',' '},
				{' ','*',' ','*',' '},
				{' ','*',' ','*',' '},
				{' ','*',' ','*',' '},};
		m.put('=', aequ);
		
//		for (int i = 0; i < a0.length; i++) {
//			System.out.println(Arrays.toString(a0[i]));
//		}
		
		
/*		
		10 + 31
		
		*  ***       ***  *        * *  *
		*  * *   *     *  *  ****  * *  *
		*  * *  ***  ***  *        ***  *
		*  * *   *     *  *  ****    *  *
		*  ***       ***  *          *  *
		
*/
		
		Scanner in=new Scanner(System.in);
		String s=in.nextLine();
//		String s="2/5";
		
		double ans=calculate(s);


		int int_ans=(int)ans;
		if (ans==int_ans) {
			s=s+"="+int_ans;
		}else {
			ans=Math.round(ans*100)/100.0;
			s=s+"="+ans;
		}
		String[] c=s.split("");
//		System.out.println(Arrays.toString(c));
		
		int num=0;
		for (int i = 0; i < c.length; i++) {
			char cur=c[i].charAt(0);
			if (cur==' ') {
				continue;
			}else{
				if (cur=='1') {
					num+=1;
				}else if (cur=='='){
					num+=4;
				}else {
					num+=3;
				}
				 num+=2;
			}
				
		}
		
//		System.out.println(num);
		char[][] res=new char[num][5];
		int ind=0;
		for (int i = 0; i < c.length; i++) {
			char cur=c[i].charAt(0);
			if (cur==' ') {
				continue;
			}else{
//				if (cur=='1') {
//					num+=1;
//				}else if (cur=='='){
//					num+=4;
//				}else {
//					num+=3;
//				}
				 char[][] t=m.get(cur);
				 for (int j = 0; j < t.length; j++) {
					for (int k = 0; k < 5; k++) {
						res[j+ind][k]=t[j][k];
					}
				}
				 ind+=t.length;
				 
				 for (int j = 0; j < 2; j++) {
					 for (int k = 0; k < 5; k++) {
							res[j+ind][k]=' ';
						}
				}
				ind+=2;
			}
		}
		
		
		char[][] res2=new char[5][num];
		
		for (int i = 0; i < res2.length; i++) {
			for (int j = 0; j < res2[0].length-2; j++) {
				res2[i][j]=res[j][i];
			}
		}
		
		for (int i = 0; i < res2.length; i++) {
			for (int j = 0; j < res2[0].length-2; j++) {
				System.out.print(res2[i][j]);
			}
			System.out.println();
		}
		
		

	}
	
	public static double calculate(String s) {
        
        s = s.trim().replaceAll(" +", "");
        int length = s.length();
        
        double res = 0.0;
        double preVal = 0; // initial preVal is 0
        char sign = '+'; // initial sign is +
        int i = 0;
        while (i < length) {
            double curVal = 0;
            while (i < length && (int)s.charAt(i) <= 57 && (int)s.charAt(i) >= 48) { // int
                curVal = curVal*10 + (s.charAt(i) - '0');
                i++;
            }
            if (sign == '+') {
                res += preVal;  // update res
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;  // update res
                preVal = -curVal;
            } else if (sign == '*') {
                preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
            } else if (sign == '/') {
                preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
            }
            if (i < length) { // getting new sign
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }

}
