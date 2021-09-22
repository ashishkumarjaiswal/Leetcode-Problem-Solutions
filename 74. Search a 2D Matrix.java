class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix[0].length - 1, mid = (start + end) / 2;
        if (end == 0) {
            end = matrix.length-1;
            while (end >= start) {
                mid = (start + end) / 2;
                if (matrix[mid][0] == target)
                    return true;
                else if (matrix[mid][0] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][start] && target <= matrix[i][end]) {
                while (end >= start) {
                    mid = (start + end) / 2;
                    if (matrix[i][mid] == target)
                        return true;
                    else if (matrix[i][mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                break;
            }
        }
        return false;
    }
}
