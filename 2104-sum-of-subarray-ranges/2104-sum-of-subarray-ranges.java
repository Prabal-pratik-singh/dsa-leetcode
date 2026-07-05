class Solution {

    int[] fpse(int[] nums){
        int[] pse = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<nums.length;i++){
            while(!st.isEmpty()  && nums[i]<=nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            }else{
                pse[i] = st.peek();
            }
            st.push(i);

        }
      return pse;

    }

    int[] fnse(int[] nums){
        int[] nse = new int[nums.length];
        Stack<Integer> st= new Stack<>();
        for(int i = nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }if(st.isEmpty()){
                nse[i] = nums.length;
            }else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
    }

    int[] fpge(int[] nums){
        int[] pge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<nums.length; i++){
        while(!st.isEmpty()&&nums[st.peek()]<=nums[i]){
            st.pop();
        }if(st.isEmpty()){
            pge[i] = -1;
        }else{
            pge[i] = st.peek();
        }
        st.push(i);
        }
        return pge;
    }

    
    int[] fnge(int[] nums){
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i =nums.length-1;i>=0; i--){
        while(!st.isEmpty() && nums[st.peek()]<nums[i]){
            st.pop();
        }if(st.isEmpty()){
            nge[i] = nums.length;
        }else{
            nge[i] = st.peek();
        }
        st.push(i);
        }
        return nge;
    }

    long min(int[] nums){
      //    int[] nge = fnge(nums);
    //int[] pge = fpge(nums);
        int[] nse = fnse(nums);
        int[] pse = fpse(nums);
        long total =0;
        for(int i =0;i<nums.length;i++){
           long left = i-pse[i];
           long right =nse[i] - i;
           total += left*right*nums[i];

        }
        return total;

    }

    long max(int[] nums){
          int[] nge = fnge(nums);
        int[] pge = fpge(nums);
      //  int[] nse = fnse(nums);
        //int[] pse = fpse(nums);
        long total =0;
          for(int i = 0;i<nums.length;i++){
           long left = i-pge[i];
           long right =nge[i] - i;
           total += left*right*nums[i];

        }
        return total;
    }
    public long subArrayRanges(int[] nums) {
      
         long max = max(nums);
         long min = min(nums);
         return max-min; 
        
    }
}