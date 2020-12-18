package programmers.level2;

// 가장 큰 정사각형 찾기
// 0과 1로 이루어져 있는 2차원 배열이 있다
// 이 중에서 1로 이루어진 정사각형의 넓이를 구해서 리턴
public class FindBiggestSquare {
    class Solution{
        public int solution(int [][]board){
            int up, left, upleft;
            for(int y = 1 ; y < board.length; y++) {
                for(int x = 1 ; x < board[y].length; x++) {
                    if(board[y][x] == 1) {
                        up = board[y-1][x];
                        left = board[y][x-1];
                        upleft = board[y-1][x-1];

                        int min = Math.min(up, left);
                        min = Math.min(min , upleft);
                        board[y][x] = min+1;
                    }
                }
            }

            int ans = 0;
            for(int y = 0 ; y < board.length; y++) {
                for(int x= 0 ; x < board[0].length ; x++) {
                    if(board[y][x] > 0) {
                        ans = Math.max(ans, board[y][x]);
                    }
                }
            }
            return ans*ans;
        }
    }
}
