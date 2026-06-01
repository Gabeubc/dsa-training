class MinStack {

    private Integer min=Integer.MAX_VALUE;
    private Deque<Integer> stack;
    private Deque<Integer> stackMins;

    public MinStack() {
        stack=new ArrayDeque<>();
        stackMins=new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(min==null || min>val) min=val;
        stack.push(val);
        stackMins.push(min);
    }
    
    public void pop() {
        stack.pop();
        stackMins.pop();
        min=stackMins.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return stackMins.peek();
    }
}
