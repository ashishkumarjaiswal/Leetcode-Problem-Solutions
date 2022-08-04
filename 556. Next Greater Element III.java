class Solution {
    public int nextGreaterElement(int n) {
        String s = n + "";
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder(String.valueOf(arr));
        sb.reverse();

        if (sb.toString().equals(s))
            return -1;

        int i = s.length() - 2;
        char[] a = s.toCharArray();
        boolean flag = false;

        for (; i >= 0; i--) {
            char max = a[i + 1];
            int y = i + 1;

            for (int j = i + 1; j < s.length(); j++) {
                if (a[i] < a[j] && a[j] <= max) {
                    max = a[j];
                    y = j;
                    flag = true;
                }
            }

            if (flag) {
                char temp = a[i];
                a[i] = a[y];
                a[y] = temp;
                break;
            }
        }

        i++;
        StringBuilder ans = new StringBuilder();

        for (int j = 0; j < i; j++) {
            ans.append(a[j]);
        }

        StringBuilder temp = new StringBuilder();

        for (; i < a.length; i++) {
            temp.append(a[i]);
        }

        char[] temparr = temp.toString().toCharArray();
        Arrays.sort(temparr);

        ans.append(String.valueOf(temparr));

        long x = Long.parseLong(ans.toString());

        return x > Integer.MAX_VALUE ? -1 : (int) x;
    }
}
