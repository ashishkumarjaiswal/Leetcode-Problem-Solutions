class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            int one = Integer.parseInt(arr1[i++]);
            int two = Integer.parseInt(arr2[j++]);

            if (one > two) {
                return 1;
            } else if (one < two) {
                return -1;
            }
        }

        while (i < arr1.length) {
            int x = Integer.parseInt(arr1[i++]);
            if (x > 0)
                return 1;
        }

        while (j < arr2.length) {
            int x = Integer.parseInt(arr2[j++]);
            if (x > 0)
                return -1;
        }

        return 0;
    }
}
