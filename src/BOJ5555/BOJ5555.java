package BOJ5555;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ5555 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static String target;
    static char[][] chars;
    public static void main(String[] args) throws IOException {
        target = br.readLine();
        N = Integer.parseInt(br.readLine());
        chars = new char[N][20];
        int result = 0;
        for(int i = 0; i < N; i++) {
            String tmp = br.readLine();
            tmp = tmp + tmp;
            if(tmp.matches(".*"+target+".*")) {
                result++;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
