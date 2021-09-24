class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> val = new HashMap<>();
        val.put('I', 1);
        val.put('V', 5);
        val.put('X', 10);
        val.put('L', 50);
        val.put('C', 100);
        val.put('D', 500);
        val.put('M', 1000);
        int total = 0;
        if(s.length()==0)
        return 0;
        if(s.length()==1)
        return val.get(s.charAt(0));
        for (int j = s.length() - 1; j > 0; j--) {
            int x = val.get(s.charAt(j));
            int y = val.get(s.charAt(j - 1));
            if (x > y) {
                total = total + x - y;
                j--;
            } else
                total = total + x;
        }
        if (val.get(s.charAt(0)) >= val.get(s.charAt(1)))
            total = total + val.get(s.charAt(0));
        return total;
    }
}
