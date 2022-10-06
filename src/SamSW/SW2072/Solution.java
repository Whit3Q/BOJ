package SamSW.SW2072;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int result = 0;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                int tmpNum = Integer.parseInt(st.nextToken());
                if(tmpNum%2 == 0) {
                    continue;
                }
                result += tmpNum;
            }
            bw.write("#"+(i+1) + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
