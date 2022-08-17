package BOJ1267;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1267 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int Y = 0;
        int M = 0;

        for (int i = 0; i < N; i++) {
            int time = Integer.parseInt(st.nextToken());
            Y += ((time / 30) + 1) * 10;
            M += ((time / 60) + 1) * 15;
        }

        if (Y == M) {
            System.out.println("Y " + "M " + M);
        } else if (Y > M) {
            System.out.println("M " + M);
        } else {
            System.out.println("Y " + Y);
        }
    }
}
