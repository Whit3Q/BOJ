package BOJ14912;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ14912 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int D;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int result = 0;
        for(int i = 0; i <= N; i++) {
            int tmp = i;
            while(tmp != 0) {
                if(tmp % 10 == D) {
                    result++;
                }
                tmp /= 10;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
