import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> cont = new HashSet<>();
        for (int i : nums) {
            if (cont.contains(i)) return true;
            cont.add(i);
        }
        return false;
    }
}
