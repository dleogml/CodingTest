package programmers.level2;

// 문자열 압축 2020 카카오 블라인드 채용
// 어떠한 문자가 주어지면 해당문자를 압축한다
// 압축하는 방식의 예시는 aabbaccc => 2a2ba3c
// 이런식으로 같은문자가 반복된 횟수만 적고 문자를 생략한다
// 꼭 한단위일 필요는 없고 abcdabcd라면 2abcd로 줄일수 있다
// 이런식으로 파악해 가장 많이 압축한 경우를 찾아 그때의 길이를 리턴
public class StringCompress {
    class Solution {
        public int solution(String s) {

            int answer = s.length();

            // 가장 크게 줄인다하여도 절반이기 때문에 길이의 절반까지만
            for(int n=1 ; n<=s.length()/2 ; n++) {
                StringBuilder temp = new StringBuilder();

                for(int i=0 ; i<s.length() ; i = i+n) {
                    String word = "";

                    if(i+n >= s.length()) word = s.substring(i, s.length());
                    else word = s.substring(i, i+n);

                    int cnt = 1;
                    StringBuilder sb = new StringBuilder();

                    for(int j=i+n ; j<s.length() ; j=j+n) {
                        String word2 = "";

                        if(j+n >= s.length()) {
                            word2 = s.substring(j, s.length());
                        } else {
                            word2 = s.substring(j, j+n);
                        }

                        if(word.equals(word2)) {
                            cnt++;
                            i = j;
                        } else {
                            break;
                        }
                    }

                    if(cnt == 1) sb.append(word);
                    else sb.append(cnt).append(word);

                    temp.append(sb.toString());
                }

                answer = Math.min(answer, temp.toString().length());
            }

            return answer;
        }
    }
    // 다른 사람의 풀이
    // 재귀함수를 활용
    class Solution2 {
        public int solution(String s) {
            int answer = 0;

            for(int i=1; i<=(s.length()/2)+1; i++){
                int result = getSplitedLength(s, i, 1).length();
                answer = i==1 ? result : (answer>result?result:answer);
            }

            return answer;
        }

        public String getSplitedLength(String s, int n, int repeat){
            if(s.length() < n) return s;
            String result = "";
            String preString = s.substring(0, n);
            String postString = s.substring(n, s.length());

            // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
            if(!postString.startsWith(preString)){
                if(repeat ==1) return result += preString + getSplitedLength(postString, n, 1);
                return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
            }

            return result += getSplitedLength(postString, n, repeat+1);
        }
    }
}
