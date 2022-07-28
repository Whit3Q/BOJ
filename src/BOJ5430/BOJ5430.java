package BOJ5430;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ5430 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T;
    static int N;


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String command = br.readLine();
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(),"[,]");
            Deque<Integer> list = new LinkedList<>();
            while(st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            boolean check = true;
            boolean error = false;

            for(int i = 0; i < command.length(); i++) {
                if(command.charAt(i) == 'R') {
                    check = !check;
                } else {
                    if(check) {
                        if(list.size() == 0) {
                            error = true;
                            break;
                        }
                        list.remove();
                    } else {
                        if(list.size() == 0) {
                            error = true;
                            break;
                        }
                        list.removeLast();
                    }
                }
            }

            if(error) {
                bw.write("error");
            } else {
                bw.write("[");
                if(check) {
                    int size = list.size();
                    for(int i = 0; i < size; i++) {
                        if(i == size-1) {
                            bw.write(list.remove()+"");
                            break;
                        }
                        bw.write(list.remove()+",");
                    }
                } else {
                    int size = list.size();
                    for(int i = 0; i < size; i++) {
                        if(i == size-1) {
                            bw.write(list.removeLast()+"");
                            break;
                        }
                        bw.write(list.removeLast()+",");
                    }

                }
                bw.write("]");

            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

}
