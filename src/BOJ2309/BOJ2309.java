package BOJ2309;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2309 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] field;
    static boolean[] check;
    static int[] arr;

    private static void check(int idx, int sum) {
        if (sum > 100) {
            return;
        }
        int size=0;
        if (idx == 9) {
            if (sum == 100) {
                int cnt = 0;
                for (int i = 0; i < 9; i++) {
                    if (check[i])
                        cnt++;
                }
                if (cnt == 7) {
                    for (int i = 0; i < 9; i++) {
                        if (check[i])
                            arr[size++]= field[i];
                    }
                }
            }
            return;
        }
        check[idx] = true;
        check(idx + 1, sum + field[idx]);
        check[idx] = false;
        check(idx + 1, sum);
    }

    public static boolean dfs(int[] field, int index, int count, int max, LinkedList<Integer> result) {
        if(max == 100 && count == 0) {
            return true;
        }

        if(index > 8 || count <= 0) {
            return false;
        }


        if(dfs(field, index + 1, count - 1, max + field[index], result)) {
            result.add(field[index]);
            return true;
        } else if(dfs(field, index + 1, count , max, result)){
            return true;
        }
        return false;
    }

    public static int[] twoPointerSolve(int[] field, int sum) {
        Arrays.sort(field);
        int[] result = new int[7];
        int right = 8;
        int left = 0;
        int target = sum - 100;
        while(true) {
            int now = field[left] + field[right];
            if(target > now) {
                left++;
            } else if(target < now) {
                right--;
            } else {
                int j = 0;
                for(int i = 0; i < 9; i++) {
                    if(i == right || i == left) continue;
                    result[j] = field[i];
                    j++;
                }
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        field = new int[9];
        int sum = 0;
        for(int i = 0 ; i < 9; i++) {
            field[i] = Integer.parseInt(br.readLine());
            sum += field[i];
        }

        //dfs 풀이
//        LinkedList<Integer> result = new LinkedList<>();
//        dfs(field,0,7,0,result);
//        Collections.sort(result);
//        for(int n : result) {
//            bw.write(n+"\n");
//        }

        //TwoPointer 풀이
//        for(int i : twoPointerSolve(field, sum)) {
//            bw.write(i+"\n");
//        }

        //backtracking 풀이
        check = new boolean[9];
        arr = new int[7];
        Arrays.sort(field);
        check(0, 0);
        System.out.println();
        for(int x: arr) {
            System.out.println(x);
        }

        bw.flush();
        bw.close();
    }
}
