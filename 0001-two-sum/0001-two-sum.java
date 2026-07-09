class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must not be null");
        }
        int n = nums.length;
        for (int i=0 ; i< n ; i++ ){
            for (int j = i+1 ; j<  n ; j++){
                if( nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two elements in nums sum to target");
    }
}