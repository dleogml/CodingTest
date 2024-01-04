package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*
"명예의 전당"이라는 TV 프로그램에서는 매일 1명의 가수가 노래를 부르고, 시청자들의 문자 투표수로 가수에게 점수를 부여합니다.
매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에
올려 기념합니다. 즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당에 오르게 됩니다.
k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면, 출연 가수의 점수가
명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.

이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다. 예를 들어, k = 3이고, 7일 동안 진행된 가수의 점수가
[10, 100, 20, 150, 1, 100, 200]이라면, 명예의 전당에서 발표된 점수는 아래의 그림과 같이
[10, 10, 10, 20, 20, 100, 100]입니다.
명예의 전당 목록의 점수의 개수 k, 1일부터 마지막 날까지 출연한 가수들의 점수인 score가 주어졌을 때,
매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성해주세요.

3 ≤ k ≤ 100
- 7 ≤ score의 길이 ≤ 1,000
- 0 ≤ score[i] ≤ 2,000
*/
// 명예의 전당
public class HallOfFame {
    // 나의 풀이
    // 순전히 문제가 원하는 로직대로 코딩한 결과
    class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];

            ArrayList<Integer> list = new ArrayList<>();

            for(int i = 0; i < score.length; i++) {
                if(i >= k) {
                    int presentMin = Collections.min(list);
                    if(presentMin > score[i]) {
                        answer[i] = presentMin;
                    } else {
                        list.remove(Integer.valueOf(presentMin));
                        list.add(score[i]);
                        answer[i] = Collections.min(list);
                    }
                } else {
                    list.add(score[i]);
                    int min = Collections.min(list);
                    answer[i] = min;
                }
            }

            return answer;
        }
    }
    // 우선순위 큐를 이용하면 보다 쉽고 간단하게 구현가능하다
    // 큐에 score값을 넣으면 알아서 정렬이 되고 가장작은값을 결과값배열에 담아준다
    // k개 초과하여 들어갔을 때는 가장 작은 값을 빼주는 장치를 두어 k개초과하여 담기는 문제를 해결
    class Solution2 {
        public int [] solution(int k, int[] score) {
            int [] answer = new int [score.length];

            // 가장 작은값이 앞으로 오는 우선순위큐
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i = 0; i < score.length; i++) {
                pq.add(score[i]);
                if(pq.size() > k) {
                    pq.poll();
                }
                answer[i] = pq.peek();
            }

            return answer;
        }
    }
}
