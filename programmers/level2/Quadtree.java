package programmers.level2;

// 쿼드 압축
// 특정 영역이 주어지면 4분면으로 나누고 영역이 같은 수라면 하나의 수로 바꿈
// 그렇지 않다면 남은 부분들은 다시 4분면으로 나누고 이 행동을 반복
// 최소의 영역으로 나눠졌을 때 0과 1의 개수를 길이 2 배열의 담아서 리턴
public class Quadtree {
    // 풀이 자체는 재귀로 구성했지만 프로그래머스에서 시간초과가 남
    class Solution {
        int zero;
        int one;

        public int[] solution(int[][] arr) {
            int[] answer = {};
            zero = 0;
            one = 1;
            int len = arr.length;

            quad(arr, 0, 0, len);

            answer = new int[] {zero, one};

            return answer;
        }

        public void quad(int[][] arr, int a, int b, int len) {
            if(len == 1) {
                if(arr[a][b] == 0) {
                    zero++;
                }
                else {
                    one++;
                }
                return;
            }
            int val = arr[a][b];
            boolean flag = true;
            for(int i=a; i<a+len; a++) {
                if(flag) {
                    for(int j=b; j<b+len; j++) {
                        if(val != arr[i][j]) {
                            flag = false;
                            break;
                        }
                    }
                }
                else {
                    break;
                }
            }

            if(flag) {
                if(val == 0) {
                    zero++;
                }
                else {
                    one++;
                }
            }
            else {
                len = len/2;

                quad(arr, a, b, len);
                quad(arr, a + len, b, len);
                quad(arr, a, b + len, len);
                quad(arr, a + len, b + len, len);
            }

        }

    }

    // 다른 사람의 풀이
    // 재귀와 같은 수를 판별하는 메소드를 만듬
    class Solution2 {
        private int[][] map;
        private int zero = 0;
        private int one = 0;

        // 재귀로 4분면의 값을 찾는 메소드
        // 크기가 1인 경우와
        // 1보다 클 경우 압축 가능한지 체크하고
        // 4개로 나눔
        private void dfs(int n, int x, int y) {
            if (n == 1) { // 한개인 경우 해당 값 +
                if (map[x][y] == 1) {
                    one++;
                } else {
                    zero++;
                }
                return;
            }
            if (isSame(n, x, y)) { //같은값인지 압축 가능한지
                return;
            }
            //4개 분리 탐색
            dfs(n / 2, x, y);
            dfs(n / 2, x + n / 2, y);
            dfs(n / 2, x, y + n / 2);
            dfs(n / 2, x + n / 2, y + n / 2);
        }

        // 같은 값인지 확인하고 같다면 압축
        public boolean isSame(int n, int x, int y) {
            int first = map[x][y];
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    // 같은 값인지 체크하고 하나라도 다르면 false
                    if (first != map[i][j]) {
                        return false;
                    }
                }
            }
            //압축 가능하면 해당 값 +1
            if (first == 0) {
                zero ++;
            } else {
                one ++;
            }
            return true;
        }

        public int[] solution(int[][] arr) {
            int[] answer = new int[2];
            map = arr;
            dfs(arr.length, 0, 0);
            answer[0] = zero;
            answer[1] = one;
            return answer;
        }

    }
}
