import java.util.*;

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.length() == 0 || encodedText.length() == 1)
            return encodedText;
        int col = encodedText.length() / rows;
        char[][] arr = new char[rows][col];
        int k = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = encodedText.charAt(k++);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int g = 0; g < col; g++) {
            for (int i = 0, j = g; j < col && i < rows; i++, j++) {
                sb.append(arr[i][j]);
            }
        }

        while (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}
