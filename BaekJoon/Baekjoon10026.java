package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.
크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데,
구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다.
(색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)

예를 들어, 그림이 아래와 같은 경우에
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR

적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.

첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100) 둘째 줄부터 N개 줄에는 그림이 주어진다.
적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
*/
// 10026번 : 적록색약
// 그래프이론, 그래프 탐색, 깊이 우선 탐색, 넓이 우선 탐색
public class Baekjoon10026 {
    public static int n;
    public static char [][] map;
    public static int dx[] = {0, 0, 1, -1};
    public static int dy[] = {1, -1, 0, 0};
    public static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        int ans1 = 0;
        int ans2 = 0;

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 일반사람일때
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 방문하지 않은 곳이면 bfs시작(같은색깔영역 방문처리)
                if(!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    ans1++;
                }
                // 적록색약인 사람일때 경우를 위해 G를 전부 R로 변경
                if(map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        visited = new boolean[n][n];
        // 적록색약인경우
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    ans2++;
                }
            }
        }

        System.out.println(ans1 + " " + ans2);

    }

    public static void bfs(int x, int y, char target) {
        Queue<int[]> q = new LinkedList<>();
        int [] temp = {x, y};
        // 처음 시작지점 방문처리
        visited[x][y] = true;
        q.add(temp);

        while(!q.isEmpty()) {
            int [] now = q.poll();
            int px = now[0];
            int py = now[1];
            // 상하좌우로 이동하면서 같은 색깔찾기
            for(int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                // 영역을 넘어가지 않고 방문하지 않았고 같은 색깔일 경우 방문처리 및 새로운 탐색지점으로 등록
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] == target) {
                    visited[nx][ny] = true;
                    q.add(new int [] {nx, ny});
                }
            }
        }
    }
    // dfs로 푸는법
    // bfs대신 dfs를 넣어주면 된다
    public static void dfs(int x, int y, int target) {
        // 이미 방문된경우는 dfs 실행못하게 방지
        if(visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 방문된 경우는 실행되지 않으니까 확인조건에서 뺌
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == target) {
                dfs(nx, ny, target);
            }
        }

    }
}
