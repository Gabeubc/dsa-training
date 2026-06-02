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
            while(stack.peek()!=null && stack.peek().val<temperatures[i]){
                res[stack.peek().pos]=i-stack.peek().pos;
                stack.pop();
            }
            stack.push(new Temperature(temperatures[i], i));
        }
        return res;
    }
}
