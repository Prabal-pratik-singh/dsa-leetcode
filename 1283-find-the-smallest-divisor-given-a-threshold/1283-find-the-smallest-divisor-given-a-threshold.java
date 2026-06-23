class Solution {
    public int maxi(int[] nums){
        int maxi =0;
        for(int i =0;i<nums.length;i++){
            maxi = Math.max(maxi,nums[i]);
        }
        return maxi;
    }

    public boolean divisor(int[] nums,int threshold,int mid){
       int qSum = 0;
        for(int i =0;i<nums.length;i++){
            qSum += (nums[i]+mid-1)/mid;
        }
      if(qSum > threshold){
        return false;
      }
      return true;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = maxi(nums);
        while(low<= high){
            int mid = low +(high-low)/2;
           boolean t = divisor(nums,threshold,mid);
           if(t == true){
            high = mid -1;
           }else{
            low = mid +1;
           }
        }
        return low;
    }
}