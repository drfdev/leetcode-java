package dev.drf.leet.code.problems.task0006;

public class TaskMain {
    class Solution {
        public String convert(String s, int numRows) {
            if (s == null || s.isEmpty()) {
                return "";
            }
            if (s.length() == 1 || numRows == 1) {
                return s;
            }
            int len = s.length();
            char[] result = new char[len];

            int factor = 2 * (numRows - 1);
            int[] counts = new int[numRows];
            for (int i = 0; i < len; i++) {
                int positionInBlock = i % factor;
                int row = positionInBlock < numRows ? positionInBlock : factor - positionInBlock;
                counts[row] = counts[row] + 1;
            }

            for (int i = 0; i < len; i++) {
                int index = calculateIndex(counts, i, factor, numRows);
                result[index] = s.charAt(i);
            }

            return new String(result);
        }

        private int calculateIndex(int[] counts, int current, int factor, int number) {
            int positionInBlock = current % factor;
            boolean left = positionInBlock < number;
            int row = left ? positionInBlock : factor - positionInBlock;
            int blockNumber = current / factor;
            int blockSize = row == 0 || row == (number - 1) ? 1 : 2;

            int offset = 0;
            for (int i = 0; i < row; i++) {
                offset += counts[i];
            }
            if (!left && blockSize > 1) {
                offset += 1;
            }

            int value = offset + blockSize * blockNumber;
            return value;
        }
    }
}
