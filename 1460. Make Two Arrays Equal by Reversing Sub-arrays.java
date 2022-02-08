class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> mapTarget = new HashMap<>();
        HashMap<Integer, Integer> mapArr = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            mapTarget.put(target[i], mapTarget.getOrDefault(target[i], 0) + 1);
            mapArr.put(arr[i], mapArr.getOrDefault(arr[i], 0) + 1);
        }

        return mapArr.equals(mapTarget);
    }
}
