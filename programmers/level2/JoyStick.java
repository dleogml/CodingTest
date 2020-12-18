package programmers.level2;

// 조이스틱
// 글자수만큼 A로 가득차있고 조이스틱을 움직여 원하는 글자로 바꿀 때
// 조이스틱을 움직인 횟수를 리턴
// 위 : 다음 알파벳 / 아래 : 이전 알파벳
// 왼쪽 : 커서를 왼쪽으로 이동(첫번째에서 이동하면 맨뒤로 감)
// 오른쪽 : 커서를 오른쪽으로 이동
// ex)만들어야 하는 name이 JEROEN 이라면
// 시작은 AAAAAA
public class JoyStick {
    class Solution {
        public int solution(String name) {
            int answer = 0;
            int len = name.length();

            // A부터 순차적으로 갔을때와 뒤로돌아 Z부터 갔을때
            // 중간이 N이기 때문에 경우를 나눠서 계산
            for(int i=0; i<len; i++) {
                if(name.charAt(i) <= 'N' ) {
                    answer += name.charAt(i) - 'A';
                }
                else {
                    answer += 'Z' - name.charAt(i) + 1;
                }
            }
            // 알파벳변환말고도 다음알파벳을 변환하기 위해 이동해야 하는 레버수를 계산해야 함
            // 만약 뒤로 도는게 더 짧지 않아 순차적으로 이동한다면 최소 레버수는 길이 - 1
            int minMove = name.length() - 1;

            // A가 연속적으로 얼마나 있는지를 계산산
           for(int i = 0 ; i < name.length() ; i++) {
                if(name.charAt(i) != 'A') {
                    int next = i+1;
                    while(next < name.length() && name.charAt(next) == 'A') {
                        next++;
                    }
                    int move = 2 * i + name.length() - next;
                    minMove = Math.min(move, minMove);
                }
            }
            answer = answer + minMove;

            return answer;
        }
    }
}
