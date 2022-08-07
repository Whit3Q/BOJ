package BOJ3003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ3003 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] check = {1,1,2,2,2,8};


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 6; i++) {
            bw.write(check[i] - Integer.parseInt(st.nextToken()) + " ");
        }

        bw.flush();
        bw.close();
    }
}
