/*
346_Moving_Average_from_Data_Stream

Given a stream of integers and a window size, calculate the moving 
average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

*/

class MovingAverage {
    Queue<Integer> q; // push the input data in Queue
    long sum;	// save the sum of given size input data
    int size;	// size of data
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.q = new LinkedList<Integer>();
        this.sum = 0;
        this.size = size;
    }
    
    public double next(int val) {
        if (q.size() >= size) 
            sum -= (long) q.remove();
        q.add(val);
        sum += val;
        return (double) sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */