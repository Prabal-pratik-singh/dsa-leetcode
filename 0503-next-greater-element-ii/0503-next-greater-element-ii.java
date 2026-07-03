class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> st = new Stack<>();
       // int[] arr = new  int[nums.length]; 


        int[] ge = new int[nums.length];
        for(int i = 2*nums.length-1;i>=0;i--){
            while(!st.isEmpty()&&st.peek()<= nums[i%nums.length]){
                st.pop();
            }if(i<nums.length){
            if(st.isEmpty()){
                ge[i] = -1;
            }else{
                ge[i] = st.peek();
            }}
            st.push(nums[i%nums.length]);

        }
        

        return ge;
        
    }
}