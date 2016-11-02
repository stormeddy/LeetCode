/*Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1*/
public class IntegerReplacement {

	public static int integerReplacement(int n) {
		if(n==Integer.MAX_VALUE) return 32;
		int k = 0;
		while (n != 1) {
			if ((n & 1) == 0) {
				n = n / 2;
				++k;
			} else {

				int hi = (n + 1) / 2;
				int lo = (n - 1) / 2;
				if (lo == 1) {
					k = k + 2;
					return k;
				}
				int hn = count2(hi);
				int ln = count2(lo);
				if (hn == ln) {
					double p = Math.floor(Math.log(lo) / Math.log(2));
					double pl = Math.pow(2, p);
					double ph = Math.pow(2, p + 1);
					if (lo - pl <= ph - hi) {
						n = lo;
						k = k + 2;
					} else {
						n = hi;
						k = k + 2;
					}
				} else if (ln < hn) {
					n = hi;
					k = k + 2;

				} else {
					n = lo;
					k = k + 2;

				}

			}
		}

		return k;
	}

	public static int count2(int n) {
		
		int k = 0;
		while ((n & 1) == 0) {
			++k;
			n >>= 1;
		}
		return k;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=100;
		int ret=integerReplacement(n);
//		System.out.println(count2(12));
		System.out.println(ret);
		
	}

}
