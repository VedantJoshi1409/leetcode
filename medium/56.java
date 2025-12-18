import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        ArrayList<int[]> output = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                output.add(new int[] {start, end});
                start = intervals[i][0];

            } 
            end = Math.max(end, intervals[i][1]);
        }
        output.add(new int[] {start, end});
        int[][] merged = new int[output.size()][2];
        for (int i = 0; i < output.size(); i++) {
            merged[i]=output.get(i);
        }
        return merged;
    }
}