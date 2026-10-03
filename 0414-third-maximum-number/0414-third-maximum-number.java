class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for(int num : nums) {
            if(max < num) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            }

            else if(secondMax < num && num != max) {
                thirdMax = secondMax;
                secondMax = num;
            }

            else if(thirdMax < num && num != secondMax && num != max) {
                thirdMax = num;
            }
        }

        if(thirdMax == Long.MIN_VALUE) {
            return (int)max;
        }
        return (int)thirdMax;
    }
}