class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n =heights[0].length;

        int[][] effort = new int[m][n];

        for(int[] row: effort){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        pq.add(new int[]{0,0,0});

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currentEffort = current[0];
            int row = current[1];
            int col = current[2];
            if(currentEffort>effort[row][col]){
                continue;
            }
            if(row == m-1 && col == n-1){
                return currentEffort;
            }
            for(int i = 0 ;i<4;i++){
                int newr = row+delrow[i];
                int newc = col+delcol[i];
                if(newr >= 0 && newr<m && newc>=0 && newc<n){
                    int hightDiff = Math.abs(heights[row][col]-heights[newr][newc]);
                
                int newEffort = Math.max(currentEffort , hightDiff);
                if(newEffort<effort[newr][newc]){
                    effort[newr][newc] = newEffort;
                    pq.add(new int[]{newEffort,newr,newc});

                }
            }
        }
        }
        return 0;
        
    }
}