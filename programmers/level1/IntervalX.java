package programmers.level1;

// x만큼 간격이 있는 n개의 숫자
// x부터 시작해서 x만큼 증가하며 n개의 숫자를 배열로 리턴
public class IntervalX {
    class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            // int의 범위를 넘어갈 경우도 생각해서 long으로 바꿈
            long x2 = x;

            // 결국 x의 배수를 n개만큼만 저장하는 것
            for(int i=0; i<n; i++) {
                answer[i] = x2 * (i + 1);
            }

            return answer;
        }
    }
}
