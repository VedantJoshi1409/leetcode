import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        float[][] info = new float[position.length][2];
        for (int i = 0; i < position.length; i++) {
            info[i][0] = position[i];
            info[i][1] = (float)(target - position[i])/speed[i];
        }
        Arrays.sort(info, (a,b) -> -Float.compare(a[0], b[0]));
        int fleet = 1;
        float time = info[0][1];
        for (int i = 1; i < info.length; i++) {
            if (info[i][1] > time) {
                fleet++;
                time = info[i][1];
            } 
        }
        return fleet;
    }
}
