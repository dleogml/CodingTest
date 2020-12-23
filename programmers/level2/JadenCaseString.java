package programmers.level2;

// JadenCase 문자열 만들기
// 모든 단어의 첫 문자가 대문자이고 나머지가 소문자인 문자열을 JadenCase라고 한다
// 문자열이 주어지고 단어와 단어 사이엔 공백이 있다.
// 첫글자가 영문이 아니면 나머지는 전부 소문자이다.
public class JadenCaseString {
    // 공백인 경우 0으로 초기화
    // 0이면서 공백이 아니면 대문자
    class Solution {
        public String solution(String s) {
            String answer = "";
            s = s.toLowerCase();
            int location = 0;

            for(int i=0; i<s.length(); i++) {
                if(s.substring(i,i+1).equals(" ")) {
                    location = 0;
                }
                if(location == 0 && !s.substring(i,i+1).equals(" ")) {
                    answer += s.substring(i,i+1).toUpperCase();
                    location++;
                }
                else {
                    answer += s.substring(i,i+1).toLowerCase();
                }
            }
            return answer;
        }
    }
    // 일부 테스트 케이스에서 런타임 오류가 남
    class Solution2 {
        public String solution(String s) {
            String answer = "";

            String [] str = s.split(" ");

            for(int i=0; i<str.length; i++) {
                str[i] = str[i].substring(0,1).toUpperCase() + str[i].substring(1).toLowerCase();
            }

            answer = str[0];
            for(int i=1; i<str.length; i++) {
                answer = answer + " " + str[i];
            }

            return answer;
        }
    }
}
