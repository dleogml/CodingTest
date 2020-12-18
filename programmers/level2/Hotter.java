package programmers.level2;


import java.util.PriorityQueue;

// 더 맵게
// 모든 음식의 스코빌 지수를 K이상으로 만들어야 한다
// 섞은 음식의 스코빌 지수 = 가장 안 매운 음식의 스코빌 + ( 두번째로 안 매운 음식의 스코빌 * 2 )
// 이렇게 두 음식을 섞어서 새로운 음식을 만들고
// 모든 음식이 K이상의 스코빌 지수를 갖게 되었다면 섞은 횟수를 리턴
// 만약 모든 음식을 K이상으로 만들 수 없다면 -1을 리턴
public class Hotter {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            // 해법은 우선순위 큐를 쓰는 것이였다
            // 기본적으로 우선순위 큐를 만들면 숫자가 낮은 순으로 우선순위가 높고
            // 새로운 값을 넣어도 우선순위로 알아서 정렬이 된다
            PriorityQueue<Integer> queue = new PriorityQueue();

            // 배열의 값을 큐에 넣어줌
            for (int scov : scoville) {
                queue.offer(scov);
            }

            // 큐의 맨앞에 값이 K미만일경우(큐의 최소값이 K보다 낮으므로 문제의 조건 충족x) 실행
            while (queue.peek() < K) {
                // K미만인 값 하나만 남았다면 더 이상 스코빌지수를 높일 수 없다(두개를 섞어야 하므로)
                if (queue.size() == 1) {
                    return -1;
                }
                // 차례대로 값을 추출
                // 우선순위 큐이기 때문에 앞에나온 a가 b보다 적다
                int a = queue.poll();
                int b = queue.poll();


                int result = a + (b * 2);

                // 계산한 값을 다시 넣어줌
                queue.offer(result);
                // 이렇게 한번 섞을 때마다 횟수하나씩 증가
                answer ++;
            }
            return answer;
        }
    }
}
