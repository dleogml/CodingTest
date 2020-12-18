package programmers.level2;

// 카카오 프렌즈 컬러링북
// 2차원 배열의 크기를 나타는 m,n이 주어지고
// 색의 값들이 담겨져있는 배열 picture가 주어진다
// 상하좌우 중 이어진 부분들은 같은 영역이고
// 같은 숫자지만 떨어져 있다면 다른 영역이다
// 길이2인 배열에 모든 영역의 갯수와 가장 큰 영역의 크기를 계산하여 리턴
public class KakaoFriendsColoringBook {
    class Solution {
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            // 이미 탐색한곳인지 표시하는 역할
            int[][] isViewd = new int[picture.length][picture[0].length];

            for (int i = 0; i < picture.length; i++) {
                for (int j = 0; j < picture[i].length; j++) {
                    int area = area(picture, isViewd, i, j);
                    if (area > 0) {
                        numberOfArea++;
                        maxSizeOfOneArea = maxSizeOfOneArea < area ? area : maxSizeOfOneArea;
                    }
                }
            }

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        // 영역을 계산하는 메소드
        public int area(int[][] picture, int[][] isViewd, int i, int j) {
            // 색칠되지 않은 곳이면 0
            if (picture[i][j] == 0) {
                return 0;
            }
            // 탐색된 곳이면 0
            if (isViewd[i][j]++ > 0) {
                return 0;
            }
            int result = 1;
            // 우
            if (i + 1 != picture.length) {
                if (picture[i + 1][j] == picture[i][j]) {
                    result += area(picture, isViewd, i + 1, j);
                }
            }
            // 상
            if (j + 1 != picture[0].length) {
                if (picture[i][j + 1] == picture[i][j]) {
                    result += area(picture, isViewd, i, j + 1);
                }
            }
            // 좌
            if (i - 1 >= 0) {
                if (picture[i - 1][j] == picture[i][j]) {
                    result += area(picture, isViewd, i - 1, j);
                }
            }
            // 하
            if (j - 1 >= 0) {
                if (picture[i][j - 1] == picture[i][j]) {
                    result += area(picture, isViewd, i, j - 1);
                }
            }

            return result;
        }
    }
}
