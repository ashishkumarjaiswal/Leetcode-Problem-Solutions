class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0)
                continue;
            for (int j = 0; j < digits.length; j++) {
                if (j == i)
                    continue;
                int count = ((digits[i] * 10) + digits[j]) * 10;
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j)
                        continue;

                    if (digits[k] % 2 == 0) {
                        set.add(count + digits[k]);
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
