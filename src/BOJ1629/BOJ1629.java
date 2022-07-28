package BOJ1629;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1629 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A;
    static int B;
    static int C;
    static long result;

    public static long solve(int A, int B, int C) {
        if(B == 1) {
            return A%C;
        }

        long tmp = 1;
        tmp *= solve(A, B/2, C);

        if(B % 2 != 0) {
            return tmp * tmp * A % C;
        } else {
            return tmp * tmp % C;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        result = solve(A,B,C);

        bw.write( result+"");
        bw.flush();
        bw.close();
    }
}
