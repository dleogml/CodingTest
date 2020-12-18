package programmers.level2;

import java.util.Stack;

// 큰 수 만들기
// 문자열 형식 숫자 number와 제거할 수의 개수가 적힌 k가 주어진다
// number에서 k만큼 제거한 숫자들의 경우를 모두 비교해서
// 가장 높은 수를 리턴
public class BigNumberMake {
    class Solution {
        public String solution(String number, int k) {
            String answer = "";
            char[] input = number.toCharArray();

            Stack<Character> temp = new Stack<>();

            for(int i=0; i<input.length; i++) {
                while(!temp.empty() && k > 0 && temp.peek() < input[i]) {
                    k--;
                    temp.pop();
                }
                temp.push(input[i]);
            }
            StringBuilder sb = new StringBuilder();

            while(!temp.empty()) {
                if(k != 0) {
                    temp.pop();
                    k--;
                }
                else {
                    sb.append(temp.pop());
                }
            }
            answer = sb.reverse().toString();

            return answer;
        }
    }
}
