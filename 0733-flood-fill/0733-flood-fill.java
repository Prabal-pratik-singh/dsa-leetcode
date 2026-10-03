class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //store original clr
        int originalClr = image[sr][sc];

        //if original clr == clr then return image
        if(originalClr == color){
            return image;
        }
        // oterwise recuservily call dfs
        dfs(image,sr,sc,originalClr,color);

        return image;
        
    }
    //dfs function
    public void dfs(int[][] image, int row, int col, int originalClr, int newClr){
        //fing row clm size
        int n = image.length;
        int m = image[0].length;

        //mark current cell with new clr
        image[row][col] = newClr;

        //all posssible direction
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        //check all 4 dir
        for(int[] direction : directions){
            //delDIR

            int delR = direction[0];

            int delC = direction[1];

            //new r and c THEYBARE NEIGHBOUR

            int newR = row + delR;
            int newC = col + delC;

            //CHECK NEIGHBOUR LIE INSIDE BOUND
            if(newR>= 0 && newR<n && newC>= 0 && newC<m){
                //chk they have orignial clr
                if(image[newR][newC] == originalClr){
                    dfs(image,newR,newC,originalClr,newClr);
                }
            }
        }
    }
}