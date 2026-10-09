class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //since only matrix is given yu need to mke a adj 
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

         for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
         }
         for(int[] prereq : prerequisites){
            int course = prereq[0];
            int pre = prereq[1];
            adj.get(pre).add(course);
         }

         boolean[] visited = new boolean[numCourses];
         boolean[] pathVisited =  new boolean[numCourses];
         for(int i = 0 ; i<numCourses ; i++){
            if(!visited[i]){
                boolean CycleFound = dfs(i,adj,visited , pathVisited);

                if(CycleFound){
                    return false;
                }
            }
            
         }
         return true;
        
    }
    public boolean dfs(int node,  ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] pathVisited){
        visited[node] = true;
        pathVisited[node] = true;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                 if(dfs(neighbour,adj,visited , pathVisited)){
                    return true;
                 }
                
 
            }
             else if(pathVisited[neighbour]){
                return true;
            }
            

        }
        pathVisited[node] = false;
        return false;
    }
}