class MyQueue {
    Deque<Integer> pushstack;
    Deque<Integer> popstack;
    public MyQueue() {
        pushstack = new ArrayDeque<>();
        popstack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        pushstack.push(x);
    }
    
    public int pop() {
        while(!pushstack.isEmpty()){
            popstack.push(pushstack.pop());
        }
        int x = popstack.pop();
        while(!popstack.isEmpty()){
            pushstack.push(popstack.pop());
        }
        return x;
    }
    
    public int peek() {
        while(!pushstack.isEmpty()){
            popstack.push(pushstack.pop());
        }
        int x = popstack.peek();
        while(!popstack.isEmpty()){
            pushstack.push(popstack.pop());
        }
        return x;
    }
    
    public boolean empty() {
        return pushstack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */