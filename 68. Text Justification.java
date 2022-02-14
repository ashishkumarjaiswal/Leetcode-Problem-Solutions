class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int x = 0;

        for (int i = 0; i < words.length; i++) {
            int len = 0, now = 0;

            while (i < words.length && len + words[i].length() <= maxWidth) {
                len = len + words[i].length() + 1;
                i++;
                now++;
            }
            len--;

            int remainSpace = maxWidth - len;
            int z = (now - 1) == 0 ? 0 : remainSpace / (now - 1);
            StringBuilder spaceInEach = new StringBuilder();
            while (z-- > 0) {
                spaceInEach.append(" ");
            }
            spaceInEach.append(" ");

            int spaceinFist = (now - 1) == 0 ? 0 : remainSpace % (now - 1);
            StringBuilder temp = new StringBuilder();

            if (i == words.length) {
                StringBuilder s = new StringBuilder();
                while (x < words.length) {
                    s.append(words[x++]);
                    s.append(" ");
                }
                int size = maxWidth - s.length();
                if (size < 0) {
                    s.deleteCharAt(s.length() - 1);
                } else {
                    while (size-- > 0) {
                        s.append(" ");
                    }
                }
                ans.add(s.toString());
                continue;
            }

            if (now - 1 == 0) {
                StringBuilder s = new StringBuilder(words[x++]);
                int length = maxWidth - s.length();
                while (length-- > 0) {
                    s.append(" ");
                }
                ans.add(s.toString());
            } else {
                for (int j = 0; j < now; j++) {
                    if (j == now - 1) {
                        temp.append(words[x++]);
                        continue;
                    }

                    temp.append(words[x++]);
                    temp.append(spaceInEach);

                    if (spaceinFist-- > 0) {
                        temp.append(" ");
                    }
                }
                ans.add(temp.toString());
            }
            i--;

        }
        return ans;
    }
}
