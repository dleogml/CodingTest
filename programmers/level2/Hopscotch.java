package programmers.level2;

// 땅따먹기
// N행 4열로 이루어진 land가 주어지고 각 행마다 점수가 적힌 숫자가 주어진다
// 행마다 하나의 열만 밟을 수 있고 같은 열을 연속되게 밟을 순 없다
// 여러가지 경우의 수 중 가장 높은 점수를 리턴
public class Hopscotch {
    class Solution {
        int solution(int[][] land) {
            int answer = 0;

            // 0번째 열은 1,2,3열의 최대값과 더함
            // 1번째 열은 0,2,3열의 최대값과 더함
            // 이런식으로 마지막행에 각열의 최대값4개가 저장됨
            for(int i = 1 ; i < land.length ; ++i){
                land[i][0] += Math.max(land[i - 1][1],
                        Math.max(land[i - 1][2], land[i - 1][3]));
                land[i][1] += Math.max(land[i - 1][0],
                        Math.max(land[i - 1][2], land[i - 1][3]));
                land[i][2] += Math.max(land[i - 1][0],
                        Math.max(land[i - 1][1], land[i - 1][3]));
                land[i][3] += Math.max(land[i - 1][0],
                        Math.max(land[i - 1][1], land[i - 1][2]));
            }

            // for문과 삼항연산자를 통해 열의 값 중 최대값을 찾음
            for(int i = 0 ; i < 4 ; ++i){
                int value = land[land.length - 1][i];
                answer = value > answer ? value : answer;
            }

            return answer;
        }
    }
}
