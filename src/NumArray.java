
public class NumArray {

    SegNode root;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            root = null;
        } else {
            root = build(nums, 0, nums.length - 1);
        }

    }

    // build function is used to build a segment tree
    public SegNode build(int[] nums, int start, int end) {
        if (start == end) { //if start index == end index, then there is only one element in this range and this node will be the leaf.
            SegNode node = new SegNode(start, end);
            node.sum = nums[start];
            return node;
        }
        SegNode cur = new SegNode(start, end);
        int mid = start + (end - start) / 2; 
        cur.left = build(nums, start, mid);
        cur.right = build(nums, mid + 1, end);
        cur.sum = cur.left.sum + cur.right.sum; //the sum value of current node is based on the sum of left and right child.
        return cur;
    }

    void update(int i, int val) {
        if (root == null) {
            return;
        }
        updateHelper(root, i, val);
    }

    // the first step of updating is to find the node whose range is from i to i.
    // the  second step is update the sum value of this node and return this new node to upper level.
    public SegNode updateHelper(SegNode node, int i, int val) {
        if (node.start == node.end && node.start == i) { // to find the leaf node we want to update.
            node.sum = val;
            return node;
        }
        if (i < node.start || i > node.end) {
            return node; // if i is not in the range of current node, then there is nothing need to be changed and return current node directly.
        }
        int left = updateHelper(node.left, i, val).sum; 
        int right = updateHelper(node.right, i, val).sum;
        node.sum = left + right; //update the sum value of current node
        return node;
    }

    public int sumRange(int i, int j) {
        if (root == null) {
            return 0;
        }
        return sumHelper(root, i, j);
    }

    public int sumHelper(SegNode node, int i, int j) {
        if (i > node.end || node.start > j) { // If the range of current node doesn't have overlapping with the range you're searching, return 0;
            return 0;
        }
        if (i <= node.start && j >= node.end) { //If the range of current node is part of the searching range, return sum of current node
            return node.sum; 
        }
        int left = sumHelper(node.left, i, j); //search sum from left child
        int right = sumHelper(node.right, i, j); //search sum from right child
        return left + right;
    }



}

// Segment Tree Node class contains start index, end index, sum of the range, left node and right node
class SegNode {
    public int start;
    public int end;
    public int sum;
    public SegNode left;
    public SegNode right;
    public SegNode(int s, int e) {
        this.start = s;
        this.end = e;
        left = null;
        right = null;
        sum = 0;
    }

}