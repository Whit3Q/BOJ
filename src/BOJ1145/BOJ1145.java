package BOJ1145;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1145 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int M;
    static int[] field;

    public static int solve(int[] field) {
        for (int i = 1; i < 1000000; i++) {
            int count = 0;
            for(int j = 0; j < 5; j++) {
                if(i%field[j] == 0) {
                    count++;
                }
            }
            if(count >= 3) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        field = new int[5];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            field[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solve(field) + "");
        bw.flush();
        bw.close();
    }
}
