package String반복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] al = new int [26];
        String s = br.readLine();

        for(int i=0; i<s.length(); i++) {
            if(65 <= s.charAt(i) && s.charAt(i) <= 90) {
                al[s.charAt(i) - 65] ++;
            }
            else {
                al[s.charAt(i) - 97] ++;
            }
        }

        int max = -1;
        char c = '?';

        for(int i=0; i<26; i++){
            if(al[i] > max ) {
                max = al[i];
                c = (char)(i + 65);
            }
            else if(al[i] == max) {
                c = '?';
            }
        }
        System.out.print(c);
    }
}
