package programmers.level1;

// 정수 제곱근 판별
// 양의 정수 n이 주어지고 제곱근 x를 구해서
// x가 양의 정수이면 x+1의 제곱을 리턴
// ex)n=121 이라면 x=11이되고 양의 정수이기 때문에
// 11+1=12 즉, 12의 제곱인 144를 리턴
public class IntSqrt {
    class Solution {
        public long solution(long n) {
            long answer = 0;

            double x = (Math.sqrt(n));
            int y = (int)x;

            if(x == y) {
                answer = (long)Math.pow(x + 1, 2);
            }
            else {
                answer = -1;
            }

            return answer;
        }
    }
}
