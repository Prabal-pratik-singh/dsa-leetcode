class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(l<=h){
            if(nums.length ==1){
                min = nums[0];
                break;
            }
            int mid = l + (h-l)/2;
            
            if(nums[l]==nums[mid] && nums[h] == nums[mid]){
              min = Math.min(min,nums[l]);
 
                l++;
                h--;
            }
             else if(nums[l]<=nums[mid]){
                min = Math.min(min,nums[l]);
                l = mid+1;
            }else{
                min = Math.min(min,nums[mid]);
                h = mid-1;

            }
        }
        return min;
        
    }
}