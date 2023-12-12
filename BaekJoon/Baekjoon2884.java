package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int alramH = h;
        int alramM = m - 45;
        if(alramM < 0) {
            alramH--;
            alramM += 60;
            if(alramH < 0) {
                alramH += 24;
            }
        }
        System.out.println(alramH + " " + alramM);
    }
}
