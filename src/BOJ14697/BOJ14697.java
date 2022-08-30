package BOJ14697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int A;
    static int B;
    static int C;
    static int N;

    public static boolean solve(int A, int B, int C, int N) {
        for(int a = 0; a <= (N/A); a++) {
            for(int b = 0; b <= (N/B); b++) {
                for(int c = 0; c <= (N/C); c++) {
                    if(a*A + b*B + c*C == N) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        if(solve(A,B,C,N)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
