class Solution {
     public void subset (int i ,int[] nums,List<Integer> ls,   List<List<Integer>> ans){

        if(i == nums.length){
            ans.add(new ArrayList<> (ls));
            return;

        }
        //include
        ls.add(nums[i]);
        subset(i+1,nums,ls,ans);

        //backtrack
        ls.remove(ls.size()-1);

        //ignore
        subset(i+1,nums,ls,ans);
     }
     



    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        subset(0,nums,new ArrayList<>(),ans);
        return ans;
        
    }
}