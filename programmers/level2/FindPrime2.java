package programmers.level2;

import java.util.HashSet;
import java.util.Set;

// 소수 찾기 Level-2
// numbers가 주어지고 이를 짤라서 만들 수 있는 소수의 개수를 리턴
// ex)17 => 7, 17, 71 답 : 3
// 완전탐색의 문제로 재귀함수를 활용한 케이스
public class FindPrime2 {
    class Solution {
        public int solution(String numbers) {
            HashSet<Integer> set = new HashSet<>();

            permutation("", numbers, set); //순열

            int count = 0;
            while(set.iterator().hasNext()){
                int a = set.iterator().next();
                set.remove(a);
                if(a==2) count++;
                if(a%2!=0 && isPrime(a)){
                    count++;
                }
            }
            return count;
        }

        //순열방식으로 각각의 자리를 만들기
        public void permutation(String prefix, String str, HashSet<Integer> set) {
            int n = str.length();
            if(!prefix.equals("")) {
                set.add(Integer.valueOf(prefix)); //스트링을 Interger로 변환
            }

            for (int i = 0; i < n; i++){
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
            }

        }

        //소수찾기
        public boolean isPrime(int n){
            if(n==0 || n==1) return false;
            for(int i=2; i<=(int)Math.sqrt(n); i+=1){
                if(n%i==0) return false;
            }
            return true;
        }
    }

    // 다른 사람의 풀이
    static class Solution2 {
        static Set<Integer> combinationList = new HashSet<>();
        // 소수 판별하기 boolean
        public static boolean isPrimeNumber(int N){
            // 소수는 2부터 시작한다.
            //System.out.println(N);
            if(N <=1){
                return false;
            }

            // 소수가 아닐 경우 바로 return true;
            for(int i=2; i<N; i++){
                // 나눠 떨어진다는 것은 약수가 존재한다는 것.
                // 즉 소수가 아님.
                if(N%i == 0){
                    return false;
                }
            }

            return true;
        }

        // [1, 2, 3]
        static void comb(int[] num, boolean[] visited, int r, String str) {
            if(r == -1){
                return;
            }


            if(isPrimeNumber(Integer.parseInt(str))){
                combinationList.add(Integer.parseInt(str));
            }

            for(int i=0; i<num.length; i++){
                if(!visited[i]){
                    visited[i] = true;
                    comb(num, visited, r-1, str + String.valueOf(num[i]));
                    visited[i] = false;
                }
            }

            return;
        }


        public int solution(String numbers) {
            //String으로 된 숫자배열(String type)을 int배열로 만들기.
            int[] num = new int[numbers.length()];
            boolean[] visited = new boolean[num.length];

            for(int i=0; i<numbers.length(); i++){
                num[i] = numbers.charAt(i) - '0';
            }

            // 소수의 개수
            int answer = 0;

            // 종이 조각을 붙여 소수를 몇개 만들 수 있는지
            // 소수? 자신보다 작은 수 중에서 %값이 ==0인것이 1뿐인 것.

            // num배열에서 숫자를 조합해서 여기 넣어줘야함.
            // 배열로 만들 수 있는 경우의 수

            for(int i=0; i<num.length; i++){
                visited[i] = true;
                comb(num, visited, num.length, String.valueOf(num[i]));
                visited[i] = false;
            }


            return combinationList.size();
        }
    }

    // 다른 사람의 풀이2
    // 아마 이사람의 순열 풀이를 보고 자기만의 순열풀이를 많이 짠듯 하다
    class Solution3 {
        public int solution(String numbers) {
            HashSet<Integer> set = new HashSet<>();
            permutation("", numbers, set);
            int count = 0;
            while(set.iterator().hasNext()){
                int a = set.iterator().next();
                set.remove(a);
                if(a==2) count++;
                if(a%2!=0 && isPrime(a)){
                    count++;
                }
            }
            return count;
        }

        public boolean isPrime(int n){
            if(n==0 || n==1) return false;
            for(int i=3; i<=(int)Math.sqrt(n); i+=2){
                if(n%i==0) return false;
            }
            return true;
        }

        public void permutation(String prefix, String str, HashSet<Integer> set) {
            int n = str.length();
            //if (n == 0) System.out.println(prefix);
            if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

        }

    }
}
