class Solution {
    record MaxCandidate(
        int val,
        int pos
    ){}
    public int[] maxSlidingWindow(int[] nums, int k) {
      int len=nums.length;
      int l=0;
      PriorityQueue<MaxCandidate> pq=new PriorityQueue<>((a, b)-> Integer.compare(b.val, a.val));
      int[] res=new int[len-k+1];
      for(int i=0; i<k; i++){
        pq.add(new MaxCandidate(nums[i], i));
      }
      int j=0;
      res[j++]=pq.peek().val;
      l++;
      for(int r=k; r<len; r++, l++){
        pq.add(new MaxCandidate(nums[r], r));
        while( pq.peek().pos<l) pq.poll();
        res[j++]=pq.peek().val;
      }
      return res;  
    }
}
