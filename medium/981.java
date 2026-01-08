import java.util.*;

class TimeMap {
    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();  
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Pair> temp = map.get(key);
        if (temp == null) temp = new ArrayList<>();
        temp.add(new Pair(value, timestamp));
        map.put(key, temp);
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Pair> temp = map.get(key);
        if (temp == null) return "";
        int l = 0, r = temp.size()-1;
        Pair best = null;
        while (l <= r) {
            int mid = (l+r)/2;
            if (temp.get(mid).time == timestamp) return temp.get(mid).value;
            else if (temp.get(mid).time < timestamp) {
                l = mid + 1;
                if (best == null) best = temp.get(mid);
                else if (temp.get(mid).time > best.time) {
                    best = temp.get(mid);
                }
            } else r = mid - 1;
        }
        return best == null ? "" : best.value;
    }
}

class Pair {
    String value;
    int time;
    public Pair(String value, int time){
        this.value = value;
        this.time = time;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
