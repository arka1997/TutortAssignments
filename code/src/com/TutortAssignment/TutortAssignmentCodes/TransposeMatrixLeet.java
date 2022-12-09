package com.TutortAssignment.TutortAssignmentCodes;

public class TransposeMatrixLeet {
    public static void main(String[] args) {
            int[][] matrix = {{1, 4, 7}, {2, 5, 8}};
        transpose(matrix);
    }
    public static int[][] transpose(int[][] matrix) {
        // the matrix will always be a square matrix or not
        int r = matrix.length;//3
        int c = matrix[0].length;//2
        int[][] matrix1 = new int[c][r];//2
        for(int i=0;i<c;i++){
            for(int j=0;j<r;j++){
                matrix1[i][j] = matrix[j][i];
            }
        }
        return matrix1;
    }
}
