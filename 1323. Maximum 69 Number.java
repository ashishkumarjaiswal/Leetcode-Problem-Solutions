class Solution {
    public int maximum69Number(int num) {
        List<Integer> ashish = new ArrayList<>();
        int x = num;
        while (x > 0) {
            int y = x % 10;
            x = x / 10;
            ashish.add(y);
        }
        int ret = 0;
        for (int i = ashish.size() - 1; i >= 0; i--) {
            if (ashish.get(i) == 6) {
                ret = (ret * 10) + 9;
                i--;
                while (i >= 0) {
                    ret = (ret * 10) + ashish.get(i);
                    i--;
                }
                return ret;
            }
            ret = (ret * 10) + ashish.get(i);
        }
        return num;
    }
}
