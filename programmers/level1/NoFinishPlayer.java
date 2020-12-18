package programmers.level1;

import java.util.*;

//완주하지 못한 참가자들
public class NoFinishPlayer {
    class Solution {
        public String solution(String[] participant, String[] completion) {

            Arrays.sort(participant);
            Arrays.sort(completion);
            int i;
            for(i=0; i<completion.length; i++) {
                if(!participant[i].equals(completion[i])) {
                    return participant[i];
                }
            }

            return participant[i];
        }
    }
}
/* 해쉬맵을 이용한 방법

    참가자를 getOrDefault를 이용해서 넣어놓고
    get을 이용해 완주자들 값을 0으로 만들고
    0이 아닌 즉, 완주하지 못한 참가자를 answer값에 저장

*/
//class Solution {
//    public String solution(String[] participant, String[] completion) {
//        String answer = "";
//        HashMap<String, Integer> hm = new HashMap<>();
//        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
//        for (String player : completion) hm.put(player, hm.get(player) - 1);
//
//        for (String key : hm.keySet()) {
//            if (hm.get(key) != 0){
//                answer = key;
//            }
//        }
//        return answer;
//    }
//}
