package programmers.level1;

// 짝수와 홀수
// 정수 num이 짝수면 "Even", 홀수면 "Odd" 리턴
public class EvenOdd {
    class Solution {
        public String solution(int num) {
            String answer = "";

            if(num % 2 == 0) {
                answer = "Even";
            }
            else {
                answer ="Odd";
            }

            return answer;
        }
    }
}
