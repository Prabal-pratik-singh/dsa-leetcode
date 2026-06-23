class Solution {
    public int maxi(int[] bloomDay){
        int maxi = 0;
        for(int i =  0; i<bloomDay.length;i++){
            maxi = Math.max(maxi,bloomDay[i]);
        }
        return maxi;

    }
      public int mini(int[] bloomDay){
        int mini = Integer.MAX_VALUE;
        for(int i =  0; i<bloomDay.length;i++){
            mini = Math.min(mini,bloomDay[i]);
        }
        return mini;

    }
    public int flowerBloom(int[] bloomDay,int k,int mid, int m){
       
        int bloom =0;
        int bou =0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid ){
                bloom++;
            }else{
                bloom = 0;
            }
            if(bloom  == k ){
                bou++;
                bloom=0;
            }
            if(bou>=m){
                return m;
            }
        }
        return bou;
    }
    public int minDays(int[] bloomDay, int m, int k) {
         if(bloomDay.length<(long)m*k){
            return -1;
        }
        //int ans = 0;
        int low = mini(bloomDay);
        int high = maxi(bloomDay);
        while(low<= high){
            int mid = low+(high - low)/2;
           int blu = flowerBloom(bloomDay,k,mid,m);
          if(blu>=m){
           // ans = mid;
            high = mid -1;
           }else{
            low = mid+1;
           }
        }
        return low;
    }
}