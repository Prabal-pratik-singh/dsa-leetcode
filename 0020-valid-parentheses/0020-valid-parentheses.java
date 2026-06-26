class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
       // StringBuilder ans = new StringBuilder();
        for(int i = 0; i< s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                st.push(s.charAt(i));
            }else{
                if(st.empty()){
                    return false;
                }char ch = st.peek();
           
                if(ch == '(' && s.charAt(i) == ')'||ch == '[' && s.charAt(i) == ']'||ch == '{' && s.charAt(i) == '}'){
                    st.pop();
                }else{
                    return false;
                }
            }
            
        }
        return st.empty();
    }
}