package programmers.level2;

// 숫자의 표현
// 숫자 n이 주어졌을 때 연속된 숫자의 합으로 n이 되는
// 경우의 수를 구해서 리턴
/* ex) n = 15
1 + 2 + 3 + 4 + 5 = 15
4 + 5 + 6 = 15
7 + 8 = 15
15 = 15
*/
public class ExpressionOfNumber {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            for(int i=1; i<=n; i++) {
                int sum = 0;
                for(int j=i; j<=n; j++) {
                    sum += j;
                    if(sum == n) {
                        answer++;
                        break;
                    }
                    else if(sum > n) {
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
