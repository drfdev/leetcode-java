package dev.drf.leet.code.problems.task0001;

public class TaskMain {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                for (int k = i + 1; k < len; k++) {
                    if (nums[i] + nums[k] == target) {
                        int[] res = new int[2];
                        res[0] = i;
                        res[1] = k;
                        return res;
                    }
                }
            }
            return null;
        }
    }
}
