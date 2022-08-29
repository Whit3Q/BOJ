package BOJ10448;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10448 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T;
    static int N;
    static int[] field;

    public static boolean solve(int N, int[] field) {
        for(int i = 1; i < 45; i++) {
            for(int j = 1; j < 45; j++) {
                for(int k = 1; k < 45; k++) {
                    if(field[i]+field[j]+field[k] == N) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        field = new int[45];
        for(int i = 1; i < 45; i++) {
            field[i] = i * (i + 1) / 2;
        }

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            if(solve(N, field)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
