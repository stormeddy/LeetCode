
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class DeleteCharacter {

	public ArrayList<Integer> kmp_matcher(String T,String P){
    	//KMP算法
		ArrayList<Integer> res=new ArrayList<Integer>();
    	boolean match=false;
    	int n=T.length();
    	int m=P.length();
    	int[] pi=compute_prefix_function(P);

    	int q=0;
    	for (int i = 1; i <= n; i++) {
			while (q>0 && P.charAt(q)!=T.charAt(i-1)) {
				q=pi[q];
			}
			if (P.charAt(q)==T.charAt(i-1)) {
				q++;
			}
			if (q==m) {
				res.add(i-m);
//				System.out.println("Pattern occurs with shift:"+(i-m));
				q=pi[q];
				match=true;
			}
			
		}
    	return res;
    }
    
	private int[] compute_prefix_function(String P) {
		int m=P.length();
		int[] pi=new int[m+1];
		pi[1]=0;
		int k=0;
		for (int q = 2; q <= m; q++) {
			while (k>0 && P.charAt(k)!=P.charAt(q-1)) {
				k=pi[k];
			}
			if (P.charAt(k)==P.charAt(q-1)) {
				k++;
			}
			pi[q]=k;
		}
		return pi;
	}
	
//	public int delete_character(String s, ArrayList<String> pair){
//		int res=0;
//		int[] cnt=new int[26];
//		int[] appear=new int[26];
//		
//		ArrayList<String> cur_pair=new ArrayList<String>();
//		for (int i = 0; i < pair.size(); i++) {
//			cur_pair.add(pair.get(i));
//		}
//		
//		for (int i = 0; i < pair.size(); i++) {
//			++appear[pair.get(i).charAt(0)-'a'];
//			++appear[pair.get(i).charAt(1)-'a'];
//		}
//		while (true) {
//			char[] sarr=s.toCharArray();
//			for (int i = 0; i < sarr.length; i++) {
//				++cnt[sarr[i]-'a'];
//			}
//			int min=0;
//			for (int i = 0; i < appear.length; i++) {
//				if (appear[i]>appear[min]) {
//					min=i;
//				}
//			}
//			for (int i = 0; i < cnt.length; i++) {
//				if (appear[i]==appear[min] && cnt[i]!=0 && cnt[i]<cnt[min] ) {
//					min=i;
//				}
//			}
//			char del=(char) (min+'a');
//			ArrayList<String> pats=new ArrayList<String>();
//			for (int i = 0; i < cur_pair.size(); i++) {
//				if (pair.get(i).indexOf(del)!=-1) {
//					pats.add(cur_pair.get(i));
//				}
//			}
//			if (pats.size()==0) {
//				break;
//			}
//			for (String pattern : pats) {
//				ArrayList<Integer> del_pos=kmp_matcher(s, pattern);
//				cur_pair.remove(pattern);
//				if (del_pos.size()==0) {
//					continue;
//				}
//				StringBuilder sb=new StringBuilder(s);
//				res+=del_pos.size();
//				for (Integer pos : del_pos) {
//					sb.deleteCharAt(pos);
//				}
//				s=sb.toString();
//				
//			}
//			
//		}
//		return res;
//		
//	}
	
	public int delete_character(char[] s,String cur, HashSet<String> pair, int start){
		if (cur.length()==1) {
			return 0;
		}
		String tmp=cur.charAt(0)+""+cur.charAt(1);
		StringBuilder sb=new StringBuilder(cur);
		int res=Integer.MAX_VALUE,res1=Integer.MAX_VALUE,res2=Integer.MAX_VALUE;
		if (pair.contains(tmp)) {
			char[] dest=new char[s.length];
			System.arraycopy(s, 0, dest, 0, s.length);
			StringBuilder sb2=new StringBuilder(sb);
			int start2=start;
			sb=sb.deleteCharAt(0);
			while (start>0 && s[start]==s[start-1]) {
				--start;
				sb=sb.insert(0, s[start]);
			}
			cur=sb.toString();
			s[start]='A';//防止下次再退回到此处
			res1=1+delete_character(s, cur, pair, start+1);
			
			sb2=sb2.deleteCharAt(1);
			cur=sb2.toString();
			dest[start2+1]=dest[start2];
//			dest[start2]='A';
			res2=1+delete_character(dest, cur, pair, start2+1);
			res=Math.min(res1, res2);
		}else {
			cur=sb.deleteCharAt(0).toString();
			res=delete_character(s, cur, pair, start+1);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		HashSet<String> pair = new HashSet<String>();

		int N = Integer.parseInt(in.nextLine());
		String s = in.nextLine();
		String mstr = in.nextLine();
		int M = Integer.parseInt(mstr);
		for (int i = 0; i < M; i++) {
			String p = in.nextLine();
			pair.add(p);
			pair.add(p.charAt(1) + "" + p.charAt(0));
		}

		DeleteCharacter dc = new DeleteCharacter();
		int res = dc.delete_character(s.toCharArray(),s, pair,0);
		System.out.println(res);
	}

	
//	C++ 代码
//	#define _CRT_SECURE_NO_WARNINGS
//	#include <iostream>
//	#include <vector>
//	#include <string>
//	#include <algorithm>
//	#include <functional>
//	#include <array>
//	#include <list>
//
//	using namespace std;
//
//	char table[100001];
//	int dp[26] = {0};   //以第'a'+i个字符结尾，最长的子序列
//	bool m[26][26];     //用来判断两个char是否可以相连
//	int main(int argc, char **argv)
//	{
//	    int N = 0, M = 0;
//	    scanf("%d\n", &N);
//	    scanf("%s", table);
//	    //cin >> table;
//	    //cin >> M;
//	    scanf("%d\n", &M);
//	    /*for (int i = 0; i != 26; ++i)
//	    {
//	        for (int j=0; j!=26; ++j)
//	        {
//	            m[i][j] = false;
//	        }
//	    }*/
//	    for (int i=0; i!=M; ++i)
//	    {
//	        char ch1, ch2;
//	        //scanf("%c%c\n", &ch1, &ch2);
//	        cin >> ch1 >> ch2;
//	        m[ch1 - 'a'][ch2 - 'a'] = true;
//	        m[ch2 - 'a'][ch1 - 'a'] = true;
//	    }
//
//	    for (int i=0; i<N; ++i)
//	    {
//	        char ch1 = table[i];
//	        int temp = 1;
//	        for (int j=0; j!=26; ++j)
//	        {
//	            if (m[ch1 - 'a'][j])
//	            {
//	                continue;
//	            }
//	            else
//	            {
//	                temp = max(temp, dp[j] + 1);
//	            }
//	        }
//	        dp[ch1 - 'a'] = temp;
//	    }
//
//	    cout << N - *max_element(dp, dp+26) << endl;
//	    return 0;
//	}
	
/*	
5
abcde
3
ac
ab
de

8
aaaacaccccdd
2
ac
cd
	*/
}
