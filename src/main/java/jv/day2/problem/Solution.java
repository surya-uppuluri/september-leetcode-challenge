package jv.day2.problem;

class NearByDuplicate {
    /**
     *   Contains Duplicate III
     *
     * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1], k = 3, t = 0
     * Output: true
     * Example 2:
     *
     * Input: nums = [1,0,1,1], k = 1, t = 2
     * Output: true
     * Example 3:
     *
     * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
     * Output: false
     *    Show Hint #1
     *    Show Hint #2
     *
     * @param nums
     * @param maxAbsDiffIndices
     * @param maxAbsDiffNums
     * @return
     */
    public boolean bruteForceApproach(int[] nums, int maxAbsDiffIndices, int maxAbsDiffNums) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                long diffNums = Math.abs(1L * nums[i] - nums[j]);
                //System.out.println("Diff nums is : "+ diffNums+". Max possible is "+ maxAbsDiffNums);
                int diffIndices = j - i;
                //System.out.println("Diff indices is : "+ diffIndices+". Max possible is "+ diffIndices);
                if (diffNums <= maxAbsDiffNums && diffIndices <= maxAbsDiffIndices)
                    return true;
            }
        }
        return false;
    }


}