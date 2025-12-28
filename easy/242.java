import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (char c : t.toCharArray()) {
            int num = map.getOrDefault(c, 0);
            if (num <= 0) return false;
            map.put(c, num-1);
        }
        for (Map.Entry<Character, Integer>  entry : map.entrySet()) {
            if (entry.getValue() > 0) return false;
        }
        return true;
    }
}
