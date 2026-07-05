class Solution {
            int[] fpse(int[] arr){
            Stack<Integer> st = new Stack<>();
            int[] pse = new int[arr.length];
            for (int i = 0; i < arr.length; i++){
                    while(!st.isEmpty() && arr[i]< arr[st.peek()]){
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

        int[] fnse(int[] arr){
            int[] nse = new int[arr.length];
            Stack<Integer> st=  new Stack<>();
            for (int i = arr.length - 1; i >= 0; i--){

                    while(!st.isEmpty()&& arr[i]<=arr[st.peek()]){
                st.pop();
                }
            if(st.isEmpty()){
                nse[i] = arr.length;
            }else{
                nse[i] = st.peek();
            }
            st.push(i);
            }
            return nse;
        }




    public int sumSubarrayMins(int[] arr) {
        int[] nse = fnse(arr);
        int[] pse = fpse(arr);
        int total = 0;
        int mod = 1000000007;
        for(int i = 0 ;i<arr.length;i++){
           int left = i  - pse[i];
           int right = nse[i] -i;
           total = (int)(total + ((long)left*right*arr[i])% mod)% mod;
        }

 

    
    return total;
        
    }
}