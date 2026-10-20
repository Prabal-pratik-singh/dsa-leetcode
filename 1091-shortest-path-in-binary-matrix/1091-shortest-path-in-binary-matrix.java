class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q= new LinkedList<>();

        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        int[] deltar = {-1,-1,-1,0,0,1,1,1};
        int[] deltac = {-1,0,1,-1,1,-1,0,1};

        while(!q.isEmpty()){
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            int distance = current[2];

            if(r == n-1 && c == n-1){
                return distance;
            }
            for(int i = 0;i<8;i++){
                int newR = r+deltar[i];
                int newC = c+deltac[i];

                if(newR >= 0 && newR< n && newC >= 0 && newC< n){
                    if(grid[newR][newC]==0 && !visited[newR][newC]){
                        q.add(new int[]{newR,newC,distance+1});
                        visited[newR][newC] = true;

                    }
                }

            }
        }
        return -1;

        
    }
}