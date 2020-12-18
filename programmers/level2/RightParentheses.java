package programmers.level2;

// 올바른 괄호
// 괄호가 맞게 짝지어져 있다면 true, 아니라면 false를 리턴
public class RightParentheses {
    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            int ans = 0;

            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '(') {
                    ans++;
                }
                else {
                    ans--;
                }
                // 마이너스가 된다면 올바르지 않기 때문에 false와 for문 중단
                if(ans < 0) {
                    answer = false;
                    break;
                }
            }
            // 플러스로 나오는 경우도 올바르지 않기 때문에 false
            if(ans != 0) {
                answer = false;
            }

            return answer;
        }
    }
}
