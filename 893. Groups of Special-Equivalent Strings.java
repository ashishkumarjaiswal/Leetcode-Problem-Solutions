class Solution {
    public int numSpecialEquivGroups(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if ((i & 1) == 0) {
                    even.append(c);
                } else {
                    odd.append(c);
                }
            }

            char[] arr1 = even.toString().toCharArray();
            char[] arr2 = odd.toString().toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            // System.out.println(String.valueOf(arr1) + "  " + String.valueOf(arr2));

            String key = String.valueOf(arr1) + String.valueOf(arr2);

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return map.size();
    }
}
