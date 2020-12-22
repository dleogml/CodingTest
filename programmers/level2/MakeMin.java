package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 최솟값 만들기
// 길이가 같은 2개의 배열이 주어지고
// 각각의 원소를 한번씩 써서 곱하여 다 더한 값을 구할 때
// 이 때의 최솟값을 찾아서 리턴
/* ex) A = [1, 2] , B = [3, 4]
1 * 3 + 2 * 4 = 11
1 * 4 + 2 * 3 = 10

즉 리턴할 값은 10
*/
// 배열 하나는 오름차순, 나머지는 내림차순으로 정리한 후
// 순서대로 곱한 값들을 더하게 되면 가장 작은 값이 된다
public class MakeMin {
    class Solution{
        public int solution(int []A, int []B){
            int answer = 0;
            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0; i<B.length; i++) {
                list.add(B[i]);
            }

            Arrays.sort(A);
            Collections.sort(list, Collections.reverseOrder());

            for(int i=0; i<A.length; i++) {
                answer = answer + A[i] * list.get(i);
            }

            return answer;
        }
    }
}
