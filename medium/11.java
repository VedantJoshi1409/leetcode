class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while (l < r) {
            max = Math.max((r-l)*Math.min(height[r], height[l]), max);
            if (height[r] < height[l]) r--;
            else l++;
        }
        return max;
    }
}
