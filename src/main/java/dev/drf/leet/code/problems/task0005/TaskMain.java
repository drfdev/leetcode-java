package dev.drf.leet.code.problems.task0005;

public class TaskMain {
    class Solution {
        public String longestPalindrome(String s) {
            int start = 0;
            int end = 0;
            int len = s.length();

            if (len < 2) {
                return s;
            }
            if (isPalindrome(s, 0, len - 1)) {
                return s;
            }
            int max = 0;

            for (int left = 0; left < len; left++) {
                for (int last = len - 1; last >= left; last--) {
                    if (isPalindrome(s, left, last)) {
                        int subs = last - left + 1;
                        if (max < subs) {
                            max = subs;
                            start = left;
                            end = last;
                        }
                    }
                }
            }

            return s.substring(start, end + 1);
        }

        private boolean isPalindrome(String s, int start, int end) {
            int len = end - start + 1;
            int val;
            if (len == 1) {
                return false;
            }

            if (len % 2 == 0) {
                val = len / 2;
            } else {
                val = (len - 1) / 2;
            }

            for (int i = 0; i < val; i++) {
                char char1 = s.charAt(i + start);
                char char2 = s.charAt(end - i);
                if (char1 != char2) {
                    return false;
                }
            }

            return true;
        }
    }
}
