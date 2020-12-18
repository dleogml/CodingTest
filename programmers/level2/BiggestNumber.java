package programmers.level2;

import java.util.*;

// 가장 큰 수
// numbers에 배열이 주어지면 각각의 숫자를 이어붙인 경우의 수 중에서 가장 큰 수를 String으로 출력
// ex)[6, 10 ,2] 라면 6102, 6210, 1062, 1026, 2610, 2106 중 6210이 가장 큼
public class BiggestNumber {
    // Integer.parseInt 와 Integer.toString 기억하기
    // Comparator와 compareTo를 활용하여 정렬의 우선순위를 만들 수 있다
    // 혹시나 0만 있어서 가장 큰 숫자가 0이면 0 출력
    class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            String[] ans = new String[numbers.length];
            for(int i=0; i<ans.length; i++) {
                ans[i] = Integer.toString(numbers[i]);
            }
            Arrays.sort(ans, new Comparator<String>() {
                @Override
                public int compare(String str1, String str2) {
                    return (str2+str1).compareTo(str1+str2);
                }
            });

            return ans[0].equals("0") ? ans[0] : String.join("", ans);
        }
    }
    // 다른 사람의 풀이
    // 람다식과 compare를 이용하여 완성
    // int를 String으로 바꿀 때 String.valueOf()를 이용
    class Solution2 {
        public String solution(int[] numbers) {
            String answer = "";

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < numbers.length; i++) {
                list.add(numbers[i]);
            }
            Collections.sort(list, (a, b) -> {
                String as = String.valueOf(a), bs = String.valueOf(b);
                return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
            });
            StringBuilder sb = new StringBuilder();
            for(Integer i : list) {
                sb.append(i);
            }
            answer = sb.toString();
            if(answer.charAt(0) == '0') {
                return "0";
            }else {
                return answer;
            }
        }
    }
}
