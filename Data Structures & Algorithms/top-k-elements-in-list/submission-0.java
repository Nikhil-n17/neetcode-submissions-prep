class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int number : nums){
            int count = freqMap.getOrDefault(number, 0) + 1;
            freqMap.put(number, count);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
                if(a[1] > b[1]) return -1;
                if(a[1] == b[1]) return 0;
                return 1;
            }
        );
        freqMap.forEach((key, value) -> {
            pq.add(new int[]{key, value});
        });
        List<Integer> res = new ArrayList<>();
        while(k > 0) {
            res.add(pq.poll()[0]);
            k-=1;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
