package programmers.level1;

// 음양 더하기
/*
길이가 같은 absolutes와 signs 배열이 있다
absolutes에는 숫자가 signs에는 boolean값이 있고
signs의 값이 true면 양수, false면 음수로 생각하여
absolutes의 모든 값을 더해 리턴
ex) absolutes = [4, 3, 7] , signs = [true, false, true]
==> 4 - 3 + 7 = 8
*/
public class PlusMinusSum {
    class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;

            for(int i=0; i<absolutes.length; i++) {
                if(signs[i] == true) {
                    answer += absolutes[i];
                }
                else {
                    answer += absolutes[i] * -1;
                }
            }

            return answer;
        }
    }
}
