package dev.drf.leet.code.problems.task0003;

public class TaskMain {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null) {
                return 0;
            }
            if (s.isEmpty()) {
                return 0;
            }
            int max = 0;
            int start = 0;
            int cursor = 0;
            int len = s.length();

            for (; cursor < len; cursor++) {
                char ch = s.charAt(cursor);
                if (cursor > start) {
                    for (int i = start; i < cursor; i++) {
                        char ich = s.charAt(i);

                        if (ich == ch) {
                            int newmax = cursor - start;
                            if (newmax > max) {
                                max = newmax;
                            }
                            start = i + 1;
                            break;
                        }
                    }
                }
            }

            int newmax = cursor - start;
            if (newmax > max) {
                max = newmax;
            }

            return max;
        }
    }
}
