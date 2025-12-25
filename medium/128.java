import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> id = new HashSet<>();
        for (int i : nums) id.add(i);
        int max = 0;
        for (int i : id) {
            if (id.contains(i-1)) continue;
            int cons = 1;
            while (id.contains(i+cons)) {
                cons++;
            }
            max = Math.max(cons, max);
        }
        return max;
    }
}
