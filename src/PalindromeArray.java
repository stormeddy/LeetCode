import java.util.Scanner;

public class PalindromeArray {
	public static void main(String[] args) {		
		//调整合并使得成为对称数组
		Scanner scanner = new Scanner(System.in);
		PalindromeArray solution = new PalindromeArray();
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int nums[] = new int[n];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = scanner.nextInt();
			}
			if(n==1){
				System.out.println(0);
				continue;
			}
			solution.core(nums);
		}
		
	}
	
	public void core(int [] nums){
		int p1 = 0;
		int p2 = nums.length-1;
		int count = 0;
		while(p1<p2){
			if(nums[p1]==nums[p2]){
				p1++;p2--;
			}else{
				if(nums[p1]<nums[p2]){
					p1++;
					nums[p1]+=nums[p1-1];
					count++;
				}else{
					p2--;
					nums[p2]+=nums[p2+1];
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
}
