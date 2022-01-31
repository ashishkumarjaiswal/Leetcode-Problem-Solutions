class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int x = 2;
        if (ruleKey.equals("type"))
            x = 0;
        else if (ruleKey.equals("color"))
            x = 1;
        for (List<String> l : items) {
            if (l.get(x).equals(ruleValue))
                count++;
        }
        return count;
    }
}
