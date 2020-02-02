package TopInteviewEasy.ArrayQuestions;

import java.util.Scanner;

class T11_RoateImage {
    public void rotate(int[][] matrix) {
        int[] curEdge = new int[matrix.length];
        rotate(matrix, matrix.length,0,curEdge);
    }
    private void rotate(int[][] matrix, int edgeLength, int offset, int[]curEdge){
        if(edgeLength == 1){
            return;
        }
        if(edgeLength == 2){
            int temp = matrix[offset][offset];
            matrix[offset][offset] =  matrix[offset+1][offset];
            matrix[offset+1][offset] =  matrix[offset+1][offset+1];
            matrix[offset+1][offset+1] =  matrix[offset][offset+1];
            matrix[offset][offset+1] = temp;
            return;
        }

        for (int i = offset; i < matrix.length-1-offset; i++) {
            curEdge[i] = matrix[i][matrix.length-1-offset];  //temp store, save the right col
            // curEdge[i] = matrix[offset][i];
            // matrix[offset][i] = matrix[i][matrix.length-1-offset];
            matrix[i][matrix.length-1-offset] = matrix[offset][i];


            matrix[offset][i] = matrix[matrix.length-1-i][offset];

            matrix[matrix.length-1-i][offset] = matrix[matrix.length-1-offset][matrix.length-1-i];

            matrix[matrix.length-1-offset][matrix.length-1-i] = curEdge[i];


        }
        rotate(matrix,edgeLength-2,++offset,curEdge);
    }

    static public void main(String[] arg){
        T11_RoateImage sol = new T11_RoateImage();
        int n = 4;
        int[][] m = new int[n][n];


        System.out.println("type the matrix: ");
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                m[i][j] = s.nextInt();
            }
        }
        s.close();
        System.out.println("the matrix is:");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.err.print(m[i][j] + ",");
            }
            System.out.println();
        }

        sol.rotate(m);

        System.out.println("after rotate:");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.err.print(m[i][j] + ",");
            }
            System.out.println();
        }
    }

}