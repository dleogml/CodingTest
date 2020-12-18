package programmers.level1;

// 가운데 글자 가져오기
// 홀수이면 한개, 짝수이면 두개를 가져와서 리턴
public class MidLetter {
    class Solution {
        public String solution(String s) {
            String answer = "";

            //짝수일 경우
            if(s.length() % 2 == 0) {
                answer = s.substring(s.length()/2 - 1, s.length()/2 + 1);
            }
            //홀수일 경우
            else {
                answer = s.substring(s.length()/2 , s.length()/2 + 1);
            }

            return answer;
        }
    }
}
