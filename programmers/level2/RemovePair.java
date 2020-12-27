package programmers.level2;

import java.util.Stack;

// 짝지어 제거하기
// 문자열이 주어지면 같은 문자열을 짝으로 찾아서 지우고 이어붙임 다시 반복
// 끝까지 반복했을 때 다 지워진다면 1, 지우지 못한다면 0을 리턴
// 스택을 사용하면 간단한 문제
// 스택이 비어있고 스택의 최근값과 넣으려는 값이 같다면
// 값을 넣지 않고 최근값 삭제 ==> 짝지어 값을 뺴는 것과 같은 효과
public class RemovePair {
    class Solution{
        public int solution(String s) {
            int answer = 0;
            Stack<Character> stack = new Stack<>();

            for(char c : s.toCharArray()) {
                if(!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }

            // 스택의 사이즈를 이용해서도 판별할 수 있음
            // return stack.size() > 0 ? 0 : 1;
            return stack.isEmpty() ? 1 : 0;
        }

    }
}
