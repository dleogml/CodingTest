package programmers.level2;

import java.util.Arrays;

// 최댓값과 최솟값
// 문자열 s는 사이사이 공백으로 구분된 숫자들이 나열된 형태의 문자열이다
// 이 중 최소값과 최댓값을 구해서
// (최솟값)(공백한칸)(최대값) 형태의 문자열로 리턴
public class MaxAndMin {
    class Solution {
        public String solution(String s) {
            String answer = "";
            String [] ans = s.split(" ");
            int [] arr = new int [ans.length];

            for(int i=0; i<arr.length; i++) {
                arr[i] = Integer.parseInt(ans[i]);
            }
            Arrays.sort(arr);

            answer = Integer.toString(arr[0]) + " " + Integer.toString(arr[arr.length-1]);

            return answer;
        }
    }
    // max와 min을 구할 때 첫번째 값으로 초기화 해주고
    // 이후에 값들을 비교해주면서 계속 값을 최신화
    /*
    int min, max, n;
    min = max = Integer.parseInt(tmp[0]);
    for (int i = 1; i < tmp.length; i++) {
            n = Integer.parseInt(tmp[i]);
        if(min > n) min = n;
        if(max < n) max = n;
    }
    */
}
