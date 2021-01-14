package programmers.level2;

// N진수 게임
// 차례대로 숫자를 말하는 게임을 한다.
// 10이상인 경우 한사람씩 나눠서 이야기한다 1, 0, 1, 1, ...
// 여러가지 진수로 이러한 게임을 진행할 때
// 진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다
// 튜브가 말해야 하는 숫자 t개를 공백 없이 차례대로 나타낸 문자열로 리턴
// 단, 10~15는 각각 대문자 A~F로 출력한다.
// 미리 구할 숫자의 갯수는 앞에서 부터
public class BaseNGame {
    class Solution {
        public String solution(int n, int t, int m, int p) {
            StringBuilder answer = new StringBuilder("");
            // 0부터 시작하기 때문에 0을 미리 넣어놓는다.
            StringBuilder str = new StringBuilder("0");

            // 16진수일 경우에 바꿔줄 알파벳들
            String[] alpaForMoreThan10 = {"A", "B", "C", "D", "E", "F"};

            int num = 1;

            // 미리 구할 숫자의 갯수 * 인원의 길이까지 답이 나올만큼 반복한다.
            while (str.length() - 1 < t * m) {

                StringBuilder sub = new StringBuilder("");
                // 몫, 1부터 시작
                int quot = num;
                // 나머지
                int remain;

                while (quot > 0) {
                    remain = quot % n;
                    quot = quot / n;

                    // 알파벳으로 바꿔야 하는 경우
                    if (remain >= 10 && remain <= 15) {
                        sub.append(alpaForMoreThan10[remain-10]);
                    } else {
                        sub.append(remain);
                    }
                }
                str.append(sub.reverse());
                num++;
            }

            int tubePlace = p;

            for (int i = 0; i < t; i++) {
                answer.append(str.charAt(tubePlace - 1));
                // 튜브 차례
                tubePlace += m;
            }

            return answer.toString();
        }
    }
}
