package programmers.level1;

import java.util.Arrays;

// 예산
// 부서마다 필요한 예산이 들어있는 d배열이 있고
// 전체예산이 들어있는 budget이 있다. 필요한 예산만큼만 딱 줄수있고
// 적게 줄수는 없을 때 최대 몇개의 부서에 지원할 수 있는지 리턴
public class Budget {
    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;

            // 오름차순으로 정렬
            // 여러가지 경우의 수가 있을 수 있겠지만
            // 작은 것부터 뺐을 때가 가장 많은 부서에 지원할 수 있는 경우라 생각
            Arrays.sort(d);

            // 하나씩 빼면서 예산을 삭감하는데
            // 빼야될 수 보다 예산이 적게 남았다면 스탑탑
           for(int i=0; i<d.length; i++) {
                if(budget < d[i]) {
                    break;
                }
                budget = budget - d[i];
                answer++;
            }

            return answer;
        }
    }
}
