package BOJ1822;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1822_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringTokenizer st2;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        int result = 0;

        for(int i = 0; i < M; i++) {
            hs.add(Integer.parseInt(st2.nextToken()));
        }

        for(int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(!hs.contains(tmp)) {
                arr.add(tmp);
                result++;
            }
        }

        Collections.sort(arr);
        sb.append(arr.size()).append("\n");

        for (int idx : arr) {
            sb.append(idx).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
