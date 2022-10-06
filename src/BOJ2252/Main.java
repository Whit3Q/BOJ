package BOJ2252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[] memory;

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> link = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        N++;
        for(int i = 0; i < N; i++) {
            link.add(new ArrayList<>());
        }
        memory = new int[N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            link.get(start).add(end);
            memory[end]++;
        }
        int count = 1;
        Stack<Integer> stack2 = new Stack<>();
        for(int i = 1; i < N; i++) {
            if(memory[i] == 0) {
                stack2.add(i);
                memory[i] = -1;
            }
        }
        while(!stack2.isEmpty()) {
            int size = stack2.size();
            for(int i = 0; i < size; i++) {
                int now = stack2.pop();
                count++;
                stack.add(now);
                for(int j = 0 ; j < link.get(now).size(); j++) {
                    memory[link.get(now).get(j)]--;
                }

            }

            for(int i = 1; i < N; i++) {
                if(memory[i] == 0) {
                    stack2.add(i);
                    memory[i] = -1;
                }
            }
        }

        while(!stack.isEmpty()) {
            bw.write(stack.pop()+" ");
        }

        bw.flush();
        bw.close();
    }

}
