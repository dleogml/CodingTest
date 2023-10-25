package programmers.level2;

import java.util.*;

// 연속된 부분 수열의 합
public class SumOfCS {
    // 나의 풀이
    // 이중배열이므로 시간복잡도는 O(N^2)
    // 시간초과로 실패
    class Solution1 {
        public int[] solution(int[] sequence, int k) {
            int[] answer = new int [2];

            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < sequence.length; i++) {
                int sum = 0;
                int len = 0;
                int start = i;
                for(int j = i; j < sequence.length; j++) {
                    if(sum >= k) {
                        break;
                    }
                    sum += sequence[j];
                    len++;
                }
                // 인덱스 시작과 길이저장
                if(sum == k) {
                    map.put(start, len);
                }
            }

            List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());

            // 길이(값) 오름차순, 인덱스(키) 오름차순
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if(o1.getValue() > o2.getValue()) {
                        return 1;
                    } else if(o1.getValue() == o2.getValue()) {
                        if(o1.getKey() > o2.getKey()) {
                            return 1;
                        } else if(o1.getKey() == o2.getKey()) {
                            return 0;
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                }
            });

        /*
        for(Map.Entry<Integer, Integer> e : list) {
            System.out.println("index : " + e.getKey() + " length : " + e.getValue());
        }
        */

            answer[0] = list.get(0).getKey();
            answer[1] = list.get(0).getKey() + list.get(0).getValue() - 1;

            return answer;
        }
    }

    // 정답풀이, 투 포인터 문제
    // 두개의 포인터로 조건에 따라 각각의 포인터를 이동하면서 답을 찾아야 하는 문제
    class Solution2 {
        public int[] solution(int[] sequence, int k) {

            // 투 포인터 (lt, rt), 누적합 (sum), 현재 포인터 간 길이 (ptrLen) 초기화
            int lt = 0;
            int rt = 0;
            int ptrLen = Integer.MAX_VALUE;
            int sum = 0;
            int[] answer = new int[2];
            while (rt < sequence.length && lt <= rt) {

                // 첫 번째 접근 또는 rt가 바라보는 원소가 k와 같을 때
                if (lt == rt) {
                    sum = sequence[lt];
                }
                // 현재 누적합이 k와 같은 경우
                if (sum == k) {
                    // 현재 포인터 간 길이가 이전 포인터 간 길이보다 짧은 경우
                    if (ptrLen > rt - lt + 1) {
                        ptrLen = rt - lt + 1;
                        answer[0] = lt;
                        answer[1] = rt;
                    }
                    // 모든 원소는 양수이기 때문에 다음 경우의 수를 찾기 위해 lt를 증가 시킬 것이며, 누적합 계산을 위해 현재 sequence[lt] 값을 빼준다.
                    sum -= sequence[lt];
                    // rt도 마찬가지로 증가시킬 것이기 때문에 현재 누적합에 sequence[rt + 1]을 더해준다.
                    if (rt + 1 < sequence.length) {
                        sum += sequence[rt + 1];
                    }
                    // 두 포인터가 같은 경우 가장 짧은 길이이기 때문에 순회를 종료
                    if (lt == rt) {
                        break;
                    }
                    // 각 포인터 증가
                    lt++;
                    rt++;

                } else if (sum > k) {
                    // 누적합이 k 보다 큰 경우 lt를 증가해가며 k와 같은 지를 비교
                    sum -= sequence[lt];
                    lt++;
                } else if (sum < k) {
                    // 누적합이 k 보다 작은 경우 rt를 증가해가며 k와 같은 지를 비교
                    if (rt + 1 < sequence.length) {
                        sum += sequence[rt + 1];
                    }
                    rt++;
                }

            }
            return answer;
        }
    }

    // 좀 더 깔끔한 풀이
    class Solution3 {
        public int[] solution(int[] sequence, int k) {
            int[] answer = new int [2];

            int left = 0;
            int right = 0;
            int sum = 0;
            int size = sequence.length;
            int ans1 = 0;
            int ans2 = 0;

            for(right = 0; right < sequence.length; right++) {
                sum += sequence[right];

                while(sum > k) {
                    sum -= sequence[left];
                    left++;
                }
                // 부분 수열의 합일경우
                if(sum == k) {
                    // 이전보다 작은 길이면 길이, 시작인덱스, 마지막인덱스 갱신
                    if(size > right-left) {
                        size = right-left;
                        ans1 = left;
                        ans2 = right;
                    }
                    // 이전과 같은 길이면 시작인덱스, 마지막인덱스 갱신
                    else if(size == right-left) {
                        ans1 = Math.min(ans1, left);
                        ans2 = Math.min(ans2, right);
                    }
                }

            }

            answer[0] = ans1;
            answer[1] = ans2;

            return answer;
        }
    }
}
