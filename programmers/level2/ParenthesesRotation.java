package programmers.level2;
import java.util.*;

// 괄호 회전하기
/*
문자열 s가 주어지면 한칸씩 회전하면서 모든 경우의 수 중 올바른 괄호 문자열이 몇개인지 리턴
괄호의 종류 대괄호, 중괄호, 소괄호로 3종류이다.
s의 길이는 1이상 1,000이하
스택을 활용하여 푸는 문제
*/

public class ParenthesesRotation {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            String checkS = s;

            for(int i = 0; i<s.length(); i++) {
                if(checkP(checkS)) answer++;
                checkS = checkS.substring(1, s.length()) + checkS.charAt(0);
            }


            return answer;
        }

        boolean checkP(String s) {
            Stack<Character> stack = new Stack<>();

            for(int i=0; i<s.length(); i++) {
                char tmp = s.charAt(i);
                try {
                    if(tmp == '[' || tmp == '{' || tmp == '(') {
                        stack.add(tmp);
                    }
                    else if (tmp == ')') {
                        if(stack.peek() == '(') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                    }
                    else if (tmp == '}') {
                        if(stack.peek() == '{') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                    }
                    else {
                        if(stack.peek() == '[') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                    }

                }
                catch (Exception e){
                    return false;
                }

            }
            return true;
        }

        // 괄호를 체크하는 boolean function 다른사람 버전
        // 내가한대로 풀면 프로그래머스 한가지 테스트케이스에서 시간초과가 나옴
        boolean checkString(String s){
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++){
                try{
                    switch(s.charAt(i)){
                        case '[':
                            stack.add('[');
                            break;
                        case ']':
                            if(stack.peek() != '[') return false;
                            stack.pop();
                            break;
                        case '{':
                            stack.add('{');
                            break;
                        case '}':
                            if(stack.peek() != '{') return false;
                            stack.pop();
                            break;
                        case '(':
                            stack.add('(');
                            break;
                        case ')':
                            if(stack.peek() != '(') return false;
                            stack.pop();
                            break;
                    }
                } catch(Exception e){
                    return false;
                }
            }
            return stack.isEmpty() ? true : false;
        }

    }
}
