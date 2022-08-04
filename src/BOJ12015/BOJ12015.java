package BOJ12015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ12015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static LinkedList<Integer> list = new LinkedList<>();
    static int N;

    public static int solve() {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
            System.out.println("Exception");
            return -1;
        }
        LIS lis = new LIS();
        for(int i = 0; i < N; i++) {
            lis.add(Integer.parseInt(st.nextToken()));
        }

        return lis.maxSize();
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        bw.write(solve()+"");

        bw.flush();
        bw.close();
    }

    static class LIS {
        ArrayList<Integer> list;
        int lastIndex;
        int getLastValue;
        public LIS() {
            list = new ArrayList<>();
            list.add(0);
            lastIndex = 0;
            getLastValue = 0;
        }

        public void add(int num) {
            int index = lastIndex;
            if(getLastValue == num) {
                return;
            } else if(getLastValue > num) {
                index = binary(0,lastIndex,num);
                list.set(index, num);
                if(lastIndex == index) {
                    getLastValue = num;
                }
            } else {
                list.add(num);
                getLastValue = num;
                lastIndex++;
            }
        }

        public int maxSize() {
            return list.size() - 1;
        }

        private int binary(int start, int end, int num) {
            if(start >= end) {
                return end;
            }
            int mid = (start + end) / 2;

            if(list.get(mid) >= num) {
                return binary(start, mid, num);
            } else {
                return binary(mid + 1, end, num);
            }

        }
    }
}
