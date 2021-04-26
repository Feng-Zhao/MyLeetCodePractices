package jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;

public class P12_MartixRoad {
    // recursive DFS
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || 
                      dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

    // non-recursive BFS
    public boolean exist2(char[][] board, String word) {
        if (word == null || word.length() == 0){
            return false;
        }

        // Stack
        Deque<Tuple> q = new LinkedList<>(); 
        // init the search
        findHead(q,board,word.charAt(0));
        Deque<Tuple> visitied = new LinkedList<>();

        while(!q.isEmpty()){
            // get current
            Tuple cur = q.pop();
            
            // check remove visitied mark
            if(cur.pos == -1){
                visitied.pop();
                continue;
            }

            // for normal node,
            // push a mark for removing the current node after visited all children
            q.push(new Tuple(-1, -1, -1));

            // store visitied
            visitied.push(cur);

            // check out the pos of target char
            int pos = cur.pos;
            // matched all char
            if(pos == word.length()){
                return true;
            }
            // find target and push it into the q.
            else{
                char target = word.charAt(pos);
                int x = cur.row;
                int y = cur.col;
                if(x < board.length-1 && board[x+1][y] == target){
                    Tuple temp = new Tuple(pos+1, x+1, y);
                    if(!visitied.contains(temp)){
                        q.push(temp);
                    }
                }
                if(x > 0 && board[x-1][y] == target){
                    Tuple temp = new Tuple(pos+1, x-1, y);
                    if(!visitied.contains(temp)){
                        q.push(temp);
                    }
                }
                if(y < board[0].length-1 && board[x][y+1] == target){
                    Tuple temp = new Tuple(pos+1, x, y+1);
                    if(!visitied.contains(temp)){
                        q.push(temp);
                    }
                }
                if(y > 0 && board[x][y-1] == target){
                    Tuple temp = new Tuple(pos+1, x, y-1);
                    if(!visitied.contains(temp)){
                        q.push(temp);
                    }
                }
            }
        }
        return false;
    }

    private void findHead(Deque<Tuple> q, char[][]board, char t){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if(board[row][col] == t){
                    q.push(new Tuple(1, row, col));
                }
            }
        }
    }

    class Tuple{
        public int row,col;
        public int pos;
        Tuple(int pos,int row, int col){
            this.row = row;
            this.col = col;
            this.pos = pos;
        }

        @Override
        public int hashCode() {
            return row * 137 + col * 293;
        }

        @Override
        public boolean equals(Object other) {
            if(other instanceof Tuple){
                return ( this.row == ((Tuple)other).row && this.col == ((Tuple)other).col); 
            }
            else{
                return false;
            }

        }
        
    }

    public static void main(String[] args) {
        char[][] test = {{'A','A'}};
        String word = "AAA";
        P12_MartixRoad p = new P12_MartixRoad();
        System.out.println(p.exist(test, word));
    }
}