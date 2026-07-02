class MinStack {
    Stack<Long> st;
long min;


    public MinStack() {
         st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        //stack empty
        if(st.isEmpty()){
            st.push((long)value);
            min = value;
        }else{
            if(value>=min){
                st.push((long)value);
            }else{
                st.push(2L*value - min);
                min = value;
            }
        }
        
    }
    
    public void pop() {
        if(st.isEmpty()){
            return ;
        }else{
            if(st.peek()>=min){
                st.pop();
            }else if(st.peek() < min){
                min = 2*min - st.peek();
                st.pop();
            }
            if (st.isEmpty()) {
    min = Integer.MAX_VALUE;
}
        }
        
    }
    
    public int top() {
        if(st.empty()){
            return -1;
        }else{
            if(min<=st.peek()){
                return st.peek().intValue();

            }else{
                return (int) min;
            }
        }
        
    }
    
    public int getMin() {
        return (int)min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */