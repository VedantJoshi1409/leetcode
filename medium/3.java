import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<2) return s.length();
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < chars.length) {
            if (map.containsKey(chars[end])) start = Math.max(start, map.get(chars[end])+1);
            max = Math.max(max, end-start+1);
            map.put(chars[end], end);
            end++;
        }
        return max;
    }
}
