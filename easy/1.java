import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(target-nums[i])) {
                return new int[]{table.get(target-nums[i]), i};
            }
            table.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
