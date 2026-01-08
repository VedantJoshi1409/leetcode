class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int index = -1;
        while (l <= r && index == -1) {
            int mid = (l+r)/2;
            if (mid != nums.length-1 && nums[mid] > nums[mid+1]) index = mid+1;
            else if (mid != 0 && nums[mid-1] > nums[mid]) index = mid;
            else if (nums[mid] < nums[l]) r = mid-1;
            else if (nums[mid] > nums[r]) l = mid + 1;
            else index = 0;
        }
        if (nums[index]==target) return index;
        if (nums[index] < target && target <= nums[nums.length-1]) {
            l = index+1;
            r = nums.length-1;
        } else {
            r = index-1;
            l = 0;
        }
        while (l <= r) {
            int mid = (l+r)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid +1;
            else r = mid-1;
        }
        return -1;
    }
}
