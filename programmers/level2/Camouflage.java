package programmers.level2;

import java.util.HashMap;

// 위장
// clothes 배열에는 각 원소마다 옷이름과 옷의 종류가 담겨져 있다
// 스파이의 의상 경우의 수를 구해야하고 스파이는 최소 한 개의 의상을 입는다
// 핵심은 경우의 수를 구하는 방법이였다
// 옷의 종류와 각 종류마다의 갯수를 이용하면 경우의 수를 구할 수 있다
// 옷의 종류가 3종류이고 각각 3, 4, 2 이런식으로 있다면
// (3 + 1) * (4 + 1) * (2 + 1) - 1 = 59가지이다.
// -1을 하는 이유는 전부 다 입지 않는 경우의 수를 빼야하기 때문
// 문제의 옷의 종류를 가진 2열(인덱스로는 1)을 key값으로 두고 value의 종류마다의 가짓수를
// HashMap의 넣어주고 하나씩 빼면서 계산
public class Camouflage {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;

            HashMap<String, Integer> hm = new HashMap<>();

            for(int i = 0; i < clothes.length; i++) {
                if(hm.get(clothes[i][1]) == null) {
                    hm.put(clothes[i][1], 1);
                }
                else {
                    hm.put(clothes[i][1], hm.get(clothes[i][1]) + 1);
                }
            }

            for(String keys: hm.keySet()) {
                answer *= (hm.get(keys) + 1);
            }

            answer -= 1;

            return answer;
        }
    }
}
