package programmers.level1;

import java.util.Arrays;
import java.util.Collections;

// 문자열 내림차순으로 배치하기
// 문자열을 큰것부터 작은 순으로 리턴
// 대문자가 소문자로
public class StringDescending {
    class Solution {
        public String solution(String s) {
            // char 배열생성
            Character [] arr = new Character [s.length()];
            // 배열에 문자하나씩 넣기
            for(int i=0; i<arr.length; i++) {
                arr[i] = s.charAt(i);
            }

            // 내림차순으로 정렬렬
           Arrays.sort(arr, Collections.reverseOrder());
            // 리턴값 비우고
            s = "";
            // 다시 string 만듬
            for(int i=0; i<arr.length; i++) {
                s += arr[i];
            }
            return s;
        }
    }
}
