package programmers.level1;

import java.util.*;

// 가장 가까운 글자
public class ClosestString {
    // 내가 푼 풀이
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int [s.length()];
            HashSet<String> set = new HashSet<>();

            for(int i = 0; i < s.length(); i++) {
                String temp = Character.toString(s.charAt(i));
                if(!set.contains(temp)) {
                    set.add(temp);
                    answer[i] = -1;
                } else {
                    int count = 1;
                    for(int j = i - 1; j >= 0; j--) {
                        String same = Character.toString(s.charAt(j));
                        if(same.equals(temp)) {
                            answer[i] = count;
                            break;
                        }
                        count++;
                    }
                }
            }

            return answer;
        }
    }

    // 다른 사람의 풀이
    // getOrDefault 메소드활용
    // getOrDefault(키값, 키에 해당하는 값이 없을때 해당 키에 넣고 리턴할 값)
    // 키에 값이 있다 => 기존value리턴
    // 키에 값이 없다 => 두번째 매개변수에 있는 값을 저장하고 리턴
    /*
    키에 값이 없으면 map.getOrDefault(ch, i+1) => i + 1 이 되고
    answer[i] = i - (i + 1) = -1
    키에 값이 있다면 map.getOrDefault(ch, i+1) => -1 + 1 이 되고
    answer[i] = i - 키값
    map에는 각 글자에 인덱스 위치를 담고 있고
    이미 있는게 나오면 현재 인덱스로 갱신
    */
    class Solution2 {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0; i<s.length();i++){
                char ch = s.charAt(i);
                answer[i] = i - map.getOrDefault(ch,i+1);
                map.put(ch,i);
            }
            return answer;
        }
    }
}
