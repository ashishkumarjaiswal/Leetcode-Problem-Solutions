class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;
        boolean incr = true, decr = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                if (!incr)
                    return false;
                decr = false;
            } else {
                if (arr[i - 1] == arr[i])
                    return false;
                incr = false;
            }
        }
        if (incr || decr)
            return false;
        return true;
    }
}
