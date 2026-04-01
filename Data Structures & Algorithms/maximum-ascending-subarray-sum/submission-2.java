class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = nums[0], currSum = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
             if (nums[i] <= nums[i - 1]) {
                currSum = 0;
            }
            currSum += nums[i];
            res = Math.max(res, currSum);
        }
        return res;
    }
}