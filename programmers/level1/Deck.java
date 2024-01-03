package programmers.level1;

import java.util.Stack;

/*
코니는 영어 단어가 적힌 카드 뭉치 두 개를 선물로 받았습니다. 코니는 다음과 같은 규칙으로 카드에 적힌 단어들을
사용해 원하는 순서의 단어 배열을 만들 수 있는지 알고 싶습니다.
- 원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
- 한 번 사용한 카드는 다시 사용할 수 없습니다.
- 카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
- 기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.

문자열로 이루어진 배열 cards1, cards2와 원하는 단어 배열 goal이 매개변수로 주어질 때,
cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를, 만들 수 없다면 "No"를 return하는
solution 함수를 완성해주세요.

a. 1 ≤ cards1의 길이, cards2의 길이 ≤ 10
- 1 ≤ cards1[i]의 길이, cards2[i]의 길이 ≤ 10
- cards1과 cards2에는 서로 다른 단어만 존재합니다.
b. 2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이
- 1 ≤ goal[i]의 길이 ≤ 10
- goal의 원소는 cards1과 cards2의 원소들로만 이루어져 있습니다.
c. cards1, cards2, goal의 문자열들은 모두 알파벳 소문자로만 이루어져 있습니다.
*/
// 카드 뭉치
public class Deck {
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "";
            boolean flag = false;

            // 각각의 카드뭉치를 가장 순번이 늦는것부터 스택에 저장
            Stack<String> deck1 = new Stack<>();
            Stack<String> deck2 = new Stack<>();
            for(int i = cards1.length - 1; i >= 0; i--) {
                deck1.push(cards1[i]);
            }
            for(int i = cards2.length - 1; i >= 0; i--) {
                deck2.push(cards2[i]);
            }

            // 목표 문장에 단어들을 하나씩 꺼내서 각 스택과 비교
            // 단어가 있고 그 단어가 가장 위에 있다면(현재 순번이 제일빠름) 해당 단어를 스택에서 제거 후 통과
            // 어느 쪽에도 없다면 그 즉시 루프 종료(불가능)
            for(int i = 0; i < goal.length; i++) {
                if(deck1.contains(goal[i]) && goal[i].equals(deck1.peek())) {
                    flag = true;
                    deck1.pop();
                } else if(deck2.contains(goal[i]) && goal[i].equals(deck2.peek())) {
                    flag = true;
                    deck2.pop();
                } else {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                answer = "Yes";
            } else {
                answer = "No";
            }

            return answer;
        }
    }
    // 다른 사람의 풀이
    // 카드뭉치마다 인덱스를 별도로 두고 해당 단어가 있을 경우에만 증가
    // 적은 코드와 더불어 최소한의 변수와 루프문을 사용한 점이 인상깊다
    class Solution2 {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            int cardIdx1 = 0;
            int cardIdx2 = 0;

            for(int i=0; i<goal.length; i++){
                String target = goal[i];

                if(cardIdx1 < cards1.length && target.equals(cards1[cardIdx1]))
                    cardIdx1 ++;
                else if (cardIdx2 < cards2.length && target.equals(cards2[cardIdx2]))
                    cardIdx2++;
                else
                    return "No";
            }


            return "Yes";
        }
    }
}
