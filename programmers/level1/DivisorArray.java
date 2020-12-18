package programmers.level1;

import java.util.*;

//나누어 떨어지는 숫자 배열
//나누어 떨어지는 숫자는 오름차순 정렬하여 리턴하고
//만약에 아무것도 나누어 떨어지는게 없다면 -1을 리턴
public class DivisorArray {
    class Solution {
        public int[] solution(int[] arr, int divisor) {
            int[] answer = {};
            ArrayList<Integer> ans = new ArrayList<Integer>();

            // divisor로 나눠서 떨어지는 숫자를 저장
            for(int i=0; i<arr.length; i++) {
                if(arr[i] % divisor ==0) ans.add(arr[i]);
            }

            // 아무것도 나누어 떨어지는게 없다면(즉, 비었다면)
            // -1을 리턴
            if(ans.isEmpty()) {
                ans.add(-1);
            }

            // answer크기를 설정
            answer = new int[ans.size()];

            // 임시배열에서 리턴할 배열에 하나씩 저장
            for(int i=0; i<ans.size(); i++) {
                answer[i] = ans.get(i);
            }

            // 배열 오름차순으로 정렬
            Arrays.sort(answer);

            return answer;

        }
    }
}
