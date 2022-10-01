package BOJ1652;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static char[][] field;
    static int Y;
    static int X;
    static int Ysize;
    static int Xsize;

    public static void main(String[] args) throws IOException {
        Y = X = Integer.parseInt(br.readLine());
        field = new char[Y][X];

        String target = "..";
        for(int y = 0; y < Y; y++){
            String str = br.readLine();
            for(int x = 0; x < X; x++){
                field[y][x] = str.charAt(x);
            }
        }

        for(int y = 0; y < Y; y++){
            dfs(field[y], 0, 0);
        }

        for(int x = 0; x < X; x++) {
            dfs2(field, x, 0, 0);
        }


        System.out.println(Xsize + " " + Ysize);

    }

    public static void dfs(char[] chars, int index, int count) {
        if(index > chars.length-1) {
            if(count >= 2) {
                Xsize++;
            }
            return;
        }

        if(chars[index] == 'X') {
            if(count >= 2) {
                Xsize++;
            }
            dfs(chars, index + 1, 0);
        } else if(chars[index] == '.') {
            dfs(chars, index + 1, count+1);
        }

    }

    public static void dfs2(char[][] chars, int xIndex ,int index, int count) {
        if(index > chars.length-1) {
            if(count >= 2) {
                Ysize++;
            }
            return;
        }

        if(chars[index][xIndex]== 'X') {
            if(count >= 2) {
                Ysize++;
            }
            dfs2(chars, xIndex,index + 1, 0);
        } else if(chars[index][xIndex] == '.') {
            dfs2(chars, xIndex,index + 1, count+1);
        }

    }
}
