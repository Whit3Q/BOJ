package BOJ1755;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1755 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] arr = new String[] {"ze", "on", "tw", "th", "fo", "fi", "si", "se", "ei", "ni"};
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = N;i <= M; i++) {
            Stack<Integer> stack = new Stack<>();
            StringBuilder now = new StringBuilder();
            int tmp = i;
            while(tmp > 0) {
                stack.add(tmp%10);
                tmp /= 10;
            }
            while(!stack.empty()) {
                int num = stack.pop();
                now.append(arr[num]);
                now.append(" ");
            }
            hm.put(String.valueOf(now.toString()),i);
        }

        List<String> list = new ArrayList<>(hm.keySet());
        Collections.sort(list);
        int count = 0;
        for(String n : list) {
            bw.write(hm.get(n)+ " ");
            count++;
            if(count == 10) {
                count = 0;
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
