
import java.util.Stack;  
  
public class ExpEval {  
    private static final String OPR = "+-*/()#";  
    /** 
     *���岻ͬ����������֮������ȼ� 
     *����Ϊ: +,-,*,/,(,),# 
     */  
    private static final boolean[][] relations = {  
        {false,false,false,false,false,false,true},  
        {false,false,false,false,false,false,true},  
        {true,true,false,false,false,false,true},  
        {true,true,false,false,false,false,true},  
        {true,true,true,true,false,false,true},  
        {true,true,true,true,false,false,true},  
        {false,false,false,false,false,false,false},  
    };  
  
    private static double eval(String string) {  
        String postfixExp = transfor(string);  
        System.out.println(postfixExp);  
        return cal(postfixExp);//�ɺ�׺���ʽ������  
    }  
  
    /** 
      * ����׺���ʽת��Ϊ��׺���ʽ  
      * @param string 
      * @return 
      */  
    private static String transfor(String string) {  
        StringBuilder sb = new StringBuilder();  
        Stack<Character> sk = new Stack<Character>();//��¼������  
        sk.push('#');  
        for (int i = 0; i < string.length(); i++) {  
            char c = string.charAt(i);  
            if (isNumber(c)) {  
                sb.append(c);// ���ּӵ���׺���ʽ��  
            } else if (c == '(') {  
                sk.push(c);  
            } else if (c == ')') {  
                while (sk.peek() != '(') {  
                    sb.append(sk.pop());  
                }  
                sk.pop();//���ٽ���'('����ջ  
            } else {  
               boolean cp =  priority(c, sk.peek());  
               if (!cp && sk.peek() != '(') {//��ǰ���������ȼ�����ջ������'('  
                   do {  
                       sb.append(sk.pop());  
                       cp = priority(c, sk.peek());  
                   } while (!cp);  
               }  
               sk.push(c);  
            }  
        }  
        while (sk.peek() != '#') {  
            sb.append(sk.pop());  
        }  
        return sb.toString();  
    }  
      
    private static double cal(String postfixExp) {  
        Stack<String> sk = new Stack<String>();  
        for (int i = 0; i < postfixExp.length(); i++) {  
            char c = postfixExp.charAt(i);  
            if(c == ' ') break;  
            if(isNumber(c)) {  
               sk.push(String.valueOf(c));//������ջ   
            } else {  
                double rightNum = Double.valueOf(sk.pop());  
                double leftNum = Double.valueOf(sk.pop());  
                double r = simpleCal(leftNum, c, rightNum);  
                sk.push(String.valueOf(r));  
            }  
        }  
        return Double.valueOf(sk.pop());  
    }  
  
    private static double simpleCal(double leftNum, char c, double rightNum) {  
        switch (c) {  
        case '+':  
            return leftNum + rightNum;  
        case '-':  
            return leftNum - rightNum;  
        case '*':  
            return leftNum * rightNum;  
        case '/':  
            return leftNum / rightNum;  
        default:  
            throw new RuntimeException();  
        }  
    }  
      
    /** 
      * �Ƚϲ����������ȼ� 
      * @param c 
      * @param peek 
      * @return 
      */  
    private static boolean priority(char c, char peek) {  
        int m = OPR.indexOf(c);  
        int n = OPR.indexOf(peek);  
        return relations[m][n];  
    }  
  
    private static boolean isNumber(char c) {  
        switch (c) {  
        case '0':  
            return true;  
        case '1':  
            return true;  
        case '2':  
            return true;  
        case '3':  
            return true;  
        case '4':  
            return true;  
        case '5':  
            return true;  
        case '6':  
            return true;  
        case '7':  
            return true;  
        case '8':  
            return true;  
        case '9':  
            return true;  
        }  
        return false;  
    }  
      
    public static void main(String[] args) {  
        System.out.println(eval("3+4*5/(6-2)"));  
    }  
} 