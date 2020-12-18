package programmers.level2;

import java.util.Arrays;

// 타겟 넘버
// numbers에 숫자 배열이 담겨져 있고 target에 만들 숫자가 주어진다
// numbers에 숫자를 적절히 더하고 빼서 target을 만들 수 있는 경우의 수를 리턴
// BFS와 DFS로 푸는 방법이 있다. 밑에 풀이는 DFS로 푼 방법
// 재귀식으로 반복해서 배열의 길이가 될 때까지 반복했을 때 target인 것들을 더해줌
public class TargetNumber {
    class Solution {
        public int DFS(int [] numbers, int target, int index, int num) {
            if(index == numbers.length) {
                return num == target ? 1 : 0;
            }
            else {
                return DFS(numbers, target, index + 1,  num + numbers[index]) +
                        DFS(numbers, target, index + 1, num - numbers[index]);
            }
        }
        public int solution(int[] numbers, int target) {
            return DFS(numbers, target, 0, 0);
        }

    }
}
