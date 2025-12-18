import java.util.Hashtable;

class Solution {
    public int specialTriplets(int[] nums) {
        Hashtable<Long, Long>  singles = new Hashtable();
        Hashtable<Long, Long> doubles = new Hashtable();
        long triples = 0;
        int mod = (int) Math.pow(10, 9) + 7;

        for (int j : nums) {
            long i = (long) j;
            if (i%2 == 0 && doubles.containsKey(i/2)) {
                triples+=doubles.get(i/2);
                triples %= mod;
            }
            
            if (singles.containsKey(i*2)) {
                if (doubles.containsKey(i)) {
                    doubles.put(i, doubles.get(i)+singles.get(i*2));
                } else {
                    doubles.put(i, singles.get(i*2));
                }
            }

            if (singles.containsKey(i)) {
                singles.put(i, singles.get(i)+1L);
            } else {
                singles.put(i, 1L);
            }
        }
        return (int) triples;
    }
}