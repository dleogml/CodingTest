package programmers.level1;

// 삼총사
// 3개의숫자를 더해서 0이 되는경우를 찾아 갯수를 리턴
public class ThreeMusketeers {
    class Solution {
        public int solution(int[] number) {
            int answer = 0;

            for(int i = 0; i < number.length - 2; i++) {
                int first = number[i];
                for(int j = i+1; j < number.length - 1; j++) {
                    int second = number[j];
                    for(int k = j+1; k < number.length; k++) {
                        if(first + second + number[k] == 0) {
                            answer++;
                        }
                    }
                }
            }

            return answer;
        }
    }
}
