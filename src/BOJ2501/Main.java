package BOJ2501;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        for(int i = 2; i <= N; i++) {
            if(N % i == 0) {
                result.add(i);
            }
        }
        if(K >= result.size()) {
            bw.write("0");
        } else {
            bw.write(result.get(K)+"");
        }

        bw.flush();
        bw.close();
    }
}
