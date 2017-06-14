/*Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]*/
public class MinimumMovestoEqualArrayElements {

	public int minMoves(int[] nums) {
		/*
		 * incrementing n - 1 elements by 1 == decrementing 1 element by 1
		 */
        
		int ans = 0, min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
        }
        for (int num : nums) {
            ans += num - min;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumMovestoEqualArrayElements mmeae=new MinimumMovestoEqualArrayElements();
		int[] nums={1,2,3};
		int res=mmeae.minMoves(nums);
		System.out.println(res);
	}

}
