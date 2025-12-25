import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, -1)+1);
        }
        List<Integer>[] freq = new ArrayList[nums.length];
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (freq[entry.getValue()] == null) freq[entry.getValue()] = new ArrayList<Integer>();
            freq[entry.getValue()].add(entry.getKey());
        }
        int index = 0;
        int freqIndex = nums.length-1;
        int[] output = new int[k];
        for (int i = nums.length-1; i >= 0; i--) {
            if (index == k) break;
            if (freq[freqIndex] != null && freq[freqIndex].size() != 0) {
                for (int j : freq[freqIndex]) {
                    output[index] = j;
                    index++;
                }
            }
            freqIndex--;
        }
        return output;
    }
}
