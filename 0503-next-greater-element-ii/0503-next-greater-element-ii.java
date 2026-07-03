class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> st = new Stack<>();
        int[] arr = new  int[2*nums.length]; 


        for(int i = 0;i<2*nums.length;i++){

            if(i<nums.length){
                arr[i] = nums[i];
            }else{
                arr[i] = nums[i%nums.length];
            }
        }
        int[] ge = new int[2*nums.length];
        for(int i = 2*nums.length-1;i>=0;i--){
            while(!st.isEmpty()&&st.peek()<= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ge[i] = -1;
            }else{
                ge[i] = st.peek();
            }
            st.push(arr[i]);

        }
        int[] ans = new int[nums.length];
            for(int i = 0;i<nums.length;i++){
                ans[i] = ge[i];
            }

        return ans;
        
    }
}