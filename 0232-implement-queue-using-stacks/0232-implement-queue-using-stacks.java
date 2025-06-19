class MyQueue {

        Stack<Integer> instack;
        Stack<Integer> outstack;

    public MyQueue() {
        instack = new Stack<>();
        outstack = new Stack<>();
    }
    
    public void push(int x) {
        instack.push(x);
    }
    
    public int pop() {
        if(!outstack.isEmpty()) {
            return outstack.pop();
        }
        else {
            while(!instack.isEmpty()) {
                outstack.push(instack.pop());
            }
            return outstack.isEmpty() ? -1 : outstack.pop();
        }

    }
    
    public int peek() {
        if(!outstack.isEmpty()) {
            return outstack.peek();
        }
        else {
            while(!instack.isEmpty()) {
                outstack.push(instack.pop());
            }
            return outstack.isEmpty() ? -1 : outstack.peek();
        }
    }
    
    public boolean empty() {
        return instack.size() == 0 && outstack.size() == 0;
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