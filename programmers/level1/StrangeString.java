package programmers.level1;

// 이상한 문자 만들기
// 짝수번째는 대문자로, 홀수번째는 소문자로 변환하여 리턴
// 단어별로 짝수번째, 홀수번쨰 인덱스로 판별
// 공백도 포함하여야 하고 0번째 인덱스는 짝수로 취급
public class StrangeString {
    class Solution {
        public String solution(String s) {
            String answer = "";

            // 하나하나쪼개서 문자열배열에 넣음
            String str[] = s.split("");
            String space = " ";
            int cnt = 0;

            // 공백이면 0으로 초기화, 그래야 다음단어도 인덱스0부터 계산가능
            // cnt가 짝수면 대문자, 홀수면 소문자
            for(int i = 0; i < str.length; i++){
                if(str[i].equals(space)){
                    cnt = 0;
                }else{
                    if(cnt % 2 == 0){
                        cnt++;
                        str[i] = str[i].toUpperCase();
                    }else{
                        cnt++;
                        str[i] = str[i].toLowerCase();
                    }
                }
                answer += str[i];
            }
            return answer;

        }
    }

    // 다른 사람의 풀이, 삼항연산자를 이용
   class Solution2 {
        public String solution(String s) {

            String answer = "";
            int cnt = 0;
            String[] array = s.split("");

            for(String ss : array) {
                cnt = ss.contains(" ") ? 0 : cnt + 1;
                answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
            }
            return answer;
        }
    }
}
