class Solution {
    public int secondHighest(String s) {
        int largest = -1, secondLargest = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int x = Integer.parseInt(s.substring(i, i + 1));
                if (x > largest) {
                    secondLargest = largest;
                    largest = x;
                } else if (x > secondLargest && x != largest) {
                    secondLargest = x;
                }
            }
        }
        return secondLargest;
    }
}
