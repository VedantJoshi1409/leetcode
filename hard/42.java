class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int trap = 0;
        while (height[l] == 0 && l < height.length-1) l++;
        while (height[r] == 0 && r > 0) r--;
        int maxR = height[r];
        int maxL = height[l];
        while (l < r) {
            if (height[l] < height[r]) {
                l++;
                maxL = Math.max(maxL, height[l]);
                trap+=maxL-height[l];
            } else {
                r--;
                maxR = Math.max(maxR, height[r]);
                trap+=maxR-height[r];
            }
        }
        return trap;
    }
}
