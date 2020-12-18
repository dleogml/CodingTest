package programmers.level1;

// 하샤드 수
// x가 주어졌을때 x의 각 자릿수를 더한수로 x가 나뉘어 진다면 x는 하샤드 수
// ex)x = 18 이면 자릿수를 더하면 1+8=9니까 18/9=2 이므로 18은 하샤드 수
public class HarshadNumber {
    class Solution {
        public boolean solution(int x) {
            boolean answer = true;
            int sum = 0;
            int y = x;

            while(x != 0) {
                sum += x%10;
                x = x/10;
            }

            if(y%sum != 0) {
                answer = false;
            }

            return answer;
        }
    }
}
