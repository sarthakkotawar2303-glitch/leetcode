class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxArea=0;
        while(left<right)
        {
            int minheight=Math.min(height[left],height[right]);
            int width=right-left;
            maxArea=Math.max(maxArea,width*minheight);

            if(height[left]<height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}