class Solution {
    public int evalRPN(String[] tokens) {
        int len=tokens.length;
        Deque<Integer> operands=new ArrayDeque<>();
        for(int i=0; i<len; i++){
            String s=tokens[i];
            switch(s){
                case "+":{
                    int o2=operands.pop();
                    int o1=operands.pop();
                    operands.push(o1+o2);
                    break;
                }
                case "-":{
                    int o2=operands.pop();
                    int o1=operands.pop();
                    operands.push(o1-o2);
                    break;
                }
                case "*":{
                    int o2=operands.pop();
                    int o1=operands.pop();
                    operands.push(o1*o2);
                    break;
                }
                case "/":{
                    int o2=operands.pop();
                    int o1=operands.pop();
                    operands.push(o1/o2);
                    break;
                }
                default:{
                    operands.push(Integer.parseInt(s));
                }
            }
        }
        return operands.pop();
    }
}
