class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
         int maxLight = 0;

        for (int light : lights) {
            maxLight = Math.max(maxLight, light);
        }

        int ans = 0;

        for (int time : arrivalTime) {
            int r = time % period;

            if (r >= maxLight) {
                ans = Math.max(ans, period - r);
            }
        }

        return ans;
    }
}