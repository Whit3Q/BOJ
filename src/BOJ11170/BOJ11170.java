package BOJ11170;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11170 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int result = 0;
            if(N == 0) {
                result++;
                N++;
            }
            for(int i = N; i < M + 1; i++) {
                int tmp = i;
                while(tmp > 0) {
                    if(tmp % 10 == 0) {
                        result++;
                    }
                    tmp /= 10;
                }
            }
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }
}
