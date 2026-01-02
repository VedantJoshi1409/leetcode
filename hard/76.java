class Solution {
    public String minWindow(String s, String t) {
        int size = 'z'-'A'+1;
        if (s.length() < t.length()) return "";
        int[] truth = new int[size];
        int[] freq = new int[size];
        int matches = size;
        for (int i = 0; i < t.length(); i++) {
            truth[t.charAt(i)-'A']++;
            freq[s.charAt(i)-'A']++;

            if (t.charAt(i) != s.charAt(i)) {
                if (truth[t.charAt(i)-'A'] == freq[t.charAt(i)-'A']+1) matches--;
                if (truth[s.charAt(i)-'A'] == freq[s.charAt(i)-'A']) matches++;
            }
        }
        int[] min = new int[2];
        min[1] = s.length();
        if (matches == size) {
            min[1] = t.length()-1;
            if (t.length() == s.length()) return s;
        }
        int l = 0;
        for (int r = t.length(); r < s.length(); r++) {
            char c = s.charAt(r);
            freq[c-'A']++;
            if (freq[c-'A'] == truth[c-'A']) matches++;
            if (matches == size) {
                while (matches == size) {
                    if (r-l < min[1]-min[0]) {
                        min[0] = l;
                        min[1] = r;
                    }
                    c = s.charAt(l);
                    freq[c-'A']--;
                    if (freq[c-'A'] == truth[c-'A']-1) matches--;
                    l++;
                }
            }
        }
        
        return min[1] == s.length() ? "" : s.substring(min[0],min[1]+1); 
    }
}
