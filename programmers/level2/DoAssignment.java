package programmers.level2;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

// 과제 진행하기
public class DoAssignment {
    // 내가 풀어본 풀이
    // 다행히 통과하였다
    class Solution {
        public String[] solution(String[][] plans) {
            ArrayList<String> answer = new ArrayList<>();

            Stack<String> stopPlan = new Stack<>();
            Stack<Integer> stopPlanTime = new Stack<>();

            // 과제시작시간이 짧은 순으로 정렬
            Arrays.sort(plans, new Comparator<String[]>() {

                @Override
                public int compare(String [] o1, String [] o2) {
                    LocalTime l1 = LocalTime.parse(o1[1]);
                    LocalTime l2 = LocalTime.parse(o2[1]);

                    if(l1.isBefore(l2)) {
                        return -1;
                    } else if(!l1.isBefore(l2)) {
                        return 1;
                    } else {
                        return 0;
                    }
                }

            });

        /*
        과제시작시간과 다음과제시작시간 차이계산
        진행시간보다 같거나 크다 => 현재과제완료, answer에 추가 if 시간남을경우 멈춘과제 진행
        진행시간보다 작다 => 스택에 넣고 남은시간도 저장 => 다음과제잇으면 그거진행 없으면 제일최근멈춘과제
        */
            for(int i = 0; i < plans.length; i++) {
                if(i == plans.length - 1) {
                    answer.add(plans[i][0]);
                    continue;
                }
                LocalTime beforePlan = LocalTime.parse(plans[i][1]);
                LocalTime afterPlan = LocalTime.parse(plans[i+1][1]);
                int betweenTime = (int)beforePlan.until(afterPlan, ChronoUnit.MINUTES);
                int processTime = Integer.parseInt(plans[i][2]);
                // 현재과제 진행시간과 두 과제 사이의 시간을 비교
                if(processTime == betweenTime) {
                    answer.add(plans[i][0]);
                } else if(processTime < betweenTime) {
                    answer.add(plans[i][0]);
                    int remainTime = betweenTime - processTime;
                    processStop(remainTime, stopPlan, stopPlanTime, answer);
                } else {
                    int spt = processTime - betweenTime;
                    stopPlan.push(plans[i][0]);
                    stopPlanTime.push(spt);
                }
            }

            while(!stopPlan.empty()) {
                answer.add(stopPlan.peek());
                stopPlan.pop();
            }

            String [] ans = answer.toArray(new String[answer.size()]);

            return ans;
        }

        // 멈춰놓은과제 처리하기
        public void processStop(int remain, Stack<String> stopPlan, Stack<Integer> stopTime, ArrayList<String> answer) {
            if(stopPlan.size() == 0) {
                return;
            }

            int st = stopTime.peek();
            if(remain > st) {
                answer.add(stopPlan.peek());
                stopPlan.pop();
                stopTime.pop();
                remain = remain - st;
                processStop(remain, stopPlan, stopTime, answer);
            } else if(remain == st) {
                answer.add(stopPlan.peek());
                stopPlan.pop();
                stopTime.pop();
            } else {
                st = st - remain;
                stopTime.pop();
                stopTime.push(st);
            }
        }
    }
}
