package programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class ReceiveReport {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            Map<String, HashSet<String>> map = new HashMap<>();
            Map<String, Integer> idxMap = new HashMap<>();

            // 유저별 신고묶음과 유저별로 임의의 인덱스값 설정
            for (int i = 0; i < id_list.length; i++) {
                String name = id_list[i];
                map.put(name, new HashSet<>());
                idxMap.put(name, i);
            }

            // 유저신고기록 저장
            for (String s : report) {
                String[] str = s.split(" ");
                // 신고자
                String from = str[0];
                // 신고당한사람
                String to = str[1];
                // Key값으로 HashSet가져와 신고한 사람 저장
                map.get(to).add(from);
            }

            for (int i = 0; i < id_list.length; i++) {
                HashSet<String> send = map.get(id_list[i]);
                // 신고횟수(=Hashset의 크기)가 정지횟수이면
                if (send.size() >= k) {
                    // 임의의 인덱스를 이용해서 신고자들이
                    // 받는 이메일수를 증가
                    for (String name : send) {
                        answer[idxMap.get(name)]++;
                    }
                }
            }
            return answer;
        }
    }
    // 다른사람의 풀이
    // 스트림을 활용한 풀이
    class Solution2 {
        public int[] solution(String[] id_list, String[] report, int k) {
            List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
            HashMap<String, Integer> count = new HashMap<>();
            for (String s : list) {
                String target = s.split(" ")[1];
                count.put(target, count.getOrDefault(target, 0) + 1);
            }

            return Arrays.stream(id_list).map(_user -> {
                final String user = _user;
                List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
                return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
            }).mapToInt(Long::intValue).toArray();
        }
    }
}
