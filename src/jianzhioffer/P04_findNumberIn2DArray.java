package jianzhioffer;


public class P04_findNumberIn2DArray {
    // locate the row and binary search
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        // null
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // 1 row
        if (matrix.length == 1) {
            return binarySearchRow(matrix[0],target);
        }
        // matrix
        // serach the by row
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] <= target && matrix[row][matrix[0].length - 1] >= target) {
                if (binarySearchRow(matrix[row], target)) {
                    return true;
                }
            }
        }
        return false;
    }

    // search from the top-right
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        // null
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // 1 row
        if (matrix.length == 1) {
            return binarySearchRow(matrix[0],target);
        }
        // search
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }
            else if (matrix[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }

    private static boolean binarySearchRow(int[] data, int target){
        if(data.length == 0){
            return false;
        }
        else{
            int left = 0;
            int right = data.length - 1;
            int mid = left + (right - left)/2;

            while(left <= right){
                if(data[mid] == target){
                    return true;
                }
                else if(data[mid] > target){
                    right = mid - 1;
                }
                else if(data[mid] < target){
                    left = mid + 1;
                }
                mid = left + (right - left)/2;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{-1},{-1}};
        int target = -1;
        System.out.println(findNumberIn2DArray2(matrix,target));
    }
}
