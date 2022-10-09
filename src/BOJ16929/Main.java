package BOJ16929;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int Y;
    static int X;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    static char[][] field;
    static int[][] memory;
    static int[] alpaCounts;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        field = new char[Y][X];
        memory = new int[Y][X];
        alpaCounts = new int[26];


        for(int y = 0; y < Y; y++) {
            String line = br.readLine();
            for(int x = 0; x < X; x++) {
                char tmp = line.charAt(x);
                field[y][x] = tmp;
                alpaCounts[tmp - 'A']++;
            }
        }

        boolean check = false;
        loop:
        for(int y = 0; y < Y; y++) {
            for(int x = 0; x < X; x++) {
                if(alpaCounts[field[y][x] - 'A'] < 3) {
                    continue;
                }
                if(memory[y][x] > 0) {
                    continue;
                }
                if(dfs(y,x,1)) {
                    bw.write("Yes");
                    check = true;
                    break loop;
                }
            }

        }
        if(!check) {
            bw.write("No");
        }

        bw.flush();
        bw.close();
    }

    public static boolean dfs(int y , int x, int count) {
        char nowChar = field[y][x];
        memory[y][x] = count;
        boolean check = false;
        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newX < 0 || newY > Y -1 || newX > X - 1 || field[newY][newX] != nowChar) {
                continue;
            }

            if(memory[newY][newX] != 0) {
                if(memory[y][x] - memory[newY][newX] >= 3) {
                    check = true;
                    break;
                }
                continue;
            }

            check = dfs(newY, newX, count + 1);
            if(check) {
                break;
            }
        }

        return check;
    }


    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
