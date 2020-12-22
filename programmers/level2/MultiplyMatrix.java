package programmers.level2;

// 행렬의 곱셈
// 2개의 행렬이 주어지고 행렬 곱셈 규칙에 따라 곱한 행렬을 리턴
// 두 행렬을 곱했을 때 나오는 행렬의 행과 열의 갯수는
// 행은 앞의 행, 열은 뒤의 열 의 수를 따른다.
public class MultiplyMatrix {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = {};
            answer = new int [arr1.length][arr2[0].length];

            for(int i=0; i<arr1.length; i++) {
                for(int j=0; j<arr2[0].length; j++) {
                    for(int k=0; k<arr1[0].length; k++) {
                        answer[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }
            return answer;
        }
    }
}
