class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            if(a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
    });
        for(int i = 0 ; i < nums.length ; i++) {
            minHeap.offer(new int[]{i, nums[i]});
        }
        while(k > 0) {
            int[] smallest = minHeap.poll();
            minHeap.offer(new int[]{smallest[0],smallest[1]*multiplier});
            k = k - 1;
        }
        int[] res = new int[nums.length];
        while(!minHeap.isEmpty()){
            int[] temp = minHeap.poll();
            res[temp[0]] = temp[1];
        }
        return res;
    }
}