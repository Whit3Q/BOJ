package BOJ1062;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int K;
    static char[] arr;
    static int result;
    static char[] chars = {'a','i','n','t','c','b','d','e','f','g','h','j','k','l','m','o','p','q','r','s','u','v','w','x','y','z'};
    static boolean[] memory;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        memory = new boolean[26];

        arr = new char[K];
        if(K < 5) {
            System.out.println("0");
            return;
        } else if ( K == 26) {
            System.out.println(N);
            return;
        }
        memory[0] = true;
        memory[1] = true;
        memory[2] = true;
        memory[3] = true;
        memory[4] = true;
        arr[K-5] = 'a';
        arr[K-4] = 't';
        arr[K-3] = 'n';
        arr[K-2] = 'i';
        arr[K-1] = 'c';

        ArrayList<char[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(br.readLine().toCharArray());
        }

        dfs(arr,list, chars, 5, 0);

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    public static void dfs(char[] arr, ArrayList<char[]> list, char[] chars, int index, int count) {
        if(count > K-5) {
            return;
        }
        if(index >= chars.length) {
            if(count != K-5) {
                return;
            }
            int num = 0;
            for(int i = 5; i < memory.length; i++) {
                if(memory[i]) {
                    arr[num] = chars[i];
                    num++;
                }
            }

            int resultCount = 0;
            main :
            for(char[] chs : list) {
                for(char c : chs) {
                    boolean check = false;
                    for(char cc : arr) {
                        if(c == cc) {
                            check = true;
                        }
                    }
                    if(check) {
                        continue;
                    } else {
                        continue main;
                    }
                }
                resultCount++;
            }

            result = Math.max(result, resultCount);
            return;
        }

        dfs(arr,list,chars, index+1,count);
        memory[index] = true;
        dfs(arr,list,chars, index+1,count+1);
        memory[index] = false;


    }
}
