package BOJ10384;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10384 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int num = 1; num <= T; num++) {
            String str = br.readLine();
            int[] memory = new int[26];
            str = str.toLowerCase();
            for(char c : str.toCharArray()) {
                int tmp = c-97;
                if(tmp > 25 || tmp < 0) {
                    continue;
                }
                memory[tmp]++;
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 26; i++) {
                min = Math.min(min, memory[i]);
            }

            if(min == 0) {
                bw.write("Case "+num+": Not a pangram");
            } else if(min == 1) {
                bw.write("Case "+num+": Pangram!");
            } else if(min == 2) {
                bw.write("Case "+num+": Double pangram!!");
            } else {
                bw.write("Case "+num+": Triple pangram!!!");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
