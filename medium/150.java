import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (String s : tokens) {
            if (s.equals("+")) stack.push(stack.pop()+stack.pop());
            else if (s.equals("-")) stack.push(-stack.pop()+stack.pop());
            else if (s.equals("*")) stack.push(stack.pop()*stack.pop());
            else if (s.equals("/")) {
                int fir = stack.pop(), sec = stack.pop();
                stack.push(sec/fir);
            }
            else stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}
