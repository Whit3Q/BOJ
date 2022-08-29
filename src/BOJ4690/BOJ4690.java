package BOJ4690;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BOJ4690 {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        for(int a = 1; a < 101; a++) {
            for(int b = 2; b < a; b++) {
                for(int c = b; c < a; c++) {
                    for(int d = c; d < a; d++) {
                        if(a*a*a == (b*b*b)+(c*c*c)+(d*d*d)) {
                            bw.write("Cube = "+a+", Triple = ("+b+","+c+","+d+")\n");
                        }
                    }
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
