class Solution {
    public class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        int n =grid.length;
        int m = grid[0].length;

        boolean[][] visited =  new boolean[n][m];
        int count = 0;

        //tranverse 
        for(int row = 0;row<n;row++){
            for (int col = 0 ; col<m;col++){
                

                if(grid[row][col] == '1' && !visited[row][col]){
                    count++;

                    bfs(grid,row,col,visited);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid,int row , int col,boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;

        Queue<pair> q = new LinkedList<>();

        q.add(new pair(row,col));
        visited[row][col] = true;

        int[][] directions ={{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            pair current = q.poll();

            int currentr = current.row;
            int currentc = current.col;

            for(int[] direction : directions){
                int newr = currentr + direction[0];
                int newc = currentc + direction[1];

                if(newr>=0 && newr<n && newc>=0 && newc<m){
                    if(grid[newr][newc] =='1' && !visited[newr][newc]){
                        visited[newr][newc] = true;
                        q.add(new pair(newr,newc));
                    }
                } 
            }
        }
    }
}