package BOJ2204;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ2204 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        while((N = Integer.parseInt(br.readLine())) != 0) {
            String[] dic = new String[N];
            HashMap<String, String> hm= new HashMap<>();
            for(int i = 0; i < N; i++) {
                String str = br.readLine();
                dic[i] = str.toLowerCase();
                hm.put(dic[i],str);
            }

            Arrays.sort(dic);
            bw.write(hm.get(dic[0]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
