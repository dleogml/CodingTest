package programmers.level2;


import java.util.ArrayList;
import java.util.HashMap;

// 압축
// LZW(Lempel-Ziv-Welch) 압축을 구현한다
/*
1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
5. 단계 2로 돌아간다.
 */
// 압축 알고리즘이 영문 대문자만 처리한다고 할 때, 사전은 다음과 같이 초기화된다
// 색인 번호	1	2	3	...	24	25	26
// 단어   	A	B	C	...	X	Y	Z
/*
예를 들어 입력으로 KAKAO가 들어온다고 하자.

1. 현재 사전에는 KAKAO의 첫 글자 K는 등록되어 있으나, 두 번째 글자까지인 KA는 없으므로, 첫 글자 K에 해당하는 색인 번호 11을 출력하고, 다음 글자인 A를 포함한 KA를 사전에 27 번째로 등록한다.
2. 두 번째 글자 A는 사전에 있으나, 세 번째 글자까지인 AK는 사전에 없으므로, A의 색인 번호 1을 출력하고, AK를 사전에 28 번째로 등록한다.
3. 세 번째 글자에서 시작하는 KA가 사전에 있으므로, KA에 해당하는 색인 번호 27을 출력하고, 다음 글자 O를 포함한 KAO를 29 번째로 등록한다.
4. 마지막으로 처리되지 않은 글자 O에 해당하는 색인 번호 15를 출력한다.
 */
public class Compression {
    class Solution {
        public int[] solution(String msg) {
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();

            // 사전에 A부터 Z까지 저장
            // 알파벳은 26개이고 아스키코드로 A = 65 , Z = 90 이다
            for(int i = 1; i < 27; i++) {
                char alpha = (char) (64+i);
                map.put(String.valueOf(alpha), i);
            }

            //
            for(int i = 0; i < msg.length(); i++) {
                String key = msg.charAt(i) + "";
                int index = i + 1;

                while(index <= msg.length()) {
                    if(index == msg.length()) {
                        list.add(map.get(msg.substring(i)));
                        i = index;
                        break;
                    }

                    // 글자 하나와 다음글자를 w+c로 저장
                    String nextKey = msg.substring(i, index+1);

                    // 그 글자가 있으면 더 늘림
                    if(map.containsKey(nextKey)) {
                        index++;

                    // 없으면 사전에 새롭게 추가하며
                    // w의 색인번호를 list에 더해줌
                    } else {
                        key = msg.substring(i, index);
                        list.add(map.get(key));
                        map.put(nextKey, map.size()+1);
                        i = index-1;
                        break;
                    }
                }
            }

            // 색인번호를 순서대로 정답 배열에 넣어줌
            int[] answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}
