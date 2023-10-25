package programmers.level2;

import java.util.*;

/*
ex)
targets = [[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]
result = 3

*/
// 정렬과 그리디를 이용한 문제
public class InterceptionSystem {
    class Solution {
        public int solution(int[][] targets) {
            int answer = 0;

            boolean [] checked = new boolean [targets.length];

            Arrays.sort(targets, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1])
                        return o1[0] - o2[0];
                    else
                        return o1[1] - o2[1];
                }
            });

            for(int i = 0; i < targets.length; i++) {
                int [] temp = new int [2];
                temp[0] = targets[i][0];
                temp[1] = targets[i][1];
                if(checked[i] == true) {
                    continue;
                } else {
                    answer = findSameRage(temp[0], temp[1], targets, i, checked, answer);
                }
            }

            return answer;
        }

        public int findSameRage(int s, int e, int [][] targets, int index, boolean [] checked, int answer) {
            for(int i = index; i < targets.length; i++) {
                if(checked[i] == true) {
                    continue;
                } else if(checked[i] == false && targets[i][0] < e && targets[i][1] > s) {
                    checked[i] = true;
                }
            }
            return answer += 1;
        }
    }

    // 다른 사람의 풀이
    class Solution2 {
        public int solution(int[][] targets) {
            Arrays.sort(targets, (a, b) -> a[0] - b[0]); // x좌표 기준으로 정렬
            int cnt = 0;
            int last = -1;
            for (int i = 0; i < targets.length; i++) {
                int[] missile = targets[i];
                if (missile[0] > last) { // 새로운 요격 미사일 필요
                    cnt++;
                    last = missile[1] - 1; // 해당 미사일로 커버되는 범위
                } else if (missile[1] - 1 < last) { // 더 작은 범위로 커버 가능한 미사일 필요
                    last = missile[1] - 1; // 해당 미사일로 커버되는 범위
                }
            }
            return cnt;
        }
    }
    /*
    1, 4  last = 3 cnt = 1
    3, 7  last = 3 cnt = 1
    4, 5  last = 4 cnt = 2
    4, 8  last = 4 cnt = 2
    5, 12 last = 11 cnt = 3
    10, 14 last = 11 cnt = 3
    11, 13 last = 11 cnt = 3
    return answer = 3
    */
}
