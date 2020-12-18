package programmers.level1;

// 행렬의 덧셈
// 두 행렬이 주어지면 같은 행, 같은 열의 값을 서로 새로운 행렬로 리턴
public class MatrixSum {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = {};
            answer = new int[arr1.length][arr1[0].length];

            for(int i=0; i<arr1.length; i++) {
                for(int j=0; j<arr1[0].length; j++) {
                    answer[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
            return answer;
        }
    }
}
