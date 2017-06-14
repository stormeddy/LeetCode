/*Little Hi is playing a sandbox voxel game. In the game the whole world is constructed by massive 1x1x1 cubes. The edges of cubes are parallel to the coordinate axes and the coordinates (x, y, z) of the center of each cube are integers.

trove-seven-wonders-windmill-castle-shaun.jpg

At the beginning there is nothing but plane ground in the world. The ground consists of all the cubes of z=0. Little Hi needs to build everything by placing cubes one by one following the rules:

1. The newly placed cube must be adjacent to the ground or a previously placed cube. Two cubes are adjacent if and only if they share a same face.

2. The newly placed cube must be accessible from outside which means by moving in 6 directions(up, down, left, right, forward, backward) there is a path from a very far place - say (1000, 1000, 1000) in this problem - to this cube without passing through ground or other cubes.

Given a sequence of cubes Little Hi wants to know if he can build the world by placing the cubes in such order.

输入
The first line contains the number of test cases T(1 <= T <= 10).

For each test case the first line is N the number of cubes in the sequence.

The following N lines each contain three integers x, y and z indicating the coordinates of a cube.



For 20% of the data, 1 <= N <= 1000, 1 <= x, y, z <= 10.

For 100% of the data, 1 <= N <= 100000, 1 <= x, y, z <= 100.

输出
For each testcase output "Yes" or "No" indicating if Little Hi can place the cubes in such order.

样例提示
In the first test case three cubes are placed on the ground. It's OK.

In the second test case (1, 3, 2) is neither on the ground nor adjacent to previous cubes. So it can't be placed.

In the last test case (2, 2, 1) can not be reached from outside. So it can't be placed.  

样例输入
3
3
1 1 1
1 2 1
1 3 1
3
1 1 1
1 2 1
1 3 2
17
1 1 1
1 2 1
1 3 1
2 3 1
3 3 1
3 2 1
3 1 1
2 1 1
2 1 2
1 1 2
1 2 2
1 3 2
2 3 2
3 3 2
3 2 2
2 2 2
2 2 1
样例输出
Yes
No
No*/
public class MSTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
