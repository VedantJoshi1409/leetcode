class Solution {
    public int[] productExceptSelf(int[] nums) {
        long prod = 1;
        boolean zero = false;
        for (int i : nums) {
            if (i != 0) prod *= i;
            else {
                if (zero) return new int[nums.length];
                zero = true;
            }

        }
        int[] output = new int[nums.length];
        for (int i= 0; i < nums.length; i++) {
            if (zero) {
                if (nums[i] == 0) output[i] = (int)(prod); 
                else output[i] = 0;
            } else output[i] = (int)(prod/nums[i]);
        }
        return output;
    }
}
