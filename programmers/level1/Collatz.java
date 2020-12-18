package programmers.level1;

// 콜라즈 추측
// 어떤 수가 주어졌을 때 짝수라면 나누기 2, 홀수라면 곱하기 3하고 더하기 1
// 결과로 나온수를 다시 짝수, 홀수에 맡게 계산하다보면 1을 만들수 있다는 추측
// 이렇게 걸린 반복횟수를 리턴
// 만약에 500번이상이 되면 -1을 리턴
public class Collatz {
    class Solution {
        public int solution(int num) {
            int answer = 0;
            // 홀수일 경우 곱하기 3과 1을 더해주는 데
            // 그 경우의 int의 범위를 초과하여 오류가 날 수 있기 때문에
            // long으로 변환
            long n = num;

            while(n != 1) {
                if(n%2 == 0) {
                    n = n/2;
                }
                else {
                    n = (n*3) + 1;
                }
                answer++;

                if(answer == 500) {
                    answer = -1;
                    break;
                }
            }

            return answer;
        }
    }
}
