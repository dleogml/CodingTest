package programmers.level2;

import java.util.ArrayList;

// 프렌즈4블록
// 판의 높이인 m과 폭 n 그리고 해당조건에 맞는 문자열이 배열로 주어진다
// 2x2형태의 블록은 지워진다. 이때 중복되있는 형태의 2x2형태의 블록도 지워진다
// 지워지면 위에 블록이 아래로 내려오고 이때 2x2가 된다면 다시 또 지워진다
// 총 지워진 블록의 수를 리턴
public class FriendsFourBlock {
    class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;
            char[][] map = new char[m][n];

            for(int i = 0 ; i < m ; ++i) {
                map[i] = board[i].toCharArray();
            }

            while(true) {
                int cnt = checkBlock(m, n, map);
                if(cnt == 0) break;
                answer += cnt;

                dropBlock(m, n, map);
            }

            return answer;
        }

        private void dropBlock(int m, int n, char[][] map) {
            for(int i = 0 ; i < n ; ++i) {
                for(int j = m - 1 ; j >= 0 ; --j) {
                    if(map[j][i] == '.') {
                        for(int k = j - 1 ; k >= 0 ; --k) {
                            if(map[k][i] != '.') {
                                map[j][i] = map[k][i];
                                map[k][i] = '.';
                                break;
                            }
                        }
                    }
                }
            }
        }

        private int checkBlock(int m, int n, char[][] map) {
            int cnt = 0;
            boolean[][] isChecked = new boolean[m][n];

            for(int i = 0 ; i < m - 1 ; ++i) {
                for(int j = 0 ; j < n - 1 ; ++j) {
                    if(map[i][j] == '.') continue;
                    checkFour(map, isChecked, i, j);
                }
            }

            for(int i = 0 ; i < m ; ++i) {
                for(int j = 0 ; j < n ; ++j) {
                    if(isChecked[i][j]) {
                        cnt++;
                        map[i][j] = '.';
                    }
                }
            }

            return cnt;
        }

        private void checkFour(char[][] map, boolean[][] isChecked, int i, int j) {
            char block = map[i][j];

            for(int a = i ; a < i + 2 ; ++a) {
                for(int b = j ; b < j + 2 ; ++b) {
                    if(map[a][b] != block) return;
                }
            }

            for(int a = i ; a < i + 2 ; ++a) {
                for(int b = j ; b < j + 2 ; ++b) {
                    isChecked[a][b] = true;
                }
            }
        }
    }
}
