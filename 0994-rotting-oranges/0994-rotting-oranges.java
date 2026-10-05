class Solution {
     class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row = row;
            this.col = col;
        }

     }

    public int orangesRotting(int[][] grid) {

        //find size oof grid
        int m = grid.length;
        int n= grid[0].length;

        //cretae a queue to store rotten
        Queue<pair> q = new LinkedList<>();

        //crete fresy
        int fresh = 0;

        
        //tranversee th grid to  cchk rotten and fresh
        for(int row = 0;row<m;row++){
            for(int col = 0;col<n;col++){
                if(grid[row][col] == 2){
                    q.add(new pair(row,col));
                }else if(grid[row][col] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        } 
        int min = 0;
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty() && fresh>0){

            int size = q.size();

            for(int i = 0;i<size;i++){
                //REM THE FIRST ROTTEN ORNG
                pair current = q.poll();

                int row = current.row;
                int col = current.col;

                for(int[] direction:directions){
                    //change in row col
                    int delR = direction[0];
                    int delC = direction[1];

                    int newR = row+delR;
                    int newC = col + delC;

                    //CHK
                    if(newR>=0 && newR<m && newC>=0 && newC<n){
                        if(grid[newR][newC] == 1){
                            
                            grid[newR][newC] = 2;
                            fresh--;
                            q.add(new pair(newR,newC));

                        }

                    }
                }
            }
               min++;
        
        }
        if(fresh == 0){
            return min;
        }
        return -1;
       
        
    }
}