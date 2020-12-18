package programmers.level1;
import java.util.*;

//k번째 수
public class KsNumber {


    class Solution {
        //copyOfRange(복사할 배열, 복사할배열의 시작 인덱스, 복사할배열의 끝 인덱스의 다음값을 넣어줘야함)
        // 문제에서의 [2,5,3] 값을 copyOfRange를 알고리즘을 통해 복사하면
        // 인덱스 1부터 인덱스 5가아닌
        // 인덱스 1부터 인덱스 4까지 복사됨
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int [commands.length];
            for(int i=0; i<commands.length; i++) {
                int [] cut = Arrays.copyOfRange(array, (commands[i][0])-1, (commands[i][1]));
                Arrays.sort(cut);
                answer[i] = cut[(commands[i][2])-1];

            }

            return answer;
        }
    }
    
}
