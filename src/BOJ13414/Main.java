package BOJ13414;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int K;
    static int L;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> hs = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String tmp = br.readLine();
            if (hs.contains(tmp)) {
                hs.remove(tmp);
            }
            hs.add(tmp);
        }
        Iterator<String> it = hs.iterator();
        for (int i = 0; i < K; i++) {
            if (it.hasNext()) {
                bw.write(it.next() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

}
