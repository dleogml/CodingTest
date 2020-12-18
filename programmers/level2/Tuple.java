package programmers.level2;

import java.util.*;

// 튜플
// 원소들이 담겨져 있는 부분집합이 주어졌을 때
// 해당 원소들의 집합인 튜플을 리턴
// ex) {{2},{2,1},{2,1,3},{2,1,3,4}}
// ==> [2, 1, 3, 4]
// 원소내의 순서는 상관없고 원소간의 순서는 있다
// {2, 1, 3} = {2, 3, 1} 이런식으로 같은 원소이고
// {{1, 2},{2}} != {{1, 2},{1}} 첫번째 원소가 다르므로 다른 튜플 => [2, 1] != [1, 2]
public class Tuple {
    class Solution {
        public int[] solution(String s) {
            int[] answer = {};

            // 주어지는 s가 모두 {{ .... }} 때문에 이만큼을 짤라주고
            // 남은 괄호와 원소간의 콤마를 - 로 바꿔준다
            s = s.substring(2, s.length()-2).replace("},{", "-");

            // - 기준으로 짤라서 하나씩 배열에 넣어준다
            // 2  2,1  2,1,3  이런식으로 들어가게 됨
            // 오름차순으로 정렬
            String [] arr = s.split("-");
            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });

            // 배열의 값을 하나씩 꺼내서 ,로 짤라서 새로운 배열에 넣음
            // list에 중복된 값이 없다면 하나씩 넣어줌
            ArrayList<Integer> list = new ArrayList<>();
            for(String temp : arr) {
                String [] val = temp.split(",");

                for(int i=0 ; i<val.length ; i++) {
                    int num = Integer.valueOf(val[i]);

                    if(!list.contains(num)) {
                        list.add(num);
                    }
                }
            }

            // answer배열에 하나씩 넣어서 리턴
            answer = new int[list.size()];
            for(int i=0 ; i<list.size() ; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }

    // 다른 사람의 풀이
    // HashSet은 중복값을 자동적으로 제거해주는 것을 이용
    // {를 전부 공백으로 만들고 }도 공백으로 만들어준다
    // 이후에 트림을 써서 앞뒤에 공백을 없애주고 남은 건 가운데에 공백,공백 이므로
    // 이를 기준으로 배열에 넣어줌
    class Solution2 {
        public int[] solution(String s) {
            Set<String> set = new HashSet<>();
            String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
            Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
            int[] answer = new int[arr.length];
            int idx = 0;
            for(String s1 : arr) {
                for(String s2 : s1.split(",")) {
                    if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
                }
            }
            return answer;
        }
    }
}
