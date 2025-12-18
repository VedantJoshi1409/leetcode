class Solution {
    public int[] sortedSquares(int[] nums) {
        int neg = -1;
        int pos = -1;
        int[] output = new int[nums.length];
        if (nums[0] >= 0) {
            for (int i = 0; i < nums.length; i++) {
                output[i]=nums[i]*nums[i];
            }
        } else if (nums[nums.length-1] < 0) {
            for (int i = nums.length-1; i >= 0; i--) {
                output[nums.length-i-1]=nums[i]*nums[i];
            }
        } else {
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i] < 0 && nums[i+1] >= 0) {
                    neg = i;
                    pos = i+1;
                }
            }
            int i = 0;
            while (neg >= 0 && pos < nums.length) {
                if (Math.abs(nums[neg]) < nums[pos]) {
                    output[i]=nums[neg]*nums[neg];
                    neg--;
                } else {
                    output[i]=nums[pos]*nums[pos];
                    pos++;
                }
                i++;
            }
            if (neg < 0) {
                while (pos < nums.length) {
                    output[i] = nums[pos]*nums[pos];
                    pos++;
                    i++;
                }
            } else {
                while(neg >= 0) {
                    output[i]=nums[neg]*nums[neg];
                    neg--;
                    i++;
                }
            }
        }
        return output;
    }
}
