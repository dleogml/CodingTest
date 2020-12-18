package programmers.level2;

import java.util.Arrays;

// H-Index
// 어떤 과학자가 발표한 논문 n편 중에서 h번 이상 인용된 논문이고 h편 이상이고
// 나머지 논문이 h번 이하 인용되었다면 h의 최대값이 이 과학자의 H-Index이다.
public class HIndex {
    // 오름차순으로 정렬한다음에
    // 해당값이 h 이상이라면 그 값이 h-index가 된다
    class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            Arrays.sort(citations);

            for(int i=0; i<citations.length; i++) {
                int h = citations.length - i;
                if(citations[i] >= h) {
                    answer = h;
                    break;
                }
            }

            return answer;
        }
    }
}
