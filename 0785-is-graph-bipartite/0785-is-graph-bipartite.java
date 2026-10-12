class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] clr = new int[n];
        Arrays.fill(clr,-1);

        for(int i=0;i<n;i++){
            if(clr[i] == -1){
                if(!dfs(i,0,graph,clr)){
                    return false;
                }
            }
        
        }
        return true;
        
    }
    public boolean dfs(int node,int currentClr,int[][] graph,int[] clr){
        clr[node] = currentClr;

        for(int neigh: graph[node]){
            if(clr[neigh]==-1){
                int opp = 1-currentClr;
                if(!dfs(neigh,opp,graph,clr)){
                    return false;
                }

            }
            else if(clr[neigh] == currentClr){
                return false;
            }

        }
        return true;
    }
}