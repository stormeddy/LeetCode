import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2*/
public class MedianFinder {
	
	PriorityQueue<Integer> q1;
	PriorityQueue<Integer> q2;
	
	public MedianFinder(){
//		q1=new PriorityQueue<Integer>(Collections.reverseOrder());
		q1=new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		q2=new PriorityQueue<Integer>();
	}
	 // Adds a number into the data structure.
    public void addNum(int num) {
        if (q1.size()==q2.size()) {
			if (q1.isEmpty() || num<q1.peek()) {
				q1.offer(num);
			}else {
				q2.offer(num);
			}
		}else if (q1.size()==q2.size()+1) {
			if (num>q1.peek()) {
				q2.offer(num);
			}else {
				q2.offer(q1.poll());
				q1.offer(num);
			}
		}else if (q2.size()==q1.size()+1) {
			if (num<q2.peek()) {
				q1.offer(num);
			}else {
				q1.offer(q2.poll());
				q2.offer(num);
			}
		}
    }

    // Returns the median of current data stream
    public double findMedian() {
        double res=0.0;
        if (q1.size()==q2.size()) {
        	res=(q1.peek()+q2.peek()+0.0)/2;
		}else if (q1.size()==q2.size()+1) {
			res=q1.peek();
		}else if (q2.size()==q1.size()+1) {
			res=q2.peek();
		}
        return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Your MedianFinder object will be instantiated and called as such:
		// MedianFinder mf = new MedianFinder();
		// mf.addNum(1);
		// mf.findMedian();
//		PriorityQueue<Integer> q1=new PriorityQueue<Integer>(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o2-o1;
//			}
//		});
//		for (int i = 0; i < 10; i++) {
//			q1.offer(i);
//		}
//		for (int i = 0; i < 10; i++) {
//			System.out.println(q1.poll());
//		}
		
		
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(3);
		System.out.println(mf.findMedian());
	}

}
