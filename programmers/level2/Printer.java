package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// 프린터
// 어떠한 문서가 주어지면 인쇄 대기목록을 열어 이 문서보다 높은 우선순위의 문서가 있다면
// 맨 뒤로 보내고 그렇지 않으면 인쇄하는 프린터를 만든다
// 우선순위가 담긴 배열이 주어지고 내가 요청한 문서의 위치(인덱스값)이 주어질 때
// 내가 요청한 문서가 몇번째(그냥 순번, 인덱스값 아님)로 출력되는지 리턴
public class Printer {
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            // 큐를 생성한다
            Queue<Document> q = new LinkedList<>();

            // 큐에 각각의 인덱스(위치)와 우선순위를 담는다
            for(int i=0; i<priorities.length; i++) {
                q.offer(new Document(i, priorities[i]));
            }

            // 큐에 값이 없을때까지
            while(!q.isEmpty()) {
                boolean f = false;
                // 가장 앞에 있는 값의 우선순위
                int j = q.peek().prior;
                // (1)큐 내부의 우선순위 중 가장 앞에 있는 값보다 큰게 있다면 true
                for(Document p : q) {
                    if(j < p.prior) {
                        f = true;
                    }
                }
                // (1)이라면 그 값을 빼서 다시 맨뒤로 넣어줌
                if(f) {
                    q.offer(q.poll());
                }
                else {
                    if(q.poll().location == location) {
                        answer = priorities.length - q.size();
                    }
                }
            }

            return answer;
        }

        // 인쇄문서 클래스를 만든다
        // 인쇄문서마다의 우선순위가 담긴배열을 바탕으로
        // 위치와 우선순위를 같이 담기 위한 목적
        class Document {
            int location;
            int prior;

            Document(int location, int prior) {
                this.location = location;
                this.prior = prior;
            }
        }
    }
}
