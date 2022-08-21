class Solution {
    public int[] movesToStamp(String stamp, String target) {
        int n = target.length();
        char[] stampArr = stamp.toCharArray();
        char[] targetArr = target.toCharArray();
        boolean[] visited = new boolean[n];
        List<Integer> list = new ArrayList<>();
        int count = 0;

        while (count < n) {
            boolean flag = false;

            for (int i = 0; i <= n - stamp.length(); i++) {
                if (!visited[i] && fun(targetArr, i, stampArr)) {
                    count = replace(targetArr, i, stampArr.length, count);
                    visited[i] = true;
                    flag = true;
                    list.add(i);

                    if (count == targetArr.length)
                        break;
                }
            }

            if (!flag)
                return new int[0];
        }

        int[] result = new int[list.size()];
        int x = 0;

        for (int i = list.size() - 1; i >= 0; i--) {
            result[x++] = list.get(i);
        }

        return result;
    }

    int replace(char[] targetArr, int pos, int len, int count) {
        for (int i = 0; i < len; i++) {
            if (targetArr[i + pos] != '?') {
                targetArr[i + pos] = '?';
                count++;
            }
        }

        return count;
    }

    boolean fun(char[] target, int pos, char[] stampArr) {
        for (int i = 0; i < stampArr.length; i++) {
            if (target[i + pos] != '?' && target[i + pos] != stampArr[i]) {
                return false;
            }
        }

        return true;
    }
}
