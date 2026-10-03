class Solution {
    public int[] twoSum(int[] nums, int target) {
        //create hash map to put num and index
        HashMap<Integer,Integer> map = new HashMap<>();

        //for compliment
        for(int i = 0;i<nums.length;i++){
            //diff
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};

            }
            map.put(nums[i],i);
        }
        return new int[]{};
        
        
    }
}