package programmers.level1;

/*
이 휴대폰 자판은 키의 개수가 1개부터 최대 100개까지 있을 수 있으며, 특정 키를 눌렀을 때 입력되는 문자들도 무작위로 배열되어 있습니다.
또, 같은 문자가 자판 전체에 여러 번 할당된 경우도 있고, 키 하나에 같은 문자가 여러 번 할당된 경우도 있습니다.
심지어 아예 할당되지 않은 경우도 있습니다. 따라서 몇몇 문자열은 작성할 수 없을 수도 있습니다.

이 휴대폰 자판을 이용해 특정 문자열을 작성할 때, 키를 최소 몇 번 눌러야 그 문자열을 작성할 수 있는지 알아보고자 합니다.

1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keymap과 입력하려는 문자열들이 담긴 문자열 배열 targets가 주어질 때,
각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return 하는 solution 함수를 완성해 주세요.

단, 목표 문자열을 작성할 수 없을 때는 -1을 저장합니다.

a. 1 ≤ keymap의 길이 ≤ 100
- 1 ≤ keymap의 원소의 길이 ≤ 100
- keymap[i]는 i + 1번 키를 눌렀을 때 순서대로 바뀌는 문자를 의미합니다.
    - 예를 들어 keymap[0] = "ABACD" 인 경우 1번 키를 한 번 누르면 A, 두 번 누르면 B, 세 번 누르면 A 가 됩니다.
- keymap의 원소의 길이는 서로 다를 수 있습니다.
- keymap의 원소는 알파벳 대문자로만 이루어져 있습니다.
b. 1 ≤ targets의 길이 ≤ 100
- 1 ≤ targets의 원소의 길이 ≤ 100
- targets의 원소는 알파벳 대문자로만 이루어져 있습니다.
*/

// 대충 만든 자판
public class RoughlyKeyboard {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];
            int [] alphabet = new int [26];

            // keymap 있는 모든 알파벳들의 가장 짧은 횟수를 저장
            for(int i = 0; i < keymap.length; i++) {
                String temp = keymap[i];
                for(int j = 0; j < 26; j++) {
                    char c = (char)(j + 65);
                    if(temp.indexOf(c) != -1) {
                        if(alphabet[j] == 0) {
                            alphabet[j] = temp.indexOf(c) + 1;
                        } else {
                            alphabet[j] = Math.min(alphabet[j], temp.indexOf(c) + 1);
                        }
                    }
                }
            }

            // targets에서 하나씩 꺼내서 저장된 횟수값을 더해서 결과배열에 담기
            // 알파벳값이 0이면 해당 알파벳이 없는것이므로 -1로 저장하고 다음 타겟으로 넘어감
            for(int i = 0; i < targets.length; i++) {
                char [] target = targets[i].toCharArray();
                for(int j = 0; j < target.length; j++) {
                    int index = (int)(target[j]) - 65;
                    if(alphabet[index] == 0) {
                        answer[i] = -1;
                        break;
                    }
                    answer[i] += alphabet[index];
                }
            }


            return answer;
        }
    }
}
