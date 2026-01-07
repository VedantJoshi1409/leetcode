import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>(); //int[]{index, value}
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int index = i;
            while (!stack.isEmpty() && heights[i]<stack.peek()[1]) {
                int[] temp = stack.pop();
                max = Math.max(temp[1]*(i-temp[0]), max);
                index = temp[0];
            }
            stack.push(new int[]{index, heights[i]});
        }
        while (!stack.isEmpty()) {
            int[] temp = stack.pop();
            max = Math.max(temp[1]*(heights.length-temp[0]), max);
        }
        return max;
    }
}
