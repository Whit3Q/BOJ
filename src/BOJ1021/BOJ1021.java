package BOJ1021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static int result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        CircularQueue queue = new CircularQueue();

        for(int i = 1; i < N+1; i++) {
            queue.backAdd(i);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int index = queue.find(target);
            if(queue.size() - index > index) {
                for(int j = 0; j < index; j++) {
                    queue.FrontTurn();
                    result++;
                }
                queue.remove();
            } else {
                int T = queue.size() - index;
                for(int j = 0; j < T; j++) {
                    queue.BackTurn();
                    result++;
                }
                queue.remove();
            }
        }


        bw.write(result+"");

        bw.flush();
        bw.close();
    }

    static class CircularQueue {
        LinkedList<Integer> queue;

        public CircularQueue() {
            queue = new LinkedList<>();
        }

        public void backAdd(int num) {
            queue.add(num);
        }

        public void FrontAdd(int num) {
            queue.add(0,num);
        }

        public void FrontTurn() {
            int tmp = remove();
            backAdd(tmp);
        }

        public void BackTurn() {
            int tmp = queue.remove(queue.size()-1);
            FrontAdd(tmp);
        }

        public int remove() {
            return queue.remove(0);
        }

        public int find(int num) {
           return queue.indexOf(num);
        }

        public int size() {
            return queue.size();
        }
    }
}