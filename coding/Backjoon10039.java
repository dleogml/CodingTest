package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//5명의 평균을 구하고 40미만은 무조건 40점으로 계산
public class Backjoon10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int x [] = new int [5];
        int sum = 0;

        for(int i=0; i<5; i++) {
            x[i] = Integer.parseInt(br.readLine());
            if(x[i] < 40) {
                x[i] = 40;
            }
            sum += x[i];
        }


        System.out.println(sum/5);

    }
}
