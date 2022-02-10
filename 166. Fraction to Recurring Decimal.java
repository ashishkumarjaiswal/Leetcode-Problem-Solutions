class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator == 0)
            return "0";

        if ((numerator < 0 || denominator < 0) && !(numerator < 0 && denominator < 0)) {
            sb.append("-");
        }

        long q = Math.abs(numerator / denominator);
        long r = Math.abs(numerator % denominator);
        sb.append(Math.abs(q));

        if (r == 0) {
            return sb.toString();
        } else {
            HashMap<Long, Integer> map = new HashMap<>();
            sb.append(".");
            while (r != 0) {
                if (map.containsKey(r)) {
                    sb.insert(map.get(r), "(");
                    sb.append(")");
                    return sb.toString();
                } else {
                    map.put(r, sb.length());
                    r *= 10;
                    q = Math.abs(r / denominator);
                    r = Math.abs(r % denominator);
                    sb.append(Math.abs(q));
                }
            }

        }
        return sb.toString();
    }
}
