class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int n = nums.length;
        int currSum = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++) {
            currSum += nums[i];
            if(nums[i] >= nums[i+1]) {
                res = Math.max(res, currSum);
                currSum = 0;
            }
        }
        if(nums[n - 2] < nums[n-1]) {
            currSum += nums[n-1];
        }
        return Math.max(res, currSum);
    }
}