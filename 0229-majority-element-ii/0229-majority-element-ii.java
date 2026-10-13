class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int ele1 = 0;
        int ele2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0;i<nums.length;i++){
            if(count1 == 0 && nums[i] != ele2){
                ele1 = nums[i];
                count1++;
            }else if(count2 == 0 && nums[i] != ele1){
                ele2 = nums[i];
                count2++;
            }
            else if(nums[i] == ele1){
                count1++;
            }else if(nums[i] == ele2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
            List<Integer> ans= new ArrayList<>();
            int cn1 = 0;
            int cn2 = 0;
            for(int i = 0; i<nums.length;i++){
                if(ele1 == nums[i]){
                    cn1++;
                }else if(ele2 == nums[i]){
                    cn2++;
                }

            }
            if(cn1>nums.length/3 ){
                ans.add(ele1);
            }
            if(cn2>nums.length/3 && ele1!= ele2){
                ans.add(ele2);
            }
            return ans;
            
        
        
    }
}