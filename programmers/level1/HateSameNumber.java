package programmers.level1;

import java.util.ArrayList;

// 같은 숫자는 싫어
// 배열이 주어지고 중복된 숫자는 제거되어 리턴하는데
// 이 때 인접한 중복된 숫자만 제거되어 하나로 표시
// 그리고 순서는 그대로(오름차순이나 내림차순 x)
// ex)[1,1,3,3,0,1,1] => [1,3,0,1]
// 배열안의 수는 0부터 9, 배열의 크기는 최대 1,000,000
public class HateSameNumber {
    public class Solution {
        public int[] solution(int []arr) {
            int[] answer = {};

            ArrayList<Integer> list = new ArrayList<>();

            //배열값을 list에 넣어주는데
            //들어갈 값이 이전 값과 같다면 continue로 패스
            for(int i=0; i<arr.length; i++) {
                if(i>=1 && arr[i-1] == arr[i]) continue;
                list.add(arr[i]);
            }
            /* 값비교 다른방법
            - 0부터 9까지의 수이기 때문에 10으로 설정
            - 첫 값은 무조건 들어가고 preNum에 첫 값을 넣어서
            - 이 후 값들이 if문에 걸려 중복되면
            - 자연스레 배열에 들어가지 않게 됨
            int preNum = 10;
            for(int num : arr) {
                if(preNum != num)
                    list.add(num);
                preNum = num;
            }
            */

            answer = new int[list.size()];

            for(int i=0; i<answer.length; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}
