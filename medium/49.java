import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String temp = new String(c);
            ArrayList<Integer> temp2;
            if (map.containsKey(temp)) {
                temp2 = map.get(temp);
            } else {
                temp2 = new ArrayList<>();
            }
            temp2.add(i);
            map.put(temp, temp2);
        }
        List<List<String>> output = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<String> temp = new ArrayList<>();
            for (int i : entry.getValue()) {
                temp.add(strs[i]);
            }
            output.add(temp);
        }
        return output;
    }
}
