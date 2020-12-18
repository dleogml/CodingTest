package programmers.level1;

// 핸드폰 번호 가리기
// 전화번호가 담긴 문자열이 주어졌을 때 끝에 4개만 남기고
// 나머지는 *로 표시해서 리턴
public class CellularPhone {
    class Solution {
        public String solution(String phone_number) {
            String answer = "";
            String[] number = new String[phone_number.length()];

            for(int i=0; i<phone_number.length(); i++) {
                if(i<phone_number.length()-4) {
                    number[i] = "*";
                }
                else {
                    number[i] = phone_number.substring(i,i+1);
                }
            }
            for(int i=0; i<number.length; i++) {
                answer += number[i];
            }

            return answer;
        }
    }
    // 다른 사람의 풀이
    // char로 바꾸면서 char배열에 넣고 뒤에 4개를 뺀 나머지를 *로 바꾸고
    // 다시 string으로 바꿈
    class Solution2 {
        public String solution(String phone_number) {
            char[] ch = phone_number.toCharArray();
            for(int i = 0; i < ch.length - 4; i ++){
                ch[i] = '*';
            }
            return String.valueOf(ch);
        }
    }
}
