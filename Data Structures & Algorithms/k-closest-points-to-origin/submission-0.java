class Solution {
    private double getDistanceFromOrigin(int[] a) {
        System.out.println(a[0] + " " + a[1]);
        double res = Math.sqrt(a[0]*a[0] + a[1]*a[1]);
        System.out.println(res);
        return res;
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];        
        PriorityQueue<int[]> dist = new PriorityQueue<>((a, b) -> Double.compare(getDistanceFromOrigin(a), getDistanceFromOrigin(b)));
        for(int[] point : points){
            dist.add(point);
            // if(dist.size() > k) {
            //     dist.poll();
            // }
        }
        System.out.println(dist.size());
        int index = 0;
        while(k > 0) {
            res[index] = dist.poll();
            index+=1;
            k-=1;
        }
        return res;

    }
}
