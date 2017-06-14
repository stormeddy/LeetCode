import java.util.Arrays;

//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//Note:
//You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
//The number of elements initialized in nums1 and nums2 are m and n respectively.
public class MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            int j=m+i-1;
            while(j>=0&&nums2[i]<nums1[j]) {nums1[j+1]=nums1[j];j--;}            
            nums1[j+1]=nums2[i];
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1={2,4,6,5,0},nums2={1,3};
		merge(nums1, 1, nums2, 2);
		System.out.println(Arrays.toString(nums1));
	}

}
