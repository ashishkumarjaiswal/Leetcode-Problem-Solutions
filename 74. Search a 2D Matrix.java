class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (target <= matrix[mid][matrix[0].length-1] && target >= matrix[mid][0])
                break;

            if (target < matrix[mid][0])
                high = mid - 1;
            else
                low = mid + 1;
        }

        int row = (low + high) / 2;
        low = 0;
        high = matrix[0].length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[row][mid] == target)
                return true;

            if (matrix[row][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}


//Another One
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
