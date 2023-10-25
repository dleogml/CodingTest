package programmers.level1;

import java.util.LinkedHashMap;
import java.util.Map;

// 추억점수
public class MemoryScore {
    class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            int photolength = photo.length;
            int[] answer = new int [photolength];

            System.out.println(photolength);

            for(int i = 0; i < photolength; i++) {
                String [] temp = photo[i];
                answer[i] = returnScore(name, yearning, temp);
            }


            return answer;
        }

        public int returnScore(String [] n, int [] y, String [] p) {
            int sum = 0;
            for(int i = 0; i < p.length; i++) {
                for(int j = 0; j < n.length; j++) {
                    if(n[j].equals(p[i])) {
                        sum += y[j];
                        break;
                    }
                }
            }

            return sum;
        }
    }

    // 다른 사람의 풀이
    class Solution2 {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            Map<String, Integer> map = new LinkedHashMap<>();
            for(int i=0;i<name.length;i++){
                map.put(name[i],yearning[i]);
            }
            int[] answer = new int[photo.length];
            for(int i=0;i<photo.length;i++){
                for(int j=0;j<photo[i].length;j++){
                    answer[i] += map.getOrDefault(photo[i][j],0);
                }
            }

            return answer;
        }
    }
}
