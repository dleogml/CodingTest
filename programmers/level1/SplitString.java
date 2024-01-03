package programmers.level1;

/*
문자열 s가 입력되었을 때 다음 규칙을 따라서 이 문자열을 여러 문자열로 분해하려고 합니다.
** 규칙 **
- 먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.
- 이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다.
- 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.
- s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 남은 부분이 없다면 종료합니다.
- 만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
문자열 s가 매개변수로 주어질 때, 위 과정과 같이 문자열들로 분해하고, 분해한 문자열의 개수를 return 하는 함수
solution을 완성하세요.

- 1 ≤ s의 길이 ≤ 10,000
- s는 영어 소문자로만 이루어져 있습니다.
*/
// 문자열 나누기
public class SplitString {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            // 먼저 나온 문자의 개수를 세는 xCount와
            // 이와 다른 문자의 개수를 세는 otherCount를 정의
            int xCount = 0;
            int otherCount = 0;
            char c = '-';

            // 루프를 돌리면서 xCount와 otherCount의 숫자를 통해 결과값 찾기
            for(int i = 0; i < s.length(); i++) {
                // 초기화되거나 처음일때
                // x에 해당하는 문자를 저장과 동시에 xCount증가
                if(xCount == 0) {
                    c = s.charAt(i);
                    xCount++;
                // 이미 x가 정해진경우
                } else {
                    char temp = s.charAt(i);
                    // x랑 같은 문자면 xCount증가
                    if(temp == c) {
                        xCount++;
                    // 다른 문자면 otherCount증가
                    } else {
                        otherCount++;
                    }
                }
                // 현재 문자에 대해 판독이 끝나고 x와 x가 아닌 문자의 숫자가
                // 같다면 결과값 증가 후 리셋
                if(xCount == otherCount && xCount != 0) {
                    xCount = 0;
                    otherCount = 0;
                    answer++;
                }
            }
            // 판독할 문자가 충분하지 않은 상태에서 끝나면 나머지부분은
            // 한부분이므로 결과값 1 증가
            if(xCount > 0) {
                answer++;
            }

            return answer;
        }
    }
}
