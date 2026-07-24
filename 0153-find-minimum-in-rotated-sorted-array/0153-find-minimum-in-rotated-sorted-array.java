class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        // Single element or completely sorted array
        if (n == 1 || nums[0] < nums[n - 1]) {
            return nums[0];
        }

        int l = 0;
        int r = n - 2;

        while (l <= r) {
            int m = l + (r - l) / 2;

            // Rotation break found
            if (nums[m] > nums[m + 1]) {
                return nums[m + 1];
            }

            // Middle lies in the right sorted section
            else if (nums[0] > nums[m]) {
                r = m - 1;
            }

            // Middle lies in the left sorted section
            else {
                l = m + 1;
            }
        }

        return -1;
    }
}