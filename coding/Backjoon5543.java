package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 햄버거 세개중 최소와 음료수 두개중 최소를 더해 세트할인으로 50을 뺌
public class Backjoon5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x [] = new int[5];
        int a, b, c;

        for(int i=0; i<5; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        a = Math.min(x[0], x[1]);
        b = Math.min(a, x[2]);
        c = Math.min(x[3], x[4]);

        System.out.println(b + c - 50);
    }
}
