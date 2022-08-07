package BOJ25304;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ25304 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int K;
    static int N;
    public static void main(String[] args) throws IOException {

        K = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        int tmp = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            tmp += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }

        if(tmp == K) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }

        bw.flush();
        bw.close();
    }
}
