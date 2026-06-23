class Solution {

    public int sum(int[] weights){
        int sum = 0;
         for(int i = 0; i< weights.length;i++){
            sum = sum + weights[i];
         }
         return sum;
    }

        public boolean weight(int[] weights,int days,int mid){
        int cDay =1;
        int cW = 0;
        for(int i =0 ;i<weights.length;i++){
            if(cW+weights[i]>mid){
                cDay++;
                cW = weights[i];
            }else {
                cW += weights[i];
        }    
    }
            return cDay<=days;

 }

    

    public int shipWithinDays(int[] weights, int days) {
       int low = weights[0];
for(int w : weights){
    low = Math.max(low, w);
};
        int high = sum(weights);
        while(low <= high){
           int mid = low+(high - low)/2;
            boolean t = weight(weights,days,mid);
            if(t == true){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return low;
        
    }
}