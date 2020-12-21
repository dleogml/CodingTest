package programmers.level2;

// 이진 변환 반복하기
// x라는 문자가 주어지면 두가지를 반복한다
// 1.x의 모든 0을 제거한다
// 2.0이 제거된 x의 길이를 c라고하면 c를 이진수로 바꿔 이를 새로운 x로 한다
// 이러한 과정 한번을 한 회차라고 했을 때
// 최종적으로 1이 될 때까지의 회차와 그동안 없앤 0의 모든 갯수를 길이가 2인 배열로 리턴
public class BinaryRepeat {
    class Solution {
        public int[] solution(String s) {
            int[] answer = {};
            answer = new int [2];

            int cnt = 0;
            int cntZero = 0;

            while(!s.equals("1")) {
                int cntOne = 0;
                for(int i=0; i<s.length(); i++) {
                    if(s.charAt(i) == '0') {
                        cntZero++;
                    }
                    else {
                        cntOne++;
                    }
                }
                s = Integer.toBinaryString(cntOne);
                cnt++;
            }
            answer[0] = cnt;
            answer[1] = cntZero;

            return answer;
        }
    }
}
