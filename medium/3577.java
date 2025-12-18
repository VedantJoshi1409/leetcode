class Solution {
    public int countPermutations(int[] complexity) {
        long prod = 1;
        int mod = (int) Math.pow(10, 9) + 7;
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[0] >= complexity[i]) return 0;
            prod *= i;
            prod %= mod;
        }
        return (int) prod;   
    }
}