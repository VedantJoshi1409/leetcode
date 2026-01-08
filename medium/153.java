class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int min = nums[0];
        while (nums[l] > nums[r] && l <= r) {
            int mid = (l+r)/2;
            min = Math.min(nums[mid], min);
            if (nums[mid] < nums[l]) r = mid-1;
            else if (nums[mid] > nums[r]) l = mid+1;
        }
        min = Math.min(nums[l],Math.min(nums[r],min));
        return min;
    }
}
