class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pointer = numbers.length-1;
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] + numbers[pointer] > target) pointer--;
            if (numbers[i] + numbers[pointer] == target) return new int[] {i+1, pointer+1};
        }
        return new int[] {0, 0};
    }
}
