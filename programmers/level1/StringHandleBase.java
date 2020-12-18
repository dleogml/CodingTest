package programmers.level1;


// 문자열 다루기 기본
// 문자열 길이가 4 or 6이고 숫자로만 이루어져 있는지 확인
// 맞다면 true, 아니면 false
public class StringHandleBase {
    class Solution {
        public boolean solution(String s) {
            boolean answer = true;

            // 길이변수
            int length = s.length();
            // 길이가 4나 6이 아니면 false
            if(length != 4 && length != 6) {
                return false;
            }
            // 요소들 확인해서 0~9 가 아니면 false
            for(int i=0; i<length; i++) {
                char c = s.charAt(i);
                if(c<'0' || c>'9') {
                    return false;
                }
            }
            return answer;
        }
    }

    // 다른 사람의 풀이
    // 정규식으로 표현
    // String.matches 는 특정 패턴의 문자열을 포함하는지 확인할 수 있음, 정규표현식을 인자로 받음
    class Solution2 {
        public boolean solution(String s) {
            if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
            return false;
        }
    }
}
