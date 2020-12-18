package programmers.level1;

// 서울에서 김서방 찾기
// 배열중에 Kim을 찾고 해당 인덱스를 알려주는
// 김서방은 x에 있다 라는 문구를 리턴
public class SeoulKim {
    class Solution {
        public String solution(String[] seoul) {
            String answer = "";

            // 배열길이만큼 for문을 돌리고
            // 배열값 중에 Kim인 값을 찾으면 answer값에 문구로 넣어 완성하고
            // for문 종료
            // 이때 == 대신 .equals를 사용해야함
            // 숫자가 아닌 문자를 비교할 때는 해시코드 주소가 다르기 때문에
            // equals를 사용해야 한다!
            for(int i=0; i<seoul.length; i++) {
                if(seoul[i].equals("Kim")) {
                    answer = "김서방은 " + i + "에 있다";
                    break;
                }
            }

            return answer;
        }
    }
}
