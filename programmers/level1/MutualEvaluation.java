package programmers.level1;

// 상호 평가
/*
No.	0	1	2	3	4
0	100	90	98	88	65
1	50	45	99	85	77
2	47	88	95	80	67
3	61	57	100	80	65
4	24	90	94	75	65
평균	45.5 81.25	97.2 81.6 67.8
학점	F	B	A	B	D

각자 자기가 자신을 포함해 각 학생들을 평가한다
자기가 받은점수의 총합계는 열의 합이고 자기가 자신을 평가한 점수가
자기가 평가받은 점수중에 유일한 최대이거나 최소이면 이를 제외하고 평균을 구해 학점을 매긴다

평균	학점
90점 이상	A
80점 이상 90점 미만	B
70점 이상 80점 미만	C
50점 이상 70점 미만	D
50점 미만	F
*/
public class MutualEvaluation {
    class Solution {
        public String solution(int[][] scores) {
            String answer = "";

            for(int i=0; i<scores.length; i++) {
                int sum = 0;
                int max = 0;
                int min = 100;
                int divide  = scores.length;
                int cnt = 0;
                for(int j=0; j<scores[0].length; j++) {
                    max = Math.max(max, scores[j][i]);
                    min = Math.min(min, scores[j][i]);
                    sum += scores[j][i];
                }
                // 내 자신에게 준 점수가 최대이거나 최소이면
                // 그게 유일한 점수인지 중복이 있는지 체크
                // 중복이 있으면 cnt가 0보다 크므로 안빼고
                // 유일하면 제외하고 평균냄
                if(scores[i][i] == max || scores[i][i] == min) {
                    int check = scores[i][i];
                    for(int k=0; k< scores[0].length; k++) {
                        if(check == scores[k][i] && k != i) {
                            cnt++;
                        }
                    }
                    if(cnt == 0) {
                        sum = sum - scores[i][i];
                        divide--;
                    }
                }
                sum = sum / divide;
                if(sum >= 90) {
                    answer += "A";
                }
                else if(sum >= 80) {
                    answer += "B";
                }
                else if(sum >= 70) {
                    answer += "C";
                }
                else if(sum >= 50) {
                    answer += "D";
                }
                else {
                    answer += "F";
                }
            }

            return answer;
        }
    }
}
