package programmers.level1;

// 나머지가 1이 되는 수 찾기
public class FindRemainderOne {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int i = 1;
            while(i < n) {
                if(n % i == 1) {
                    answer = i;
                    break;
                }
                i++;
            }


            return answer;
        }
    }
}
