class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 1;
        for (int i : piles) end = Math.max(end, i);
        int bestSpeed = end; 
        while (start <= end) { //binary search on speed that returns the best time
            int speed = (start+end)/2;
            long time = 0;
            for (int i : piles) time += (long) Math.ceil((double) i / speed);
            if (time <= h) {
                end = speed-1;
                bestSpeed = Math.min(bestSpeed, speed);
            } else start = speed+1;
        }
        return bestSpeed;
    }
}
