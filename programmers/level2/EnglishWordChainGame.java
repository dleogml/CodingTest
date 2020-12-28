package programmers.level2;

import java.util.ArrayList;

// 영어 끝말잇기
// 끝말잇기 규칙은 다음과 같다
/*
1. 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
2. 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
3. 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
4. 이전에 등장했던 단어는 사용할 수 없습니다.
5. 한 글자인 단어는 인정되지 않습니다.
*/
// 사람의 수 n과 끝말잇기 한 단어들이 나열됬을 때
// 몇번째 사람이 몇번째 차례에 탈락되었는지를 리턴
public class EnglishWordChainGame {
    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int [2];
            ArrayList<String> list = new ArrayList<>();

            for(int i=0; i<words.length; i++) {
                // 앞에단어의 끝이랑 뒤에 단어의 시작이 맞지 않을 경우
                if(i != 0 && !list.get(i-1).substring(list.get(i-1).length() - 1).equals(words[i].substring(0,1))) {
                    answer[0] = (i%n) + 1;
                    answer[1] = (i/n) + 1;
                    break;
                }
                // 이미 있는 단어를 말한 경우
                if(!list.contains(words[i])) {
                    list.add(words[i]);
                }
                else {
                    answer[0] = (i%n) + 1;
                    answer[1] = (i/n) + 1;
                    break;
                }
            }

            return answer;
        }
    }
}
