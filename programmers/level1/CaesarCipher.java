package programmers.level1;

// 시저 암호
// 문자 s가 주어지면 n만큼 밀어서 새로운 문자 리턴
// ex)s = z, n = 1이면 리턴은 a
// 아스키코드를 통해 원하는 문자로 변환
// A=65, Z=90, a=97, z=122
public class CaesarCipher {
    class Solution {
        public String solution(String s, int n) {
            String answer = "";

            for(int i=0; i<s.length(); i++) {
                char cipher = s.charAt(i);

                // 더해서 z보다크다면 26을 빼고 n만큼 더해줌
                // 만약 z에서 26을 빼면 A나 a보다 한칸앞이고 이를 z라고 생각
                // z부터 n만큼 밀리면 원하는 문자 출력 가능
                if(cipher >= 'a' && cipher <= 'z') {
                    if(cipher + n > 'z') {
                        answer += (char)(cipher + n - 26);
                    }
                    else {
                        answer += (char)(cipher + n);
                    }
                }
                else if(cipher >= 'A' && cipher <= 'Z') {
                    if(cipher + n > 'Z') {
                        answer += (char)(cipher + n - 26);
                    }
                    else {
                        answer += (char)(cipher + n);
                    }
                }
                else {
                    answer += (char)cipher;
                }

            }
            return answer;
        }
    }
}
