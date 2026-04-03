class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean isEven = nums[0] % 2 == 0 ? true : false;
        for(int i = 1 ; i < nums.length ; i++) {
            if(isEven && nums[i] % 2 == 1) {
                isEven = false;
            } else if(!isEven && nums[i] % 2 == 0) {
                isEven = true ;
            } else {
                return false;
            }
        }
        return true;
    }
}