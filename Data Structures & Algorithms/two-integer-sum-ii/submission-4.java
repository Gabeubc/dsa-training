class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        while(l<r){
            while(l<r && numbers[l]+numbers[r]<target) l++;
            while(l<r && numbers[l]+numbers[r]>target) r--;
            if(numbers[l]+numbers[r]==target) return new int[]{l+1, r+1};
        }
        return new int[2];
    }
}
