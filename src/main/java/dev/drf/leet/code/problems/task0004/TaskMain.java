package dev.drf.leet.code.problems.task0004;

public class TaskMain {
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int fullLen = nums1.length + nums2.length;
            if (fullLen == 0) {
                return 0;
            }

            boolean hasN1Val = nums1.length > 0;
            boolean hasN2Val = nums2.length > 0;

            if (!hasN2Val) {
                return median(nums1);
            }
            if (!hasN1Val) {
                return median(nums2);
            }

            if (fullLen % 2 == 0) {
                int leftIndex = fullLen / 2;
                int rightIndex = fullLen / 2 - 1;

                int leftVal = findByIndex(leftIndex, nums1, nums2);
                int rightVal = findByIndex(rightIndex, nums1, nums2);

                return ((double) leftVal + (double) rightVal) / 2;
            } else {
                int index = fullLen / 2;
                return findByIndex(index, nums1, nums2);
            }
        }

        private static int findByIndex(int index, int[] nums1, int[] nums2) {
            int fullLen = nums1.length + nums2.length;
            for (int i = 0, n1 = 0, n2 = 0; i < fullLen; i++) {
                boolean hasn1 = n1 < nums1.length;
                boolean hasn2 = n2 < nums2.length;
                int n1val = hasn1 ? nums1[n1] : 0;
                int n2val = hasn2 ? nums2[n2] : 0;

                if (i == index) {
                    if (hasn1 && hasn2) {
                        return Math.min(n1val, n2val);
                    }
                    if (hasn1) {
                        return n1val;
                    }
                    if (hasn2) {
                        return n2val;
                    }
                    throw new IllegalStateException("wtf?");
                }

                if (hasn1 && hasn2) {
                    if (n1val < n2val) {
                        n1++;
                    } else {
                        n2++;
                    }
                } else if (hasn1) {
                    n1++;
                } else if (hasn2) {
                    n2++;
                } else {
                    throw new IllegalStateException("wtf?");
                }
            }
            return 0;
        }

        private static double median(int[] array) {
            double median;
            if (array.length % 2 == 0) {
                median = ((double) array[array.length / 2] + (double) array[array.length / 2 - 1]) / 2;
            } else {
                median = (double) array[array.length / 2];
            }
            return median;
        }
    }
}
