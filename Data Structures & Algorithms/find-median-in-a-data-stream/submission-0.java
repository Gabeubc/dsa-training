class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap=new PriorityQueue<>((a,b)->a.compareTo(b));
        this.maxHeap=new PriorityQueue<>((a,b)->b.compareTo(a));
    }
    
    public void addNum(int num) {
        if(minHeap.size()==0){
            minHeap.add(num);
            return;
        }
        if(minHeap.peek()<num) minHeap.add(num);
        else maxHeap.add(num);
        while(Math.abs(minHeap.size()-maxHeap.size())>1){
            if(minHeap.size()>maxHeap.size()) maxHeap.add(minHeap.poll());
            else minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()!=maxHeap.size()) return minHeap.size()>maxHeap.size()? minHeap.peek(): maxHeap.peek();
        return (double)(minHeap.peek()+maxHeap.peek())/2;
    }
}
