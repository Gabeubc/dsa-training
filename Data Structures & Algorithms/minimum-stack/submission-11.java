class MinStack {
    record Element(
        int val,
        int min
    ){}
    private Integer min=Integer.MAX_VALUE;
    private Deque<Element> stack;

    public MinStack() {
        stack=new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(min==null || min>val) min=val;
        stack.push(new Element(val, min));
    }
    
    public void pop() {
        stack.pop();
        min=stack.peek()!=null?stack.peek().min:Integer.MAX_VALUE;
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
