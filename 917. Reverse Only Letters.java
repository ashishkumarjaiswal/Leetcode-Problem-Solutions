class Solution {
    public String reverseOnlyLetters(String s) {
        int i = 0, j = s.length() - 1;
        char[] arr = s.toCharArray();

        while (i < j) {
            while (i < j && !isValid(s.charAt(i))) {
                i++;
            }

            while (i < j && !isValid(s.charAt(j))) {
                j--;
            }

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        return String.valueOf(arr);
    }

    boolean isValid(char c) {
        int i = c;

        if ((i >= 'a' && i <= 'z') || (i >= 'A' && i <= 'Z')) {
            return true;
        }

        return false;
    }
}
