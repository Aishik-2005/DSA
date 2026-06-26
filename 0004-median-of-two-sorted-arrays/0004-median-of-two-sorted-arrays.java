class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;

        int i = 0, j = 0;
        int prev = 0, curr = 0;

        // Traverse only till middle
        for (int count = 0; count <= total / 2; count++) {
            prev = curr;

            if (i < m && (j >= n || nums1[i] < nums2[j])) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }
        }

        // If even length → average of two middle elements
        if (total % 2 == 0) {
            return (prev + curr) / 2.0;
        } 
        // If odd → middle element
        else {
            return curr;
        }
    }
}