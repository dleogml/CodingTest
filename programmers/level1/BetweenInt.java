package programmers.level1;

// 두 정수 사이의 합
// a,b 가 주어 졌을 때 a와 b 사이의 정수의 합을 리턴
// a=3, b=5 => 3 + 4 + 5 = 12
// a와 b는 대소관계 없음
// a와 b는 -10,000,000이상 10,000,000이하
// a=b일 경우 둘 중 아무거나 리턴
public class BetweenInt {
    class Solution {
        public long solution(int a, int b) {
            long answer = 0;
            //최소값과 최대값
            int maxScore = Math.max(a,b);
            int minScore = Math.min(a,b);
            //최소값부터 최대값까지 for문으로 더해줌
            for(int i = minScore; i < maxScore + 1; i++) {
                answer += minScore;
                minScore++;
            }

            return answer;
        }
    }
    // 다른 사람의 풀이
    // 문제에서의 요구는 등차수열의 합이므로
    // 항의 갯수 * 두수의 합 / 2
    class Solution2 {

        public long solution(int a, int b) {
            return sumAtoB(Math.min(a, b), Math.max(b, a));
        }

        private long sumAtoB(long a, long b) {
            return (b - a + 1) * (a + b) / 2;
        }
    }
}
