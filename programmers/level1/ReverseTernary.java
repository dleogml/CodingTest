package programmers.level1;

import java.lang.*;

// 3진법 뒤집기
// 10진법의 수를 3진법으로 만든뒤
// 뒤집은 후 다시 10진법으로 반환
public class ReverseTernary {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            //예를들어 45를 StringBuilder를 통해 3진법으로 변환하면
            //0021
            StringBuilder three = new StringBuilder();
            while(n != 0) {
                three.append(n%3);
                n /= 3;
            }

            //배열에 뒤집어서 넣으면 1200
            //index[0] = 1, index[1] = 2
            String[] threereverse = three.reverse().toString().split("");

            //다시 10진법으로 변환
            //앞에서부터 순서대로 3의 제곱승이 곱하져서 나오므로 배열에 넣을때 뒤집어서 넣었음
            for(int i=0; i< threereverse.length; i++) {
                answer += Integer.parseInt(threereverse[i]) * Math.pow(3, i);
            }

            return answer;
        }
    }
}
