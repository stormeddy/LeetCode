/*You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
ก่
ก่ ก่
ก่ ก่

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
ก่
ก่ ก่
ก่ ก่ ก่
ก่ ก่

Because the 4th row is incomplete, we return 3.*/
public class ArrangingCoins {

	public int arrangeCoins(int n) {
        int l=1;
        double t=n;
        long r=(long) Math.ceil(Math.sqrt(t*2));
        while (r*(r+1)/2>n) {
			--r;
		}
        return (int) r;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		ArrangingCoins ac=new ArrangingCoins();
		System.out.println(ac.arrangeCoins(n));
	}

}
