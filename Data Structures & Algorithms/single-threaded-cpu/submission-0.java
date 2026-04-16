class Solution {
    public int[] getOrder(int[][] tasks) {
        for(int i = 0 ; i < tasks.length ; i++) {
            tasks[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(tasks, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int n = tasks.length;
        int[] res = new int[n];
        int taskIndex = 0;
        int ansIndex = 0;
        int time = 0;
        while(ansIndex < n) {
            while(taskIndex < n && tasks[taskIndex][0] <= time) {
                pq.add(tasks[taskIndex++]);
            }
            if(pq.isEmpty()){
                time = tasks[taskIndex][0];
                continue;
            }
            int[] bestFit = pq.poll();
            res[ansIndex++] = bestFit[2];
            time += bestFit[1];
         }
        return res;
    }
}