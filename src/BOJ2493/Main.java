package BOJ2493;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static Stack<Integer[]> stack;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        stack = new Stack<>();

        for(int i = 1 ; i <= N; i++) {
            int nowNum = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek()[0] < nowNum) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                bw.write("0 ");
            } else {
                bw.write(stack.peek()[1] + " ");
            }

            stack.add(new Integer[] {nowNum,i});

        }

        bw.flush();
        bw.close();
    }
}
