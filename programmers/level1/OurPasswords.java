package programmers.level1;

// 둘만의 암호
public class OurPasswords {

    // 첫번째 방법
    // skip되서 다시 돌아서 여러번 반복하는 경우를 생각안해서 실패
    class Solution1 {
        public String solution(String s, String skip, int index) {
            String answer = "";
            int [] skips = new int [skip.length()];
            char [] ans = new char [s.length()];

            for(int i = 0; i < skip.length(); i++) {
                int ban = (int)skip.charAt(i);
                skips[i] = ban;
            }

            // a = 97, z = 122
            for(int i = 0; i < s.length(); i++) {
                int c = (int)s.charAt(i);
                int jump = c + index;
                int realJump = 0;
                if(jump > 122) {
                    jump = jump - 122 + 96;
                    // 한바퀴 돌았으므로 나눠서 찾기
                    int aTo = betweenAlphabet(97, jump, skips);
                    int originTo = betweenAlphabet(c, 122, skips);
                    realJump = aTo + originTo + index;
                } else {
                    int originTo = betweenAlphabet(c, jump, skips);
                    realJump = originTo + index;
                }
                c = c + realJump;
                if(c > 122) {
                    c = c - 122 + 96;
                }
                ans[i] = (char)c;
            }

            String str = new String(ans);
            answer = str;

            return answer;
        }

        public int betweenAlphabet(int start, int end, int [] skips) {
            int cnt = 0;
            for(int i = 0; i < skips.length; i++) {
                if(skips[i] <= end && skips[i] >= start) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

    // 두번째 방법
    // skip해야될 곳을 checked에 담아서 아닐경우만 점프횟수를 하나씩 차감
    // 결과는 성공
    class Solution2 {
        public String solution(String s, String skip, int index) {
            String answer = "";
            char [] passwords = new char [s.length()];

            // a = 97, z = 122

            boolean [] checked = new boolean[26];
            for(int i = 0; i < skip.length(); i++) {
                int ban = skip.charAt(i) - 97;
                checked[ban] = true;
            }

            for(int i = 0; i < s.length(); i++) {
                int start = s.charAt(i);
                int count = index;
                while(count > 0) {
                    start += 1;
                    // 알파벳범위 넘어갈경우
                    if(start == 123) {
                        start = 97;
                    }
                    // skip할곳인지 아닌지 판별
                    // 정상적인 곳이면 count감소
                    if(!checked[start-97]) {
                        count -= 1;
                    }
                }
                passwords[i] = (char)start;
            }

            String p = new String(passwords);
            answer = p;

            return answer;
        }
    }

    // 다른 사람의 풀이
    // 삼항연산자로 알파벳을 증가시킴(z일 경우 a로 넘김)
    // 두번째방법처럼 boolean 배열을 만드는게 아니라 true, false를 리턴하는 contains를 활용
    // StringBuilder에다가 하나씩 담은후 String으로 리턴
    class Solution3 {
        public String solution(String s, String skip, int index) {
            StringBuilder answer = new StringBuilder();

            for (char letter : s.toCharArray()) {
                char temp = letter;
                int idx = 0;
                while (idx < index) {
                    temp = temp == 'z' ? 'a' : (char) (temp + 1);
                    if (!skip.contains(String.valueOf(temp))) {
                        idx += 1;
                    }
                }
                answer.append(temp);
            }

            return answer.toString();
        }
    }
}
