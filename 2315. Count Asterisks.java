class Solution {
    public int countAsterisks(String s) {
        String[] arr = s.split("\\|");
        int count = 0;

        for (int i = 0; i < arr.length; i = i + 2) {
            String temp = arr[i];

            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '*')
                    count++;
            }
        }

        return count;
    }
}
