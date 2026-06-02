class Solution {
    record Car(
        int pos, 
        float time
    ){}
    public int carFleet(int target, int[] position, int[] speed) {
        int len=position.length;
        PriorityQueue<Car> pq=new PriorityQueue<>((a, b)->Integer.compare(b.pos, a.pos));
        Deque<Float> stack=new ArrayDeque<>();
        for(int i=0; i<len; i++){
            pq.offer(new Car(position[i], (float)(target-position[i])/speed[i]));
        }
        while(!pq.isEmpty()){
            Car car=pq.poll();
            if(stack.isEmpty() || stack.peek()<car.time) stack.push(car.time);
        }
        return stack.size();
    }
}
