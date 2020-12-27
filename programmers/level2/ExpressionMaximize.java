package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 수식 최대화 (2020 카카오 인턴쉽)
// 수식이 문자열로 주어진다.
// 수식의 연산자의 종류는 최대 3개로 +,-,* 이다
// 연산자간의 우선순위를 정할 수 있으며 2가지 일때는 4, 3가지 일때는 6의 경우의 수를 가진다.
// 이렇게 여러가지 우선순위 중에서 가장 값이 큰 값을 찾아서 리턴
// 결과값이 마이너스인 경우 절대값
public class ExpressionMaximize {
    class Solution {
        long[] n; // 연산식에서 뽑은 숫자들이 들어갈 배열
        ArrayList<Character> oper; // 연산식에서 뽑은 연산자들이 들어갈 어레이리스트
        // 미리 정의한 3개 연산자의 우선순위
        int[][] operPr = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 0, 2 }, { 1, 2, 0 }, { 2, 0, 1 }, { 2, 1, 0 } };
        Map<Character, Integer> map; // 연산자와 인덱스를 연결시켜줄 맵

        public long solution(String str) {
            oper = new ArrayList<>();
            // operPr에서 0번째의 값은 -의 우선순위, 1번째값은 +의 우선순위를 의미함
            map = new HashMap<>();
            map.put('-', 0);
            map.put('+', 1);
            map.put('*', 2);

            char[] c = str.toCharArray();
            // 연산식을 돌면서 연산자인 경우 숫자분리를 위해 ' '로 바꿔주고, 연산자는 따로 저장한다
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '+') {
                    c[i] = ' ';
                    oper.add('+');
                } else if (c[i] == '-') {
                    c[i] = ' ';
                    oper.add('-');
                } else if (c[i] == '*') {
                    c[i] = ' ';
                    oper.add('*');
                }
                sb.append(c[i]);
            }

            // 5 3 2 6 으로 연산자가 제외된 문자열을 잘라서 숫자로 변환
            String[] nums = sb.toString().split(" ");
            n = new long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                n[i] = Integer.parseInt(nums[i]);
            }


            // 연산자 우선순위
            long answer = 0;
            for (int i = 0; i < operPr.length; i++) {
                // openPr[i] 이 현재 연산자 우선순위
                long result = Math.abs(getValue(operPr[i])); // 계산 결과의 절댓값을 취함
                answer = Math.max(answer, result);

            }
            return answer;
        }

        // 해당 연산자의 우선순위 대로 식을 계산하는 메서드
        private long getValue(int[] ops) {
            ArrayList<Long> number = new ArrayList<>();
            ArrayList<Character> opers = new ArrayList<>();

            for (int i = 0; i < oper.size(); i++) {
                opers.add(oper.get(i));
            }
            for (int i = 0; i < n.length; i++) {
                number.add(n[i]);
            }

            for (int i = 2; i > -1; i--) { // 우선순위가 2부터 0으로
                for (int j = 0; j < opers.size(); j++) {
                    if (ops[map.get(opers.get(j))] == i) { // 만일 해당차례의 연산자가 우선순위가 i라면
                        long a = number.remove(j); // 숫자 2개 뽑아서
                        long b = number.remove(j);
                        long result = doOperation(opers.get(j), a, b); // 연산
                        number.add(j, result); // 다시 더해주고
                        opers.remove(j); // 완료한 연산자는 제거
                        j--; // 제거했으므로 인덱스 하나 땡겨짐
                    }
                }
            }
            return number.remove(0); // 연산 수행 후 남은 숫자 (해당 우선순위에 따른 연산 답)
        }

        private long doOperation(char op, long a, long b) {
            switch (op) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
            }
            return 0;
        }

    }
}
