class Solution {
    record Item(
        int val,
        int idx
    ){}
    public int[] maxSlidingWindow(int[] nums, int k) {
      PriorityQueue<Item> pq=new PriorityQueue<>((a,b)->b.val-a.val);
      int len=nums.length;
      for(int i=0; i<k; i++){
        pq.offer(new Item(nums[i], i));
      }  
      int l=1;
      int[] res=new int[len-k+1];
      int pos=0;
      res[pos++]=pq.peek().val;
      for(int r=k; r<len; r++, l++){
        pq.offer(new Item(nums[r], r));
        while(pq.peek().idx<l) pq.poll();
        res[pos++]=pq.peek().val;
      }
      return res;
    }
}
