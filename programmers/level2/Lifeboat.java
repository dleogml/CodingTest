package programmers.level2;

import java.util.Arrays;

// 구명보트
// 한번에 최대 2명밖에 못 타고, 무게제한도 있다
// 구명보트를 최대한 적게 사용하여 사람을 구출할 때 그 횟수를 리턴
// 오름차순으로 정렬하고 가장 작은값과 가장 큰값을 더해 제한을 넘지않으면 최소값을 증가시켜서
// 같이 태우고 아니면 혼자 태움
public class Lifeboat {
    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;

            int min = 0;
            Arrays.sort(people);

            for(int max = people.length-1; min <= max; max--) {
                if(people[min] + people[max] <= limit) {
                    min++;
                }
                answer++;
            }

            return answer;
        }
    }
}
