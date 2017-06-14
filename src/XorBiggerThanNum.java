
public class XorBiggerThanNum {

	public int help(int[] a,int m){
		int k=0;
		int t=m;
		while (t!=0) {
			t>>=1;
			++k;
		}
		int len=a.length;
		int l=1<<(k-1);//l为小于等于m的最大的2的幂
		int h=l<<1;
		int l_ind=partition(a, 0, len-1, l-1);//l_ind及其左边为小于等于l-1的数
		System.out.println(l_ind);
		int h_ind=partition(a, l_ind+1, len-1, h-1)+1;//h_ind及其右边为大于等于h的数
		System.out.println(h_ind);
		
//		int num_low=l_ind+1;
		int num_high=len-h_ind;
		
		int ans=num_high*h_ind;//小于等于l-1的数之间异或必然小于m
		ans+=inner_cal(a, l_ind+1, h_ind-1, m)+inner_cal(a, h_ind, len-1, m)
				+inter_cal(a, 0, l_ind, l_ind+1, h_ind-1, m);
		
		return ans;
		
	}
	
	public int inner_cal(int[] a,int left,int right,int m){
		if (left>=right) {
			return 0;
		}
		int cnt=0;
		for (int i = left; i <= right; i++) {
			for (int j = i+1; j <= right; j++) {
				if ((a[i]^a[j])>m) {
					++cnt;
				}
			}
		}
		return cnt;
	}
	
	public int inter_cal(int[] a,int left1,int right1,int left2,int right2,int m){
		int cnt=0;
		for (int i = left1; i <= right1; i++) {
			for (int j = left2; j <= right2; j++) {
				if ((a[i]^a[j])>m) {
					++cnt;
				}
			}
		}
		return cnt;
	}
	
	public int partition(int[] arr,int p,int r,int m) {
		
		int i=p-1;
		for (int j = p; j <= r; j++) {
			if (arr[j]<=m) {
				i++;
				swap(arr, i, j);				
			}
		}

		return i;
	}
	
	private void swap(int[] arr,int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		XorBiggerThanNum xbtn=new XorBiggerThanNum();
//		int[] a={6,5,10};
//		int m=10;
//		int ret=xbtn.help(a, m);
//		System.out.println(ret);
		String s="\\t\t";
		System.out.println(s);
		System.out.println(s.lastIndexOf("\t"));
		System.out.println(s.length());

	}

}
