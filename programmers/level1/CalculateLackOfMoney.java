package programmers.level1;

// 부족한 금액 계산하기
/*
제한사항
놀이기구의 이용료 price : 1 ≤ price ≤ 2,500, price는 자연수
처음 가지고 있던 금액 money : 1 ≤ money ≤ 1,000,000,000, money는 자연수
놀이기구의 이용 횟수 count : 1 ≤ count ≤ 2,500, count는 자연수

ex) price : 3, money : 20, count : 4 이라면
이용금액은 3 + 3*2 + 3*3 + 3*4 = 30
가지고 있는 돈은 20이므로 부족한돈은 30 - 20 = 10 이다

가지고 있는 돈이 충분하면 0을 리턴
*/
public class CalculateLackOfMoney {
    class Solution {
        public long solution(int price, int money, int count) {
            long answer = 0;

            for(int i=1; i<=count; i++) {
                answer += price * i;
            }

            if(answer > money) {
                answer = answer - money;
            }
            else {
                answer = 0;
            }

            return answer;
        }
    }

    // 다른 사람의 풀이
    // 등차 수열의 합에 1회당 이용금액을 곱해주면 총 이용금액이 되고
    // 이걸 max로 감싸면 돈이 여유로울때 자연스럽게 0이 리턴됨
    class Solution2 {
        public long solution(long price, long money, long count) {
            return Math.max(price * (count * (count + 1) / 2) - money, 0);
        }
    }
}
