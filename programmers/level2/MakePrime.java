package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

// 소수 만들기
// 숫자의 배열이 주어지고 그 중 3개의 숫자를 더해서 소수가 되는 경우의 수를 리턴
// 모든 숫자는 중복된 숫자가 없고 더한 숫자가 소수인지 아닌지 판별이니
// 더해서 나오는 숫자의 숫자는 조합의 경우이다.
public class MakePrime {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            int len = nums.length;
            ArrayList<Integer> list = new ArrayList<>();
            Arrays.sort(nums);

            for(int i=0; i<len-2; i++) {
                for(int j=i+1; j<len-1; j++) {
                    for(int k=j+1; k<len; k++) {
                        list.add(nums[i] + nums[j] + nums[k]);
                    }
                }
            }
            for(int i=0; i<list.size(); i++) {
                if(isPrime(list.get(i))) answer++;
            }

            return answer;
        }
        public boolean isPrime(int n){
            if(n==0 || n==1) return false;
            for(int i=2; i<=(int)Math.sqrt(n); i++) {
                if(n%i==0) return false;
            }
            return true;
        }
    }
}
