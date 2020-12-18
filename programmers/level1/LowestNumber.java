package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

// 제일 작은 수 제거하기
// 주어진 배열 중에서 가장 작은 수를 제거해서 다시 리턴
// 배열에 하나의 값만 있다면 -1을 담은 배열을 리턴
public class LowestNumber {
    class Solution {
        public int[] solution(int[] arr) {
            int[] answer = {};


            ArrayList<Integer> arr2 = new ArrayList<Integer>();

            // 배열의 길이가 하나 이하면 -1을 담은 배열 리턴
            if(arr.length <=1) {
                return new int[] {-1};
            }

            // 새로운 배열에 기존 배열값 넣기
            for(int i=0; i<arr.length; i++) {
                arr2.add(arr[i]);
            }

            // 최소값
            int min = Collections.min(arr2);

            // 최소값의 인덱스
            int index_of_min = arr2.indexOf(min);

            // 최소값 삭제
            arr2.remove(index_of_min);

            answer = new int[arr2.size()];

            for(int i=0; i<arr2.size(); i++) {
                answer[i] = arr2.get(i);
            }

            return answer;
        }
    }
}
