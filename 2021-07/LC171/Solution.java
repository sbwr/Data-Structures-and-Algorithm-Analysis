package LC171;

class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0, n = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            result += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, n++);
        } return result;
    }
}