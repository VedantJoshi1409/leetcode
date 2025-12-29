class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int['Z'-'A'+1];
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int max = 0;
        char main = chars[start];
        while (end < chars.length) {
            map[chars[end]-'A']++;
            if (map[chars[end]-'A'] > map[main-'A']) main = chars[end];
            if (end-start-map[main-'A']+1 > k) {
                map[chars[start]-'A']--;
                start++;
            }
            max = Math.max(max, end-start+1);
            end++;
        }
        return max;
    }
}
