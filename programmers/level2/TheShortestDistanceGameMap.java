package programmers.level2;

import java.util.*;

// 게임 맵 최단거리
/*
0과 1로 이루어진 n * m 크기의 2차원 배열이 주어지고
내 캐릭터는 1,1 (= 첫번째행과 첫번째열이라는 뜻) 상대 캐릭터는 n,m에 위치하게 된다
0은 벽 1은 갈수 있는 길일 때, 내 캐릭터가 상대 캐릭터에게 도달하는 최단거리를 리턴
단, 상대캐릭터가 벽으로 둘러쌓여 갈 수 없다면 -1을 리턴
*/
public class TheShortestDistanceGameMap {
    class Solution {

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        boolean[][] visited;
        int n, m;

        public int solution(int[][] maps) {
            n = maps.length;
            m = maps[0].length;

            visited = new boolean[n][m];
            return bfs(0, 0, maps);
        }

        public int bfs(int x, int y, int[][] maps) {
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(x, y, 1));
            visited[x][y] = true;

            while(!q.isEmpty()) {
                Node node = q.poll();
                if(node.x == n - 1 && node.y == m - 1) return node.cost;

                // 네 방향으로 좌표 길 확인
                for(int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.offer(new Node(nx, ny, node.cost + 1));
                        }
                    }
                }
            }
            return -1;
        }

        public class Node {
            int x;
            int y;
            int cost;

            public Node(int x, int y, int cost) {
                this.x = x;
                this.y = y;
                this.cost = cost;
            }
        }
    }
}
