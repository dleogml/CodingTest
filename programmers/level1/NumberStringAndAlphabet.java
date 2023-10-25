package programmers.level1;

// 숫자 문자열과 영단어
/*
다음과 같이 문자열을 숫자로 변경한다

"one4seveneight" → 1478
"23four5six7" → 234567
"1zerotwozero3" → 10203

*/
public class NumberStringAndAlphabet {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            String t = "";

            Character [] divide = new Character[s.length()];
            for(int i=0; i<s.length(); i++) {
                divide[i] = s.charAt(i);
            }

            for(int i=0; i<divide.length; i++) {
                if(divide[i] == 'z') {
                    t += "0";
                    i += 3;
                }
                else if(divide[i] == 'o') {
                    t += "1";
                    i += 2;
                }
                else if(divide[i] == 't') {
                    if(divide[i+1] == 'w') {
                        t += "2";
                        i += 2;
                    }
                    else {
                        t += "3";
                        i += 4;
                    }
                }
                else if(divide[i] == 'f') {
                    if(divide[i+1] == 'o') {
                        t += "4";
                        i += 3;
                    }
                    else {
                        t += "5";
                        i += 3;
                    }
                }
                else if(divide[i] == 's') {
                    if(divide[i+1] == 'i') {
                        t += "6";
                        i += 2;
                    }
                    else {
                        t += "7";
                        i += 4;
                    }
                }
                else if(divide[i] == 'e') {
                    t += "8";
                    i += 4;
                }
                else if(divide[i] == 'n'){
                    t += "9";
                    i += 3;
                }
                else {
                    t += divide[i];
                }
            }

            answer = Integer.parseInt(t);

            return answer;
        }
    }

    // 다른 사람의 풀이
    // replaceAll을 이용해서 해당단어를 숫자문자열로 바꾼다
    class Solution2 {
        public int solution(String s) {
            int answer = 0;
            StringBuilder sb = new StringBuilder("");
            int len = s.length();
            String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
            String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

            for(int i=0; i<10; i++){
                s = s.replaceAll(alphabets[i],digits[i]);
            }

            return Integer.parseInt(s);
        }
    }
}
