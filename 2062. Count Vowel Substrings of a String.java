class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (isVovel(word.charAt(i))) {
                boolean[] arr = new boolean[5];
                int temp = 0;

                for (int j = i; j < word.length(); j++) {
                    char c = word.charAt(j);

                    if (isVovel(c)) {

                        int index = giveIndex(c);

                        if (!arr[index]) {
                            arr[index] = true;
                            temp++;
                        }

                        if (temp == 5) {
                            count++;
                        }

                    } else {
                        break;
                    }
                }
            }
        }

        return count;
    }

    int giveIndex(char c) {
        if (c == 'a')
            return 0;
        else if (c == 'e')
            return 1;
        else if (c == 'i')
            return 2;
        else if (c == 'o')
            return 3;
        else
            return 4;
    }

    boolean isVovel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }
}
