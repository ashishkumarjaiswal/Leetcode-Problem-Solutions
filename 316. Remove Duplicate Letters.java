class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] come = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']--;

            if (come[c - 'a'])
                continue;

            while (!st.isEmpty() && st.peek() > c && freq[st.peek() - 'a'] != 0) {
                char x = st.pop();
                come[x - 'a'] = false;
            }

            st.push(c);
            come[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
