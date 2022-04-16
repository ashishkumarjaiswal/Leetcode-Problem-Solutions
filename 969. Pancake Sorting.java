class Solution {
    void revrese(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new LinkedList<>();
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[index] < arr[j])
                    index = j;
            }

            if (index != i) {
                ans.add(index + 1);
                revrese(arr, 0, index);
                ans.add(i + 1);
                revrese(arr, 0, i);
            }
        }
        return ans;
    }
}
