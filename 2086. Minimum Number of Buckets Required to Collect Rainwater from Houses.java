class Solution {
    public int minimumBuckets(String s) {
        if (s.length() == 1) {
            if (s.charAt(0) == '.')
                return 0;
            else
                return -1;
        }
        
        boolean[] arr = new boolean[s.length()];
        int count = 0;
        if (s.charAt(0) == 'H') {
            if (s.charAt(1) == '.') {
                count++;
                arr[1] = true;
            } else {
                return -1;
            }
        }

        for (int i = 1; i < s.length() - 1; i++) {
            char c = s.charAt(i);

            if (c == 'H') {
                if (s.charAt(i - 1) == '.' && s.charAt(i + 1) == '.') {
                    if (!arr[i - 1]) {
                        count++;
                        arr[i + 1] = true;
                    }
                } else if (s.charAt(i - 1) == '.') {
                    if (!arr[i - 1])
                        count++;
                } else if (s.charAt(i + 1) == '.') {
                    count++;
                    arr[i + 1] = true;
                } else {
                    return -1;
                }
            }
        }

        if (s.charAt(s.length() - 1) == 'H') {
            if (s.charAt(s.length() - 2) == '.') {
                if (!arr[s.length() - 2])
                    count++;
            } else {
                return -1;
            }
        }

        return count;
    }
}
