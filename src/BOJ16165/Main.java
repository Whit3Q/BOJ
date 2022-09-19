package BOJ16165;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        HashMap<String, String> member = new HashMap<>();
        HashMap<String, TreeSet<String>> team = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String teamName = br.readLine();
            int size = Integer.parseInt(br.readLine());
            TreeSet<String> tmp = new TreeSet<>();
            team.put(teamName, tmp);

            for (int j = 0; j < size; j++) {
                String tmpName = br.readLine();

                member.put(tmpName, teamName);
                tmp.add(tmpName);
            }
        }

        for (int i = 0; i < M; i++) {
            String tmpName = br.readLine();
            int command = Integer.parseInt(br.readLine());
            if (command == 1) {
                bw.write(member.get(tmpName) + "\n");
            } else {
                TreeSet<String> now = team.get(tmpName);

                for (String tm : now) {
                    bw.write(tm + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
