class Solution {
    public int findCircleNum(int[][] isConnected) {
        // lets convert matrix into adj arraylist
        ArrayList<ArrayList<Integer>> adj = new  ArrayList<ArrayList<Integer>>();
        int n = isConnected.length;
        //create a blank node
        for(int i = 0 ;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //add in that node
        for(int i = 0;i<n;i++){
            for(int j = 0; j<n;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }
        //create a visted aray
        boolean[] visited = new boolean[n];

        //ans to store the 
        ArrayList<Integer> ans = new ArrayList<Integer>();
       // visited[node] = 1;
        int count =0;
              // Find every province
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                // New province found
                count++;

                dfsHelper(i, visited, adj, ans);
            }
        }


         return count;
    }
    public void dfsHelper(int node,boolean[] visited, ArrayList<ArrayList<Integer>> adj,ArrayList<Integer>ans){
       // int count = 0;
        visited[node] = true;
        ans.add(node);
        for(int nei : adj.get(node)){
            if(!visited[nei]){
               // count++;
                dfsHelper(nei,visited,adj,ans);
            }
        }





        //return count;
    }

}