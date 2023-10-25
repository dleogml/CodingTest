package programmers.level1;

// 약수의 개수와 덧셈
/*
두 정수 left와 right가 주어지고 두 수를 포함한 left와 right사이의
모든 수 들의 약수의 개수에 따라 짝수면 양수, 홀수면 음수로 하여
모든 수를 더한 값을 리턴
*/
public class DivisorCountAndSum {
    class Solution {
        public int solution(int left, int right) {
            int len = right - left + 1;
            int answer = 0;
            int [] arr = new int [len];

            for(int i=left; i<right + 1; i++) {
                int cnt = 0;
                for(int j=1; j<i+1; j++) {
                    if(i % j == 0) {
                        cnt++;
                    }
                }
                if(cnt % 2 == 0) {
                    arr[i-left] = 1;
                }
                else {
                    arr[i-left] = -1;
                }
            }
            for(int i=0; i<len; i++) {
                answer += ((left + i) * arr[i]);
            }

            return answer;
        }
    }
}
