package programmers.level1;

// 수박수박수박수박수박수?
// n이 주어지면 주어진 길이만큼의 string을 출력하는데 패턴은
// 홀수자리엔 "수", 짝수자리엔 "박" 리턴
public class WaterMelon {
    class Solution {
        public String solution(int n) {
            String answer = "";
            String[] list = new String[n];

            // 인덱스 기준으로 하기 때문에 짝수일 때 "수"인것 같지만 실제론 홀수자리
            for(int i=0; i<n; i++) {
                if(i%2 == 0) {
                    list[i] = "수";
                }
                else {
                    list[i] = "박";
                }
            }

            // 하나의 단어로 만듬듬
           for(int i=0; i<n; i++) {
                answer += list[i];
            }

            return answer;
        }
    }
}
