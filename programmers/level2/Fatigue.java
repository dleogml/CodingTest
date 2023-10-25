package programmers.level2;

// 피로도
/*
이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다.
유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때,
유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
k는 1 이상 5,000 이하인 자연수입니다.
dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
dungeons의 가로(열) 길이는 2 입니다.
dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
"최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
"최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.

*/
import java.util.*;

public class Fatigue {
    class Solution {
        public int solution(int k, int[][] dungeons) {
            int answer = -1;

            boolean [] visited = new boolean[dungeons.length];

            ArrayList<Integer> clear = new ArrayList<>();
            permutation(80, 0, 3, 0, dungeons, visited, clear);

            System.out.println(clear.size());
            Collections.sort(clear);
            answer = clear.get(clear.size()-1);


            return answer;
        }
        public void permutation(int t, int step, int dept, int count, int[][] d, boolean[] visited, ArrayList<Integer> clear) {
            if(step == dept) {
                clear.add(count);
            }
            else {
                for(int i=0; i<d.length; i++) {
                    if(!visited[i]) {
                        visited[i] = true;
                        if(t >= d[i][0]) {
                            permutation(t-d[i][1], step+1, dept, count+1, d, visited, clear);
                        }
                        else {
                            permutation(t, step+1, dept, count, d, visited, clear);
                        }
                        visited[i] = false;

                    }
                }
            }

        }
    }
    // 다른 사람의 풀이
    class Solution2 {
        // 최대 던전횟수를 저장할 변수
        private int ret = 0;
        public int solution(int k, int[][] dungeons) {
            dfs(k, dungeons, new boolean[dungeons.length], 0);
            return ret;
        }
        public void dfs(int k, int[][] dungeons, boolean[] visit, int count) {
            // 모든 던전을 돌았을 경우
            if(count>=visit.length) {
                ret = count;
                return;
            }
            for(int i=0 ; i<dungeons.length ; i++) {
                // 방문한 곳은 패스
                if(visit[i]) continue;
                // 던전을 들어갈 수 없으면 거기까지의 통과한 던전 수를 최대수와 비교하여 업데이트
                if(k<dungeons[i][0]) {
                    ret = Math.max(ret, count);
                    continue;
                }
                // 방문한 곳 체크
                visit[i] = true;

                // 피로도 깎고 다른 던전으로
                dfs(k-dungeons[i][1], dungeons, visit, count+1);

                // 경우의 수를 위해 방금 돈 던전 초기화
                visit[i] = false;
            }
            return;
        }
    }
}
