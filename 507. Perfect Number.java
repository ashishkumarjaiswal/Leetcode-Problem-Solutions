class Solution {
    public boolean checkPerfectNumber(int num) {
        int count = 1;
        if (num == 1 || num == 2 || num == 3)
            return false;

        int x = num / 2;
        while (x > 1) {
            if (num % x == 0)
                count = count + x;
            x--;
        }
        if (count == num)
            return true;
        return false;
    }
}
