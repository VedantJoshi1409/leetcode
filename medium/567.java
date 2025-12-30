class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] truth = new int[26];
        int[] freq = new int[26];
        int size = s1.length();
        if (size > s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            truth[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']++;
        }
        int matches = 0;
        for (int i = 0; i < truth.length; i++) {
            if (truth[i]==freq[i]) matches++;
        }
        if (matches == 26) return true;

        for (int i = 1; i < s2.length()-size+1; i++) {
            int cur = s2.charAt(i+size-1)-'a';
            int old = s2.charAt(i-1)-'a';
            freq[cur]++;
            freq[old]--;
            if (old != cur) {
                if (freq[cur] == truth[cur]) matches++;
                if (freq[cur]-1 == truth[cur]) matches--;
                if (freq[old] == truth[old]) matches++;
                if (freq[old]+1 == truth[old]) matches--;
            }
            if (matches==26) return true;
        }
        return false;
    }
}
