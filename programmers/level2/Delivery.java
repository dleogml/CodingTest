package programmers.level2;

// 배달
// N개의 마을이 있고 각 마을간의 이동시간이 주어질때 1번마을에서 K시간 이내로 배달 가능한 마을 개수 리턴
// 마을의 개수 N, 각 마을을 연결하는 도로의 정보 road, 음식 배달 가능한 시간 K가 주어짐
// road는 행의 길이가 3인 이중배열 각 행 [a,b,c]는 a,b는 마을번호 c는 두 마을간의 이동시간
// 1번마을은 항상 갯수에 포함(최소 1)
// 다익스트라 알고리즘
// 하나의 정점에서 다른 정점까지 최소 거리를 갱신해서 최종 최소거리를 구하는 알고리즘
/*
우선순위 큐와 Comparable을 이용해서 거리를 오름차순으로 정렬
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Delivery {
    class Solution {
        // Edge 클래스 생성
        // 오름차순으로 정렬
        class Edge implements Comparable<Edge> {
            int to, weight;

            Edge(int to, int weight){
                this.to = to;
                this.weight = weight;
            }

            @Override
            public int compareTo(Edge e){
                return this.weight - e.weight;
            }
        }

        PriorityQueue<Edge> pq;
        ArrayList<ArrayList<Edge>> adj;
        int[] dist;

        public int solution(int N, int[][] road, int K) {
            int answer = 0;

            pq = new PriorityQueue<>();
            adj = new ArrayList<>();
            dist = new int[N + 1];

            Arrays.fill(dist, Integer.MAX_VALUE);
            for(int i = 0 ; i <= N ; ++i) adj.add(new ArrayList<>());

            for(int i = 0 ; i < road.length ; ++i){
                int from = road[i][0];
                int to = road[i][1];
                int weight = road[i][2];

                adj.get(from).add(new Edge(to, weight));
                adj.get(to).add(new Edge(from, weight));
            }

            dist[1] = 0;
            pq.offer(new Edge(1, 0));

            dijkstra();

            for(int distance : dist){
                if(distance <= K) answer++;
            }

            return answer;
        }

        private void dijkstra() {
            while(!pq.isEmpty()){
                Edge e = pq.poll();

                for(Edge ne : adj.get(e.to)){
                    if(dist[ne.to] > dist[e.to] + ne.weight){
                        dist[ne.to] = dist[e.to] + ne.weight;
                        pq.offer(ne);
                    }
                }
            }
        }
    }

}
