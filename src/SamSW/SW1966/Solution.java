package SamSW.SW1966;

import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int num = 0; num < N; num++) {
            M = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);

            bw.write("#"+num+" ");
//			for(Integer n : list) {
//				bw.write(n+" ");
//			}
            for(int i = 0; i < M; i++) {
                bw.write(list.get(i)+" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
