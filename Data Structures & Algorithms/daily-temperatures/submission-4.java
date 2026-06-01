class Solution {
    record Temperature(
        int val,
        Integer pos
    ){}
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Temperature> stack=new ArrayDeque<>();
        int len=temperatures.length;
        int[] res=new int[len];
        stack.push(new Temperature(temperatures[0], 0));
        for(int i=1; i<len; i++){
            Deque<Temperature> tmp=new ArrayDeque<>();
            while(stack.peek()!=null && stack.peek().val>=temperatures[i]){
                tmp.push(stack.pop());
            }
            while(stack.peek()!=null && stack.peek().val<temperatures[i]){
                Temperature t=stack.peek();
                res[t.pos]=i-t.pos;
                stack.pop();
            }
            stack.push(new Temperature(temperatures[i], i));
            while(!tmp.isEmpty()){
                stack.push(tmp.pop());
            }
        }
        return res;
    }
}
