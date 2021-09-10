package Contest.Contest255.contest1;

class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0], min = nums[0];
        for (int i : nums) {
            if(i < min) min = i;
            if(i > max) max = i;
        } return GCD(max, min);
    }
    int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        else {
            int diff = a - b;
            return diff > b? GCD(diff, b):GCD(b, diff);
        }
    }
}