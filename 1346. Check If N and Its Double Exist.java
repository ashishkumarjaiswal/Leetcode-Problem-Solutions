class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] * 2))
                return true;
            if (arr[i] % 2 == 0) {
                int x = arr[i] >> 1;
                if (map.containsKey(x))
                    return true;
            }
            map.put(arr[i], 1);
        }
        return false;
    }
}
