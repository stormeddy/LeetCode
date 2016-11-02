import java.util.Arrays;

/*The set [1,2,3,бн,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.*/
public class PermutationSequence {

	public String getPermutation(int n, int k) {
        int[] a=new int[n];
        for (int i = 0; i < a.length; i++) {
			a[i]=i+1;
		}
        StringBuilder sb=new StringBuilder();
        sb=help(a, k, sb);
        return sb.toString();
    }
	
	private StringBuilder help(int[] a,int k,StringBuilder sb) {
		int n=a.length;
		if (n==1) {
			sb=sb.append(a[k-1]);
			return sb;
		}
		int fn=fac(n-1);
		int cur=a[(k-1)/fn];
		int[] b=new int[n-1];
		int ind=0;
		for (int i = 0; i < n; i++) {
			if (a[i]!=cur) {
				b[ind]=a[i];
				++ind;
			}
		}
		sb=sb.append(cur);
		return help(b, (k-1)%fn+1, sb);
		
	}
	
	private int fac(int n){
		int res=1;
		while (n>1) {
			res*=n;
			--n;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence ps=new PermutationSequence();
		int n=4;
		int k=13;
		String res=ps.getPermutation(n, k);
		System.out.println(res);
		
		
//		int n = 4;
//		int a[] = { 1, 2, 3, 4 };
//		int k = 4;
//		int l = 0, r = n - 1;
//		int mid = 0;
//		int ret[]=new int[5];
//		
//		if (k>a[n-1]) {
//			for (int i = 0; i < n; i++) {
//				ret[i]=a[i];
//			}
//			ret[n]=k;
//		}else {
//			while (l<r){
//				mid = l + (r - l) / 2;
//				if (k >= a[mid]) l = mid + 1;
//				else r = mid;
//			}
//			
//			System.out.println(l);
//			
//			for (int i = 0; i < l; i++){
//				ret[i] = a[i];
//			}
//			ret[l] = k;
//			for (int i = l + 1; i < n + 1; i++){
//				ret[i] = a[i - 1];
//			}
//		}
//		
//		
//		System.out.println(Arrays.toString(ret));
		
	}

}
