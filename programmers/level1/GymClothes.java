package programmers.level1;

// 체육복
// 전체 학생중 체육복을 잃어버린 학생과
// 여벌의 체육복이 있는 학생들 있을 때
// 이를 빌려준다면 몇명이 수업에 참여할 수 있는지 계산
public class GymClothes {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;

            // 자기것 하나를 잃어버렸지만 여벌이 있어 자급자족되는 학생과
            // 친구에게 빌려야 되는 학생
            int self = 0;
            int borrow = 0;

            // 자급자족 되는 학생을 찾는 for문
            // 찾은 후에는 -1 값을 넣어서 빌려줄 수 없게 만듬
            for(int i=0; i<lost.length; i++) {
                for(int j=0; j<reserve.length; j++) {
                    if(lost[i] == reserve[j]) {
                        self++;
                        lost[i] = -1;
                        reserve[j] = -1;
                        break;
                    }
                }
            }

            // 여벌의 체육복을 잃어버린 학생들에게
            // 빌려주기 위한 for문
            // 빌려주고 나서는 -1값으로 더이상 빌려줄 수 없게 만듬
            for(int i=0; i<lost.length; i++) {
                for(int j=0; j<reserve.length; j++) {
                    if(lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
                        borrow++;
                        reserve[j] = -1;
                        break;
                    }
                }
            }

            // 수업참여가능 = 전체학생수 - 잃어버린 학생수 + 자급자족 + 빌린학생
            answer = n - lost.length + self + borrow;

            return answer;
        }
    }
    // 다른 사람 풀이
    /*
     class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int[] people = new int[n];
            int answer = n;

            for (int l : lost)
                people[l-1]--;
            for (int r : reserve)
                people[r-1]++;

            for (int i = 0; i < people.length; i++) {
            // 잃어버린 학생에 대해
            // 앞에서 찾고 뒤에서 찾고
            // 그래도 없으면 최종인원에서 -1
                if(people[i] == -1) {
                    if(i-1>=0 && people[i-1] == 1) {
                        people[i]++;
                        people[i-1]--;

                    }else if(i+1< people.length && people[i+1] == 1) {
                        people[i]++;
                        people[i+1]--;
                    }else
                        answer--;
                }
            }
            return answer;
        }
    }
    */
}
