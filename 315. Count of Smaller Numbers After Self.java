class Solution {
    int[] ans;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        ans = new int[n];
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = nums[i];
        }

        mergeSort(arr, 0, n - 1);

        List<Integer> list = new LinkedList<>();

        for (Integer integer : ans) {
            list.add(integer);
        }

        return list;
    }

    int[][] mergeSort(int[][] arr, int left, int right) {
        if (left > right)
            return new int[0][0];

        if (left == right) {
            int temp[][] = new int[1][2];
            temp[0][0] = arr[left][0];
            temp[0][1] = arr[left][1];

            return temp;
        }

        int middle = (left + right) / 2;

        int[][] leftArr = mergeSort(arr, left, middle);
        int[][] rightArr = mergeSort(arr, middle + 1, right);
        return merge(leftArr, rightArr);
    }

    int[][] merge(int[][] leftArr, int[][] rightArr) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[][] curr = new int[leftArr.length + rightArr.length][2];

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i][1] <= rightArr[j][1]) {
                curr[k++] = rightArr[j++];
            } else {
                int index = leftArr[i][0];
                ans[index] = ans[index] + rightArr.length - j;
                curr[k++] = leftArr[i++];
            }
        }

        while (i < leftArr.length) {
            curr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            curr[k++] = rightArr[j++];
        }

        return curr;
    }
}
