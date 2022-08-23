package BOJ16956;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ16956 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static String[][] field;
    static int[] memory;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public static int solve(ArrayList<int[]> list) {

        for(int[] now : list) {
            for(int i = 0; i < 4; i++) {
                int newY = now[0] + dy[i];
                int newX = now[1] + dx[i];

                if(newY < 0 || newX < 0 || newY > N -1 || newX > M - 1 || field[newY][newX].equals("W")) {
                    continue;
                }

                if(field[newY][newX].equals("S")) {
                    return 0;
                }

                field[newY][newX] = "D";
            }
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new String[N][M];

        ArrayList<int[]> sheep = new ArrayList<>();

        for(int y = 0; y < N; y++) {
            String line = br.readLine();
            for(int x = 0; x < M; x++) {
                char tmp = line.charAt(x);

                if(tmp == 'W') { //wolf
                    sheep.add(new int[] {y,x});
                }

                field[y][x] = String.valueOf(tmp);
            }
        }
        int result = solve(sheep);
        bw.write(result+"\n");

        if(result == 1) {
            for(int y = 0; y < N; y++) {
                for(int x=  0; x < M; x++) {
                    bw.write(field[y][x]+"");
                }
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
