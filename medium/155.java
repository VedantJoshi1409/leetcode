import java.util.*;

class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;
    

    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        min.push(min.isEmpty() ? val : Math.min(val, min.peek()));
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

