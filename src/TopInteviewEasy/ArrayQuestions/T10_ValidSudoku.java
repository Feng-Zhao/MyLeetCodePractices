package TopInteviewEasy.ArrayQuestions;

import java.util.HashSet;
import java.util.Set;

class T10_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> checkSet = new HashSet<>();
        boolean checkRes = true;
        checkRes = checkRes&&rowCheck(checkSet,board);
        checkRes = checkRes&&colCheck(checkSet,board);
        checkRes = checkRes&&blockCheck(checkSet,board);
        return checkRes;
    }

    private boolean blockCheck(Set<Integer> checkSet, char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        int cur = board[3*i+m][3*j+n] - '0';
                        if(cur >= 0 && cur <= 9){
                            if(checkSet.contains(cur)){
                                checkSet.clear();
                                return false;
                            }
                        }
                        checkSet.add(cur);
                    }
                }
                checkSet.clear();
            }
        }
        checkSet.clear();
        return true;
    }

    private boolean colCheck(Set<Integer> checkSet, char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int cur = board[j][i] - '0';
                if(cur >= 0 && cur <= 9){
                    if(checkSet.contains(cur)){
                        checkSet.clear();
                        return false;
                    }
                    checkSet.add(cur);
                }
            }
            checkSet.clear();
        }
        checkSet.clear();
        return true;
    }

    private boolean rowCheck(Set<Integer> checkSet, char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int cur = board[i][j] - '0';
                if(cur >= 0 && cur <= 9){
                    if(checkSet.contains(cur)){
                        checkSet.clear();
                        return false;
                    }
                    checkSet.add(cur);
                }
            }
            checkSet.clear();
        }
        checkSet.clear();
        return true;
    }
}