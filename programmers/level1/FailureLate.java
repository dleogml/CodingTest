package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

// 실패율
// N은 전체 스테이지 갯수, stages는 사용자별로 현재 클리어하지 못하고 있는 스테이지 단계
// 각 스테이지 별로 실패율을 계산(스테이지 도달했으나 클리어하지못한 사람/ 스테이지에 도달한 사람)
// 실패율을 내림차순으로 정렬해서 스테이지 숫자가 들어있는 배열을 리턴
// 만약 실패율이 같으면 작은 번호의 스테이지가 앞으로 와야 함
// 여러 문제 풀이를 보니 핵심은 스테이지와 실패율을 담을 클래스를 만드는 것
public class FailureLate {
    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            // 전체 인원수
            int player = stages.length;
            // 해당스테이지를 통과하지 못한 사람을 저장할 배열
            int[] noClear = new int[N+2];

            // 스테이지마다 통과못한 사람의 수를 저장
            for(int i=0; i<stages.length; i++) {
                noClear[stages[i]]++;
            }
            // 실패율을 담을 배열 생성
            double[] late =  new double[N+2];

            // 실패율을 계산하여 배열에 넣어줌
            // double로 변환해야 되고 인원수를 감소시키면서 분모조정
            for(int i=1; i<noClear.length; i++) {
                if(player == 0) {
                    late[i] = 0;
                }
                else {
                    late[i] = (double)noClear[i]/player;
                }
                player = player - noClear[i];
            }

            // Stage클래스 배열 생성
            Stage[] stage = new Stage[N];
            // 배열에 스테이지와 실패율을 스테이지 순서대로 담음
            for(int i=0; i<stage.length; i++) {
                stage[i] = new Stage(i+1, late[i+1]);
            }
            // 배열을 실패율이 큰 순서대로 정렬
            Arrays.sort(stage, new Comparator<Stage>() {
                @Override
                public int compare(Stage s1, Stage s2) {
                    if(s1.failure == s2.failure) {
                        return 0;
                    }
                    else if(s1.failure > s2.failure) {
                        return -1;
                    }
                    else {
                        return 1;
                    }
                }
            });
            // 정답 배열에 스테이지만 저장
            for(int i=0; i<answer.length; i++) {
                answer[i] = stage[i].stage;
            }

            return answer;
        }
    }
    // 스테이지와 실패율을 담을 Stage class 생성
    class Stage {
        int stage;
        double failure;
        public Stage(int s, double f) {
            this.stage = s;
            this.failure = f;
        }
    }
}
