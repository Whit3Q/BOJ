package BOJ11866;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int size;
    static long count;
    static int num;

    static long[] tree;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());

        num = 1;
        while (num < size) {
            num <<= 1;
        }

        tree = new long[num * 2];

        init(1, 1, size);


        long index = 1;
        long nowNum = 0;
        bw.write("<");

        for (int i = 0; i < size; i++) {

            int peopleSize = size - i;
            index += count - 1;

            if (index % peopleSize == 0) {
                index = peopleSize;
            } else if (index > peopleSize) {
                index %= peopleSize;
            }


            int num = (int) query(1, 1, size, index);


            update(num, 1, 1, size);

            if (i == size - 1) {
                bw.write(String.valueOf(num));
            } else {
                bw.write(num + ", ");
            }
        }
        bw.write(">");

        bw.flush();
        bw.close();
    }

    public static void update(long target, int node, int start, int end) {
        if (start == end) { //리프노드 일때
            tree[node] = 0;
            return;
        }
        int mid = (start + end) / 2;
        if (target <= mid) {
            update(target, 2 * node, start, mid);
        } else {
            update(target, 2 * node + 1, mid + 1, end);
        }
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }


    public static long query(int node, int start, int end, long order)
    {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;

        if (order <= tree[2 * node]) {
            return query(2 * node, start, mid, order);
        } else {
            return query(2 * node + 1, mid + 1, end, order - tree[2 * node]);
        }

    }

    public static long init(int node, int start, int end) {
        if (start == end) {
            tree[node] = 1;
            return tree[node];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(2 * node, start, mid) + init(2 * node + 1, mid + 1, end);
    }
}