public class Solution {
    public String convertToTitle(int columnNumber) {
        //O(logN base 26)
        //S(logN base 26)
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            char c = (char) ('A' + columnNumber % 26);
            result.insert(0, c);
            columnNumber /= 26;
        }
        return result.toString();
    }
}