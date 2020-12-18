package programmers.level1;

// 내적
// a,b 1차원 배열이 두개 주어지고 각각의 인덱스끼리
// 곱한 값들을 더해서 리턴
public class InnerProduct {
    class Solution {
        public int solution(int[] a, int[] b) {
            int answer = 0;

            for(int i=0; i<a.length; i++) {
                answer += a[i]*b[i];
            }

            return answer;
        }
    }
}
