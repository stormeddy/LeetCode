
public class MinimumSizeSubarraySum {

	public static int minSubArrayLen(int s, int[] nums) {
        int start=0,end=0,sum=0;
        int len=0;int min=Integer.MAX_VALUE;
        int size=nums.length;
        if (size==0) {
			return 0;
		}
        while(start<=end){
        	if (sum<s) {
        		if (end==size) {
					break;
				}
        		sum=sum+nums[end];
				end++;				
				len++;
			}
        	else {
        		min=Integer.min(min, len);
        		if (start!=end) {        			
            		sum=sum-nums[start];    				
            		len--;
				}
        		start++;
        		
        		
				
			}
        }
        return min==Integer.MAX_VALUE?0:min;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s=7;
		int[] nums=new int[]{2,3,1,2,4,3};
		System.out.println(minSubArrayLen(s, nums));
	}

}
