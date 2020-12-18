package programmers.level2;

import java.util.*;

// 괄호 변환
/*
1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
  4-3. ')'를 다시 붙입니다.
  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
  4-5. 생성된 문자열을 반환합니다.

위와 같은 규칙을 적용하여 주어진 String p를 올바른 괄호 문자열로 리턴
*/
public class ParenthesesChange {
    static class Solution {
        public String solution(String p) {
            return makeCorrect(p);
        }

        // 문자열 w를 '올바른 문자열'로
        static String makeCorrect(String w) {
            if(w.length() == 0)
                return "";

            // 괄호숫자가 똑같은 지점
            int cut = division(w);
            String u = w.substring(0, cut);
            String v = w.substring(cut, w.length());

            // 재귀함수로 구현하는 것이 포인트
            // u가 올바른 괄호 문자열이면 v에 대하여 다시 1단계부터
            // u가 올바른 괄호 문자열이 아니면 v를 1단계부터 수행한 것에 앞뒤에 ()를 붙이고
            // u는 앞뒤를 짜르고 각 괄호를 뒤집는다
            if(isCorrect(u)) {
                return u + makeCorrect(v);
            }else {
                String temp = '(' + makeCorrect(v) + ')';
                u = u.substring(1, u.length()-1);
                u = reverse(u);
                return temp + u;
            }

        }

        // w를 가장 작은 크기의 균형 문자열로 자를 수 있는 index 리턴
        static int division(String w) {
            int close = 0, open = 0;
            int i;
            for( i = 0 ; i < w.length(); i++) {
                if(w.charAt(i) == '(') {
                    open++;
                }else
                    close++;
                if(open == close)
                    return i+1;
            }
            return i;
        }

        // 문자열 w의 옳은 문자열 여부 리턴
        static boolean isCorrect(String w) {
            int count = 0;
            for(int i = 0 ; i < w.length(); i++) {
                if(w.charAt(i) == '(') {
                    count++;
                }else
                    count--;
                if(count < 0)
                    return false;
            }
            return count == 0;
        }

        // 문자열 w의 괄호방향 뒤집기
        static String reverse(String w) {

            StringBuffer ret = new StringBuffer();
            for(int i = 0 ; i < w.length() ; i++) {
                if(w.charAt(i) == ')') {
                    ret.append('(');
                }else
                    ret.append(')');
            }
            return ret.toString();
        }
    }
}
