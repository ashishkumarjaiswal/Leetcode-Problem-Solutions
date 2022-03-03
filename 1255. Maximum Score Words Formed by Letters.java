class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int arr[] = new int[26];

        for (int i = 0; i < letters.length; i++) {
            arr[letters[i] - 'a']++;
        }
        return fun(words, arr, score, 0);
    }

    int fun(String[] words, int[] letters, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }

        int notInclude = fun(words, letters, score, index + 1);

        int sc = 0;
        String s = words[index];
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] == 0) {
                flag = false;
            }

            letters[s.charAt(i) - 'a']--;
            sc = sc + score[s.charAt(i) - 'a'];
        }

        int include = 0;
        if (flag) {
            include = fun(words, letters, score, index + 1) + sc;
        }

        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }

        return Math.max(include, notInclude);
    }
}
