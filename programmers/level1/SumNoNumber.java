package programmers.level1;

// 없는 숫자 더하기
/*
0부터 9까지의 숫자 중 일부가 들어있는 배열 numbers가 매개변수로 주어집니다.
numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ numbers의 길이 ≤ 9
0 ≤ numbers의 모든 수 ≤ 9
numbers의 모든 수는 서로 다릅니다.
*/
public class SumNoNumber {
    class Solution {
        public int solution(int[] numbers) {
            int answer = -1;

            int sum = 0;

            for(int i=0; i<numbers.length; i++) {
                sum += numbers[i];
            }

            answer = 45 - sum;

            return answer;
        }
    }
}
