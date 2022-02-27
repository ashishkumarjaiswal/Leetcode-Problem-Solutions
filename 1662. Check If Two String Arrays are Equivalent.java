class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sone = new StringBuilder();
        for (String s : word1) {
            sone.append(s);
        }

        StringBuilder stwo = new StringBuilder();
        for (String s : word2) {
            stwo.append(s);
        }

        return sone.toString().equals(stwo.toString());
    }
}
