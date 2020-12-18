package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// 기능개발
// 각 기능은 100퍼가 되었을 때 배포할 수 있다
// 100퍼가 되었더라도 앞의 기능이 배포되지 않으면 배포되지 않고
// 앞의 기능이 배포될 때 같이 배포된다
// 작업의 개수와 각 작업의 시작 진도율이 담겨져 있는 배열 progresses와
// 각 작업의 하루마다 쌓이는 작업의 속도를 나타낸 speeds가 주어졌을 때
// 앞에서 부터 기능이 배포될 때 몇개의 기능이 같이 배포되는 지를 배열로 리턴
// 스택이나 큐를 이용해서 푸는게 좋아보인다
// 배포까지 걸리는 시간은 100 - 현재 진도율 = 남은 진도율 인데
// 남은 진도율 / 속도로 나누면 남은 시간이 나온다
// 이때 나눠 떨어지지 않는다면 몫에 +1을 해주면 된다
public class FunctionDevelopment {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> q = new ConcurrentLinkedQueue<Integer>();

            // 배포까지 걸리는 일수를 계산하여 큐에 삽입
            for(int i = 0; i < progresses.length; i++) {
                q.add((100-progresses[i])%speeds[i] == 0? (100 - progresses[i]) / speeds[i]
                        : (100 - progresses[i]) / speeds[i] + 1);
            }

            List<Integer> result = new ArrayList<Integer>();
            // 맨 처음값을 기준
            int standard = q.poll();
            int cnt = 1;
            while(!q.isEmpty()) {
                int num = q.poll();
                if(standard >= num) {
                    cnt++;
                }else {
                    result.add(cnt);
                    cnt = 1;
                    standard = num;
                }
            }
            result.add(cnt);
            int[] answer = new int[result.size()];
            for(int i = 0; i < answer.length; i++) {
                answer[i] = result.get(i);
            }
            return answer;
        }
    }
}
