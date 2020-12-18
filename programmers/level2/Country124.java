package programmers.level2;

// 124 나라의 숫자
// 124로만 모든숫자를 표현한다
// 1 = 1 / 2 = 2 / 3 = 4
// 4 = 11 / 5 = 12 / 6 = 14
// 7 = 21 / 8 = 22 / 9 = 24
// 10 = 41
// 자연수 n을 124방식으로 바꿔서 String으로 리턴
public class Country124 {
    class Solution {
        public String solution(int n) {
            String answer = "";
            // 3으로 나눴을 때 나머지가 0,1,2일 경우에 맞게 값을 치환
            String [] numbers = {"4", "1", "2"};

            int num = n;
            while(num > 0) {
                int temp = num%3;
                num /= 3;

                // 나머지가 0일 때는 -1을 해줌으로서 그 다음 값이
                // 배열의 올바른 인덱스를 나타낼수 있도록 조정
                if(temp == 0) {
                    num--;
                }
                // 먼저 계산한 값을 뒤에, 새로운 값을 앞에 추가하며 계속 더해줌
                answer = numbers[temp] + answer;
            }

            return answer;
        }
    }
    // 다른 사람의 풀이
    // 방식은 똑같지만 n을 나눈 값으로 초기화할때 아예 -1을 해주면
    // 나머지가 0일때이거나 아닐때 전부 조정가능
    class Solution2 {
        public String solution(int n) {
            String[] num = {"4","1","2"};
            String answer = "";

            while(n > 0){
                answer = num[n % 3] + answer;
                n = (n - 1) / 3;
            }
            return answer;
        }
    }
}
