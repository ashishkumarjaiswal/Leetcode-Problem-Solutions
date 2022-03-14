class Solution {
    public boolean judgeCircle(String moves) {
        int l, r, u, d;
        l = r = u = d = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U')
                u++;
            else if (moves.charAt(i) == 'L')
                l++;
            else if (moves.charAt(i) == 'R')
                r++;
            else
                d++;
        }
        if (l == r && u == d)
            return true;
        return false;
    }
}
