package programmers.level2;

import java.util.Stack;

// 주식가격
// 주식가격이 담긴 배열이 있고
// 각각 가격이 떨어지지 않는 기간은 몇초인지 리턴
// 바로 다음 인덱스가 떨어졌더라도 1초로 측정
public class StockPrice {
    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = {};
            answer = new int[prices.length];

            // 리턴할 배열에 값 증가 시키다가 가격이 떨어지면 스탑하고 다음 주식
            for(int i = 0; i < prices.length; i ++)  {
                for(int j = i+1 ; j <prices.length ; j++ ) {
                    answer[i]++;
                    if(prices[i] > prices[j]) {
                        break;
                    }
                }
            }
            return answer;
        }
    }
    // 다른 사람의 풀이(Stack을 활용)
    class Solution2 {
        public int[] solution(int[] prices) {
            Stack<Integer> beginIdxs = new Stack<>();
            int i=0;
            int[] terms = new int[prices.length];

            beginIdxs.push(i);
            for (i=1; i<prices.length; i++) {
                while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                    int beginIdx = beginIdxs.pop();
                    terms[beginIdx] = i - beginIdx;
                }
                beginIdxs.push(i);
            }
            while (!beginIdxs.empty()) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx - 1;
            }

            return terms;
        }
    }
}
