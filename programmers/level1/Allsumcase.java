package programmers.level1;

import java.util.*;
// 두개 뽑아서 더하기
// numbers에 숫자가 주어지면 두개의 수를 더해
// 숫자의 합을 중복없이 오름차순으로 리턴
public class Allsumcase {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = {};
            HashSet<Integer> sum = new HashSet<>();
            //경우의 수를 모두 더함
            //hashset이므로 중복값은 자동으로 제거
            for(int i=0; i<numbers.length; i++) {
                for(int j=i+1; j<numbers.length; j++) {
                    sum.add(numbers[i] + numbers[j]);
                }
            }
            //값을 옮김
            ArrayList<Integer> sum2 = new ArrayList<>(sum);

            //리턴할 answer크기 설정
            answer = new int[sum2.size()];

            //answer에 차례대로 값넣기
            for(int i=0; i<sum2.size(); i++) {
                answer[i] = sum2.get(i);
            }

            //오름차순정렬
            Arrays.sort(answer);

            return answer;
        }
    }
}
