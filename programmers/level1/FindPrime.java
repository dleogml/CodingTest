package programmers.level1;

// 소수 찾기
// n이 주어지면 1부터 n까지의 숫자중에 소수의 갯수가 몇개인지 리턴(n도 포함)
// 에라토스테네스의 체
// n의 제곱근을 찾아서 그 범위에 숫자에 대하여 배수를 전부지우면
// 남은 숫자들은 무조건 소수가 되는 것을 이용
public class FindPrime {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            boolean[] prime = new boolean [n+1];

            // 소수배열값에 전부 true넣어줌
            for(int i=2; i<=n; i++) {
                prime[i]=true;
            }
            // 제곱근
            int root=(int)Math.sqrt(n);

            // 앞에서부터 true이면 그 배수 전부 false
            for(int i=2; i<=root; i++){
                if(prime[i]==true){
                    for(int j=i; i*j<=n; j++)
                        prime[i*j]=false;
                }
            }
            // true인 숫자 즉, 소수들 갯수만큼 answer 증가
            for(int i =2; i<=n; i++)  {
                if(prime[i]==true)
                    answer++;
            }
            return answer;
        }
    }
}
