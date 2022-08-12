package BOJ1822;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1822_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringTokenizer st2;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> arr = new LinkedList<>();
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

        bw.write(result+"\n");
        Collections.sort(arr);
        for(int num : arr) {
            bw.write(num + " ");
        }
        bw.flush();
        bw.close();
    }
}
