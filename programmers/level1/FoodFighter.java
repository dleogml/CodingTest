package programmers.level1;

// 푸드 파이터 대회

public class FoodFighter {
    class Solution {
        public String solution(int[] food) {
            String answer = "";

            // StringBuffer sb = new StringBuffer(str);
            // String reverse = sb.reverse().toString();
            // 첫번째는 물, 두번째부터 칼로리작은순으로 음식갯수
        /*
        String s = "abc";
        s = s.repeat(10);
        */
            for(int i = 1; i < food.length; i++) {
                food[i] = food[i] / 2;
                String tmp = Integer.toString(i);
                //tmp = tmp.repeat(food[i]);
                answer += tmp;
            }

            StringBuffer sb = new StringBuffer(answer);
            String reverse = sb.reverse().toString();

            answer = answer + "0" + reverse;


            return answer;
        }
    }
}
