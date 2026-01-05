import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length-1; i>= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peek()[0] <= temperatures[i]) stack.pop();
                else {
                    result[i] = stack.peek()[1]-i;
                    stack.push(new int[]{temperatures[i], i});
                    break;
                }
            }
            if (stack.isEmpty()) {
                stack.push(new int[]{temperatures[i], i});
                result[i] = 0;
            }
        }
        return result;
    }
}
