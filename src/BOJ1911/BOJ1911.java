package BOJ1911;

import java.io.*;
import java.util.*;

public class BOJ1911 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int L;

    public static int greedy(Queue<Puddle> queue) {
        int count = 0;
        int index = 0;
        while (queue.size() != 0) {
            Puddle puddle = queue.remove();


            if(puddle.start < index) {
                if (puddle.end < index) {
                    continue;
                } else {
                    int tmp = index - puddle.start;
                    puddle.length -= tmp;
                    puddle.start += tmp;
                    if(puddle.length == 0) continue;
                }
            }

            int tmp = puddle.length / L;
            if (tmp == 0) {
                index = puddle.start + L;
                count++;
            } else {
                count += puddle.length / L;
                index = puddle.start + (tmp * L); //다음 인덱스를 가르키기에 -1 안함
                if (puddle.length % L != 0) {
                    index += L;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        LinkedList<Puddle> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Puddle(start, end));
        }


        Collections.sort(list);


        System.out.println(greedy(list));
    }

    static class Puddle implements Comparable<Puddle> {
        int start;
        int end;
        int length;

        public Puddle(int start, int end) {
            this.start = start;
            this.end = end;
            length = this.end - this.start;
        }

        @Override
        public int compareTo(Puddle o) {
            return this.start - o.start;
        }
    }
}
