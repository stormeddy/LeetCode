/*The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3		3
-5		-10		1
10		30		-5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.*/
public class DungeonGame {
	
	public int calculateMinimumHP(int[][] dungeon) {
		//从公主开始往回找，进入每个dungeon时至少要有1点血
        int m=dungeon.length;
        if (m==0) {
			return 1;
		}
        int n=dungeon[0].length;
        long[][] need=new long[m][n];
        if (dungeon[m-1][n-1]>0) {
			need[m-1][n-1]=1;
		}else {
			need[m-1][n-1]=1-dungeon[m-1][n-1];
		}
        for (int i = m-1; i >=0; i--) {
			for (int j = n-1; j >=0; j--) {
				if (i==m-1 && j==n-1) {
					continue;
				}
				int cur=dungeon[i][j];
				long temp1=0,temp2=0;
				if (i==m-1) {
					temp1=Long.MAX_VALUE;
				}else {
					temp1=need[i+1][j]-cur;
				}
				if (j==n-1) {
					temp2=Long.MAX_VALUE;
				}else {
					temp2=need[i][j+1]-cur;
				}
				temp1=temp1<=0?1:temp1;
				temp2=temp2<=0?1:temp2;
				need[i][j]=Math.min(temp1, temp2);
			}
		}
        return (int) need[0][0];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dungeon={{-2,-3,3},{-5,-10,1},{10,30,-5}};
		DungeonGame dg=new DungeonGame();
		int res=dg.calculateMinimumHP(dungeon);
		System.out.println(res);
	}

}
