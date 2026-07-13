class Solution {

    record Temperature(
        int val,
        int pos
    ){}

    public int[] dailyTemperatures(int[] temperatures) {
      int len=temperatures.length;
      int[] res=new int[len];
      Deque<Temperature> stack=new ArrayDeque();
      stack.push(new Temperature(temperatures[0], 0));
      for(int i=1; i<len; i++){
        Temperature t=stack.peek();
        while(t!=null && t.val<temperatures[i]){
            res[t.pos]=i-t.pos;
            stack.pop();
            t=stack.peek();
        }
        stack.push(new Temperature(temperatures[i], i));
      }
      return res;
    }
}
