class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
      int len=temperatures.length;
      int[] res=new int[len];
      Deque<Integer> stack=new ArrayDeque();
      stack.push(0);
      for(int i=1; i<len; i++){
        Integer pos=stack.peek();
        while(pos!=null && temperatures[pos]<temperatures[i]){
            res[pos]=i-pos;
            stack.pop();
            pos=stack.peek();
        }
        stack.push(i);
      }
      return res;
    }
}
