import java.util.HashMap;
import java.util.Scanner;

//Problem Description:
//СB׼����ʼ�µ�ְҵ���ģ����ڴ������쳣�𱬣�СBҲ����ȥ�մ����֣���ӦƸ��һ�����ݴ���˾���ⲻ�����Թٿ����������ݷ����ͱ���������
//����СB������������M��N�������ǵݼ�˳�����С����Թٵ��������ܷ������M���ҵ�p������Ԫ�ع���һ�������У�ͬʱ������N���ҵ�q������Ԫ�ع�����һ�������У�ʹ����������������p��Ԫ���е��κ�һ��Ԫ�ؾ�С��q��Ԫ���е��κ�һ����
//СB�����æ��������д�������
//����
//�����������飬ÿ��������У���һ��Ϊ����������na��nb��1<=na��nb<=100000�����ֱ��ʾ����������Ԫ�صĸ������ڶ���Ϊp��q(1<=p<=na,1<=q<=nb����������Ϊ����M������na��������������Ϊ����N������nb��������
//���
//��ÿ��������ݣ��������һ�У����ܹ��ҵ��������YES�������������NO�����������ţ���
//
//��������
//3 3
//2 1
//1 2 3
//3 4 5
//5 2
//3 1
//1 1 1 1 1
//2 2
//�������
//NO
//YES
public class MSTest6 {
	
	private HashMap<String, Integer> map;
	
	public void cal(String name,int score) {
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int num=Integer.parseInt(in.nextLine());
		int[] ans=new int[num];
		for (int i = 0; i < num; i++) {
			int n=in.nextInt();
			String s=in.nextLine();
			String name=s.split(s)[0];
			int score=Integer.parseInt(s.split(s)[1]);
			
//			System.out.println(s);
		}
		for (int i = 0; i < num; i++) {
			System.out.println(ans[i]);
		}
		
	}
	
}
