package programmers.level2;


// 2개이하로 다른 비트
/*
양의 정수 x에 대한 함수 f(x)에 대한 정의
=> x보다 크고 x와 비트가 1~2개 다른 수들 중에서 가장 작은 수
비트는 해당정수를 이진수로 표현한 것을 의미

정수들이 담긴 배열 numbers가 주어질 때 numbers의 모든 수들에 대하여
각 수의 f(x)값을 차례대로 담아 return
*/
public class BelowTwoBit {
    // 내가 푼 방법
    // 시간초과로 실패
    class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];

            for(int i=0; i<numbers.length; i++) {
                String start = String.format("%32s", Long.toBinaryString(numbers[i])).replaceAll(" ", "0");
                int s = Long.valueOf(numbers[i]).intValue();
                int t = s;
                boolean flag = false;

                while(!flag) {
                    t = t + 1;
                    int cnt = 0;
                    String check = String.format("%32s", Integer.toBinaryString(t)).replaceAll(" ", "0");
                    for(int j=0; j<32; j++) {
                        if(start.charAt(j) != check.charAt(j)) {
                            cnt++;
                        }
                    }
                    if(cnt <= 2) {
                        flag = true;
                    }

                }

                answer[i] = t;

            }

            return answer;
        }

    }


    // 단순히 for문을 돌려가며 찾으면 무조건 시간초과가 나는 문제
    // 수학적접근이 필요했다
    // 짝수는 +1 한수와 이진수로 변환할 경우도 맨끝하나가 0에서 1로바뀌므로
    // +1만 해주면 된다
    // 홀수는 가장 작은 1을 0, 그보다 작은 0을 1로 바꾸면 된다
    class Solution2 {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];

            for(int i=0; i<numbers.length; i++){
                String BinaryString =  Long.toBinaryString(numbers[i]);
                if(numbers[i]%2==0){
                    //짝수 가장 낮은 0만 바꾸기
                    //사실상 맨 마지막 자리는 0이기에 +1만 해주면 된다.
                    answer[i] = numbers[i]+1;

                }else{
                    //홀수 가장 낮은 0을 1로 바꾸고 , 방금 바꾼것보다는 나중 위치에서 1을 0으로 바꾸기
                    int lastindex =  BinaryString.lastIndexOf("0");
                    int firstindex = BinaryString.indexOf("1",lastindex);
                    if(lastindex==-1){
                        //0이 없는경우 +1을 해주고
                        //앞의 10은 놔두고 나머지는 다 1로 해준다.
                        numbers[i]+=1;
                        BinaryString =  Long.toBinaryString(numbers[i]);
                        BinaryString = BinaryString.substring(0,2)+
                                BinaryString.substring(2,BinaryString.length()).replace("0","1");

                    }else{
                        BinaryString = BinaryString.substring(0,lastindex)+"1"+
                                BinaryString.substring(lastindex+1,firstindex)+"0"+
                                BinaryString.substring(firstindex+1,BinaryString.length());
                    }

                    answer[i] = Long.parseLong(BinaryString,2);
                }


            }
            return answer;
        }

    }

}
