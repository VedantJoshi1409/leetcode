import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] truth = new int[26];
        int[] freq = new int[26];
        int size = s1.length();
        HashSet<Integer> set = new HashSet<>();
        for (char c : s1.toCharArray()) {
            truth[c-'a']++;
            set.add(c-'a');
        }
        for (int i = 0; i < s2.length()-size+1; i++) {
            if (i == 0) {
                for (char c : s2.substring(0, size).toCharArray()) {
                    freq[c-'a']++;
                }
            } else {
                freq[s2.charAt(i-1)-'a']--;
                freq[s2.charAt(i+size-1)-'a']++;
            }
            boolean pass = true;
            for (int j : set) {
                if (freq[j]!=truth[j]) {
                    pass = false;
                    break;
                }
            }
            if (pass) return true;
        }
        return false;
    }
}
