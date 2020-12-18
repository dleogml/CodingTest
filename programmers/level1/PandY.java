package programmers.level1;

// 문자열 내 p와 y의 개수
// 문자열은 대문자와 소문자가 섞여있고 이 중에
// p와 y의 개수를 비교해서 같다면 true, 다르면 false를 리턴
// 이 때 대소문자는 구분하지 않음
// 만약 p와 y가 하나도 없다면 자동으로 true 리턴
public class PandY {
    class Solution {
        boolean solution(String s) {
            boolean answer = true;

            // p와 y의 개수를 셀 int 생성
            int pCount = 0;
            int yCount = 0;

            // 대소문자는 구분하지 않으므로 전부 소문자로 변환
            String s2 = s.toLowerCase();

            // 갯수를 셀 for문
            // ''는 char ""는 string으로 인식
            for(int i=0; i < s.length(); i++) {
                if(s2.charAt(i) == 'p') {
                    pCount++;
                }
                else if (s2.charAt(i) == 'y') {
                    yCount++;
                }
            }

            // 같지 않다면 false
            // 초기값이 true이기 때문에 다른 조건은 없어도 됨
            // 둘다 없어서 0인 경우도 같은 경우고 이러면 자연스레 true가 됨
            if(pCount != yCount) {
                answer = false;
            }

            return answer;
        }
    }

    //다른 사람의 풀이
    //람다식을 활용한 풀이
    class Solution2 {
        boolean solution(String s) {
            s = s.toUpperCase();

            return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
        }
    }
}
