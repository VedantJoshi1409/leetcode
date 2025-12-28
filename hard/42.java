import java.util.*;

class Solution {
    public int trap(int[] height) {
        int first = 0;
        while (height[first] == 0 && first < height.length-1) first++;
        int last = height.length-1;
        while (height[last] == 0 && last > 0) last--;
        int trapped = 0;
        int cur = first;
        int next = first+1;
        HashSet<Integer> submerged = new HashSet<>();
        while (next <= last) {
            if (height[cur] > height[next]) next++;
            else {
                trapped+= (next-cur-1)*height[cur];
                for (int i = cur+1; i < next; i++) submerged.add(i);
                cur = next;
                next++;
            }
        }
        cur = last;
        next = cur-1;
        while (next >= first) {
            if (height[cur] >= height[next]) next--;
            else {
                trapped+= (cur-next-1)*height[cur];
                for (int i = cur-1; i > next; i--) submerged.add(i);
                cur = next;
                next--;
            }
        }
        for (int i : submerged) {
            trapped-=height[i];
        }
        return trapped;
    }
}
