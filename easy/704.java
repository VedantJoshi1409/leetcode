class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int middle = (r+l)/2;
            if (target == nums[middle]) return middle;
            else if (target < nums[middle]) r = middle-1;
            else l = middle+1;
        }
        return -1;
    }
}
