package programmers.level1;

// 문자열을 정수로 바꾸기
// 문자열이 주어지면 해당 값을 정수로 바꿈
public class StringToInt {
    class Solution {
        public int solution(String s) {
            int answer = 0;

            answer = Integer.parseInt(s);

            return answer;
        }
    }
}
