package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 12865번 : 평범한 배낭
/*
한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다.
세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.

준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데,
해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다.
준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.

첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다.
두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.

입력으로 주어지는 모든 수는 정수이다.
*/
// 다이나믹 프로그래밍(dp), 배낭 알고리즘
public class Baekjoon12865 {
    // DP로 풀이
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());
        int [][] itemList = new int [n+1][2];
        int [][] dp = new int [n+1][maxWeight+1];

        for(int i = 1; i <= n; i++) {
            String [] temp = br.readLine().split(" ");
            for(int j = 0; j < 2; j++) {
                itemList[i][j] = Integer.parseInt(temp[j]);
            }
        }

        // 무게 1 ~ 7
        for(int j = 1; j <= maxWeight; j++) {
            // 아이템리스트
            for(int i = 1; i <= n; i++) {
                // 기본적으로 위에 가치만큼 누적
                dp[i][j] = dp[i-1][j];
                // 남은 무게가 있다면 그 무게에 이전 아이템까지의 누적가치와 현재 아이템의 가치의 합이
                // 직전 아이템의 가치보다 높으면 새로 갱신
                if(j - itemList[i][0] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], itemList[i][1] + dp[i-1][j-itemList[i][0]]);
                }
            }
        }

        System.out.println(dp[n][maxWeight]);

    }

    // 내가 풀어본 방식
    // 투포인터로 풀었는데 그럴 경우 제한된 범위내에서만 가능한 무게의 가방을 찾기 때문에 실패
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());
        int [][] list = new int [n][2];
        ArrayList<Integer> valueList = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            String [] temp = br.readLine().split(" ");
            for(int j = 0; j < 2; j++) {
                list[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int left, right;
        int sumWeight = 0;
        int sumValue = 0;
        for(left = 0, right = 0; right < n && left < n; right++) {
            sumWeight += list[right][0];
            sumValue += list[right][1];
            if(sumWeight > maxWeight) {
                while(sumWeight > maxWeight) {
                    sumWeight -= list[left][0];
                    sumValue -= list[left][1];
                    left++;
                }
            } else if(sumWeight == maxWeight){
                maxValue = Math.max(sumValue, maxValue);
                //valueList.add(sumValue);
            }
        }

        System.out.println(maxValue);

        //Collections.sort(valueList);
        //System.out.println(valueList.get(valueList.size()-1));
    }
    */
}
