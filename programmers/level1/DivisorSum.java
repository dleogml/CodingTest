package programmers.level1;

// 약수의 합
// 정수 n이 주어지면 n의 약수의 합을 리턴
// ex)n=12 --> 28 (1, 2, 3, 4, 6, 12)
// for문을 1부터 n/2까지 돌려도 약수를 전부 구할 수 있다
// 마지막에 answer에 n값만 더해주면 for문의 범위를 좀 더 짧게 구성할 수 있음
public class DivisorSum {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            for(int i=1; i<n; i++) {
                if(n%i == 0) {
                    answer += i;
                }
            }

            answer = answer + n;

            return answer;
        }
    }
}
