class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length-1;
        int row = -1;
        while (start <= end && row == -1) {
            int mid = (start+end)/2;
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[mid].length-1]) {
                row = mid;
            } else if (target < matrix[mid][0]) end = mid-1;
            else start = mid + 1;
        }
        if (row >= matrix.length || row < 0) return false;
        start = 0;
        end = matrix[row].length-1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) end = mid-1;
            else start = mid+1;
        }
        return false;
    }
}
