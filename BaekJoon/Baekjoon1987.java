package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고,
좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는
알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.

첫째 줄에 R과 C가 빈칸을 사이에 두고 주어진다. (1 ≤ R,C ≤ 20) 둘째 줄부터 R개의 줄에 걸쳐서 보드에 적혀 있는
C개의 대문자 알파벳들이 빈칸 없이 주어진다.

첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다.
*/
// 1987번 : 알파벳
// 깊이 우선 탐색, 백트래킹
public class Baekjoon1987 {
    public static int n;
    public static int m;
    public static String [][] map;
    public static boolean [][] visited;
    public static int dx[] = {0, 0, 1, -1};
    public static int dy[] = {1, -1, 0, 0};
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }
        // dfs, 처음부터 길이 1이므로 1로시작
        dfs(0, 0, map[0][0], 1);

        System.out.println(result);

    }

    public static void dfs(int x, int y, String str, int length) {
        // 길이를 갱신
        result = Math.max(result, length);

        // 상하좌우로 탐색
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 범위를 벗어나거나 지나온 경로면 패스
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) {
                continue;
            }
            // 한번도 나오지 않은 알파벳인경우 다음 dfs 진행
            // 다른 방향에 대해서는 방문정보를 동일하게 하기 위해 visited 초기화
            if(!str.contains(map[nx][ny])) {
                visited[nx][ny] = true;
                dfs(nx, ny, str+map[nx][ny], length+1);
                visited[nx][ny] = false;
            }
        }
    }
}
