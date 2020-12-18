package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나는 트럭
// 다리의 길이, 다리가 견딜 수 있는 무게, 트럭 각각의 무게가 담긴 배열이 주어진다
// 모든 트럭은 1초에 1만큼만 이동하고 모든 트럭이 지날 때 까지 걸리는 시간을 구해서 리턴
public class BridgeTruck {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            Queue<Integer> q = new LinkedList<>();

            // 다리 위에 있는 트럭의 무게합을 표현할 변수
            int max = 0;
            for(int w : truck_weights) {
                while(true) {
                    // 큐가 비었다면 트럭을 넣어준다
                    // max에 트럭의 무게만큼 더해주고
                    // answer 1 증가
                    if(q.isEmpty()) {
                        q.offer(w);
                        max += w;
                        answer++;
                        break;
                    }
                    // 트럭이 다리끝까지 왔을때 빼는 작업
                    // 밑의 경우를 통해 0을 넣음으로서 이동표현
                    else if(q.size() == bridge_length) {
                        max -= q.poll();
                    }
                    // 큐가 비어 있지 않았을 때
                    else {
                        // 이미 있는 트럭과 넣을 트럭의 무게가 다리하중을 넘으면
                        // 0만 넣어주고 answer 증가로 시간의 흐름과 이동을 표현
                        if(max + w > weight) {
                            q.offer(0);
                            answer++;
                        }
                        // 견딜 하중이 있다면
                        // 트럭을 하나 더 넣어주고
                        // max에 새로운 트럭무게만큼 추가
                        else {
                            q.offer(w);
                            max += w;
                            answer++;
                            break;
                        }
                    }
                }
            }
            return answer + bridge_length;
        }
    }
}
