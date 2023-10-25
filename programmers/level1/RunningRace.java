package programmers.level1;

import java.util.*;

// 달리기 경주
public class RunningRace {
    // 그냥 단순히 이중 for문을 이용
    // 당연히 일부 테스트케이스는 통과하나 값이 커졌을 때 시간초과로 실패
    class Solution {
        public String[] solution(String[] players, String[] callings) {
            String[] answer = new String[players.length];

            for(int i = 0; i < callings.length; i++) {
                for(int j = 0; j < players.length; j++) {
                    if(callings[i].equals(players[j])) {
                        String temp = players[j-1];
                        players[j-1] = players[j];
                        players[j] = temp;
                        break;
                    }
                }
            }

            answer = players;

            return answer;
        }

    }

    // 두번째 방법
    // 이름의 위치(인덱스)를 해쉬맵에 저장
    // 이중 for문없이 바로 추월한 사람과 추월당한 사람의 위치를 찾아내 바꾸고 해쉬맵에도 업데이트
    // 시간초과없이 성공
    class Solution2 {
        public String[] solution(String[] players, String[] callings) {
            String[] answer = new String[players.length];

            HashMap<String, Integer> map = new HashMap<>(players.length);

            for(int i = 0; i < players.length; i++) {
                map.put(players[i], i);
            }

            for(int i = 0; i < callings.length; i++) {
                String temp = callings[i]; // 추월한사람 kai
                int index = map.get(callings[i]); // kai의 첫번째위치 3
                String overtake = players[index-1]; // 추월당한 사람
                System.out.println("추월자 : " + temp + "위치 : " + index + "추월당함 : " + overtake);
                map.put(temp, (index-1)); // 앞으로 한칸 땡기고
                map.put(overtake, index); // 뒤로 한칸 밀림
                players[index-1] = temp;
                players[index] = overtake;
            }

            // Iterator<String> keys = map.keySet().iterator();
            // while(keys.hasNext()) {
            //     String key = keys.next();
            //     answer[map.get(key)] = key;
            // }

            return players;
        }

    }
}
