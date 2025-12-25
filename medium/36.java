import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set;
        for (int i = 0; i < board.length; i++) {
            set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]=='.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            set = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i]=='.') continue;
                if (set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }
        for (int i = 0; i < board.length; i+=3) {
            for (int j = 0; j < board[i].length; j+=3) {
                set = new HashSet<>();
                for(int k = 0; k < 9; k++) {
                    if (board[i+k/3][j+k%3]=='.') continue;
                    if (set.contains(board[i+k/3][j+k%3])) return false;
                    set.add(board[i+k/3][j+k%3]);
                }
            }
        }
        return true;
    }
}
