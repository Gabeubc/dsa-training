class Solution {

    record CarDetail(
        int pos,
        float time
    ){}

    public int carFleet(int target, int[] position, int[] speed) {
      int len=position.length;
      PriorityQueue<CarDetail> pq=new PriorityQueue<>((a, b)->Integer.compare(b.pos, a.pos));
      for(int i=0; i<len; i++){
        pq.offer(new CarDetail(position[i], (float)(target-position[i])/speed[i]));
      }
      Deque<Float> stack=new ArrayDeque<>();
      while(!pq.isEmpty()){
        CarDetail car=pq.poll();
        System.out.println(car);
        if(stack.isEmpty() || car!=null && stack.peek()<car.time) stack.push(car.time);
      }
      return stack.size();
    }
}
