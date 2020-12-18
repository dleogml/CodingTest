package programmers.level1;

import java.util.Arrays;

// 자연수 뒤집어 배열로 만들기
// 주어진 자연수를 뒤집어 배열 형태로 리턴
// ex) 1243 ==> [3,4,2,1]
public class NaturalNumber {
    class Solution {
        public long solution(long n) {
            long answer = 0;

            // string으로 바꿈
            String num = String.valueOf(n);
            String sum = "";
            char [] arr = new char [num.length()];

            // 배열에 하나씩 저장
            for(int i=0; i<num.length(); i++) {
                arr[i] = num.charAt(i);
            }

            // 오름차순으로 정렬
            Arrays.sort(arr);

            // 큰 수가 뒤에 있기 때문에 뒤에 먼저 더해줌
            for(int i=arr.length - 1; i>=0; i--) {
                sum += arr[i];
            }

            // Long타입으로 변환환
           answer = Long.parseLong(sum);
            return answer;
        }
    }

}
