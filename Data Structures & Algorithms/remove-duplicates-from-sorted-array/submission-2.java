class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int prev = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
            if(prev != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index++] = temp;
                prev = temp;
            }
        }
        return index;
    }
}