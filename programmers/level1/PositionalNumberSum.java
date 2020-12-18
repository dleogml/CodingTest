package programmers.level1;

// 자릿수 더하기
// 각 자리의 숫자를 더해서 더한 값을 리턴
public class PositionalNumberSum {
    public class Solution {
        public int solution(int n) {
            int answer = 0;

            int length = (int)(Math.log10(n)+1);

            for(int i=0; i<length; i++) {
                answer += n%10;
                n = n/10;
            }

            return answer;
        }
    }
}
