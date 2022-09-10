package BOJ7785;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        HashSet<String> hs = new HashSet<>();
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        while (N-- > 0) { // TreeSet 사용
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if (state.equals("enter")) {
                ts.add(name);
            } else {
                ts.remove(name);
            }
        }

        Iterator<String> it = ts.iterator();
        while (it.hasNext()) {
            bw.write(it.next());
            bw.newLine();
        }
//        HashSet 사용
//        while(N-- > 0) {
//            st = new StringTokenizer(br.readLine());
//            String name = st.nextToken();
//            String state = st.nextToken();
//            if(state.equals("enter")) {
//                hs.add(name);
//            } else {
//                hs.remove(name);
//            }
//
//        }
//        Iterator<String> it = hs.stream().sorted(Collections.reverseOrder()).iterator();
//        while(it.hasNext()) {
//            bw.write(it.next());
//            bw.newLine();
//        }

        bw.flush();
        bw.close();
    }
}
