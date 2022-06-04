class Solution {
    public int largestInteger(int num) {
        int ans = 0;
        List<Integer> even = new LinkedList<>();
        List<Integer> odd = new LinkedList<>();

        int x = num;

        while (x > 0) {
            int last = x % 10;
            x = x / 10;

            if (last % 2 == 0)
                even.add(last);
            else
                odd.add(last);
        }

        Collections.sort(even);
        Collections.sort(odd);
        int eindex = even.size() - 1, oindex = odd.size() - 1;

        String s = num + "";

        for (int i = 0; i < s.length(); i++) {
            if (Integer.parseInt(s.charAt(i) + "") % 2 == 0) {
                ans = ans * 10 + even.get(eindex--);
            } else {
                ans = ans * 10 + odd.get(oindex--);
            }
        }

        return ans;
    }
}
