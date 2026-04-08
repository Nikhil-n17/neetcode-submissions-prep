class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] res = new int[m+n];
        int index = 0;
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                res[index++] = nums1[i++];
            } else {
                res[index++] = nums2[j++]; 
            }
        }
        while(i < m) {
            res[index++] = nums1[i++];
        }
        while(j < n) {
            res[index++] = nums2[j++];
        }
        index = 0;
        while(index < m + n){
            nums1[index] = res[index++]; 
        }
    }
}