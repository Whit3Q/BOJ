package BOJ6198;

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
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        long result = 0;

        for (int i = 0; i < N; i++) {
            int nowNum = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= nowNum) {
                stack.pop();
            }

            stack.add(nowNum);

            result += stack.size() - 1;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
