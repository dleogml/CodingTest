package programmers.level2;

// 삼각 달팽이
// n만큼의 높이를 지닌 삼각형이 주어지고 (첫번째에는 1칸 두번째에는 2칸..)
// 맨위칸 1부터 반시계 방향으로 외곽을 따라서 값이 증가되어 칸마다 하나의 값을 가짐
// 이렇게 값을 넣은 후 맨위의 열부터 값을 차례대로 담은 배열을 리턴
// ex)n =4 라면
// 리턴할 배열은 [1,2,9,3,10,8,4,5,6,7]
//     1
//    2 9
//   3 10 8
//  4 5  6 7
public class TriangleLandsnail {
    class Solution {
        public int[] solution(int n) {
            int[] answer = {};

            // 삼각형의 마지막 값은
            // 1부터 n까지의 합이랑 같다.
            int max = n * (n + 1) / 2;

            // 삼각형을 만들기 위해 n x n 배열 생성
            /*
            *
            * *
            * * *
            이런 모양으로 값을 넣어줄 예정
            */
            int[][] arr = new int[n][n];
            answer = new int[max];

            // -1로 삼각형이 들어갈 곳에 미리 값을 넣어줌
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    arr[i][j] = -1;
                }
            }

            int i = 0, j = 0, k = 1;

            arr[i][j] = k;
            // 3가지 방향에 대해 세로, 가로, 대각선으로 값을 증가하며 넣어주고
            // 값이 남았다면 계속 순서대로 돌아가도록 작성
            while (k < max) {
                // 세로방향(아래로 내려가며)으로 값증가
                while (i + 1 < n && k < max && arr[i + 1][j] < 0) {
                    arr[++i][j] = ++k;
                }
                // 가로방향(오른쪽으로)으로 값증가
                while (j + 1 < n && k < max && arr[i][j + 1] < 0) {
                    arr[i][++j] = ++k;
                }
                // 대각선방향(왼쪽위 대각선)으로 값증가
                while (i - 1 > 0 && i - 1 > 0 && k < max && arr[i - 1][j - 1] < 0) {
                    arr[--i][--j] = ++k;
                }
            }

            // 리턴할배열에 순서대로 넣어주기 위해 k값 초기화
            k = 0;

            for (i = 0; i < n; i++) {
                for (j = 0; j <= i; j++) {
                    answer[k++] = arr[i][j];
                }
            }

            return answer;
        }
    }
    // 다른 사람의 풀이
    /*
    처음엔 세로방향, 두번째는 가로방향, 마지막은 대각선
    3가지경우를 나머지를 기준으로 나눠서 반복되도록 함
    */
    class Solution2 {
        public int[] solution(int n) {
            int[] answer = new int[(n*(n+1))/2];
            int[][] matrix = new int[n][n];

            int x = -1, y = 0;
            int num = 1;

            for (int i = 0; i < n; ++i) {
                for (int j = i; j < n; ++j) {
                    if (i % 3 == 0) {
                        ++x;
                    } else if (i % 3 == 1) {
                        ++y;
                    } else if (i % 3 == 2) {
                        --x;
                        --y;
                    }
                    matrix[x][y] = num++;
                }
            }

            int k = 0;
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    if(matrix[i][j] == 0) break;
                    answer[k++] = matrix[i][j];
                }
            }

            return answer;
        }
    }
}
