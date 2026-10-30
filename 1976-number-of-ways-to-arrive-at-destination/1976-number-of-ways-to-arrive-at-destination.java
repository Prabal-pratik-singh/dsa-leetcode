class Solution {
    public int countPaths(int n, int[][] roads) {

        int MOD = 1_000_000_007;

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0 ; i<n;i++){
            adj.add(new ArrayList<>());
        }     
        //roads are bidirectional
        for(int[] road: roads){
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new int[]{v,time});
            adj.get(v).add(new int[]{u,time});
        }  
        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);

        int[] ways = new int[n];
        dist[0] = 0 ;
        ways[0] = 1;

        PriorityQueue<long[]>pq = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));

        pq.add(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] current = pq.poll();

            long time = current[0];
            int node = (int)current[1];

            if(time>dist[node]){
                continue;
            }

            for(int[] edge:adj.get(node)){
                int neigh = edge[0];
                int travelTime = edge[1];

                long newTime = time + travelTime;

                if(newTime<dist[neigh]){
                    dist[neigh] = newTime;
                    ways[neigh] = ways[node];

                    pq.add(new long[]{newTime,neigh});
                }
                else if(newTime == dist[neigh]){
                    ways[neigh] = (ways[neigh]+ways[node]) % MOD;
                }
            }
        }
        return ways[n-1];

        


    }
}