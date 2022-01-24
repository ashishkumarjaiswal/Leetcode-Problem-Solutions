class Solution {
    public boolean detectCapitalUse(String word) {
        boolean isFirstCapital = false;
        if (word.charAt(0) <= 'Z' && word.charAt(0) >= 'A')
            isFirstCapital = true;
        boolean isAnotherCapital = false;
        int countMiddle = 0;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) <= 'Z' && word.charAt(i) >= 'A') {
                isAnotherCapital = true;
                countMiddle++;
            }
        }
        if (isFirstCapital && !isAnotherCapital) {
            return true;
        } else if (isFirstCapital && isAnotherCapital) {
            if (countMiddle == word.length() - 1)
                return true;
            return false;
        } else if (!isFirstCapital && isAnotherCapital) {
            return false;
        }
        return true;

    }
}
