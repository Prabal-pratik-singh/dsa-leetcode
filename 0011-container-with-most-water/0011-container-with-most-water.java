class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int ans = 0;
        while(i<j){
            int width = j-i;
            int minHeight = Math.min(height[i],height[j]);
            int water =  width*minHeight;
            ans = Math.max(ans,water);

            if (height[i] < height[j]) {
    i++;
} else {
    j--;
}
        }

        return ans;
    }
}