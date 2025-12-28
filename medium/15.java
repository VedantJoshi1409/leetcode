import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            while (l < r) {
                if (l != i+1 && nums[l]==nums[l-1]) {
                    l++;
                    continue;
                }
                if (r != nums.length-1 && nums[r]==nums[r+1]) {
                    r--;
                    continue;
                }
                if (nums[i]+nums[l]+nums[r] == 0) {
                    output.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
                else if (nums[l]+nums[r] < -nums[i]) {l++;}
                else {r--;}
            }
        }
        return output;
    }
}
