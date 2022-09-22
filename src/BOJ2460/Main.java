package BOJ2460;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int result = 0;
        int now = 0;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int sub = Integer.parseInt(st.nextToken());
            int sum = Integer.parseInt(st.nextToken());
            now += -sub+sum;
            result = Math.max(result, now);
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
