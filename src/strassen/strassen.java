package strassen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class strassen {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] matrix;
    static int[][] matrix2;
    static int N;
    static int M;
    static int N2;
    static int M2;
    static int T = 128;

    //슈트라센 함수
    public static int[][] strassenRecur(int N, int[][] a, int[][] b) {
        if (N == 1) {
            int[][] result = matrixMul(a, b);
            return result;
        }

        //행렬 4등분
        int n = N / 2;
        int[][] A11 = splitMatrix(a, 0, 0, n);
        int[][] A12 = splitMatrix(a, 0, n, n);
        int[][] A21 = splitMatrix(a, n, 0, n);
        int[][] A22 = splitMatrix(a, n, n, n);

        int[][] B11 = splitMatrix(b, 0, 0, n);
        int[][] B12 = splitMatrix(b, 0, n, n);
        int[][] B21 = splitMatrix(b, n, 0, n);
        int[][] B22 = splitMatrix(b, n, n, n);

        //나눈 행렬의 합과 차 구하기
//        int[][] x1 = matrixAdd(A11, A22);
//        int[][] x2 = matrixAdd(B11, B22);
//        int[][] x3 = matrixAdd(A21, A22);
//        int[][] x4 = matrixSub(B12, B22);
//        int[][] x5 = matrixSub(B21, B11);
//        int[][] x6 = matrixAdd(A11, A12);
//        int[][] x7 = matrixSub(A21, A11);
//        int[][] x8 = matrixAdd(B11, B12);
//        int[][] x9 = matrixSub(A12, A22);
//        int[][] x10 = matrixAdd(B21, B22);

        //슈트라센 규칙 적용
        int[][] m1 = strassenRecur(n, matrixAdd(A11, A22), matrixAdd(B11, B22));
        int[][] m2 = strassenRecur(n, matrixAdd(A21, A22), B11);
        int[][] m3 = strassenRecur(n, A11, matrixSub(B12, B22));
        int[][] m4 = strassenRecur(n, A22, matrixSub(B21, B11));
        int[][] m5 = strassenRecur(n, matrixAdd(A11, A12), B22);
        int[][] m6 = strassenRecur(n, matrixSub(A21, A11), matrixAdd(B11, B12));
        int[][] m7 = strassenRecur(n, matrixSub(A12, A22), matrixAdd(B21, B22));
//        int[][] m1 = strassenRecur(n, x1, x2);
//        int[][] m2 = strassenRecur(n, x3, B11);
//        int[][] m3 = strassenRecur(n, A11, x4);
//        int[][] m4 = strassenRecur(n, A22, x5);
//        int[][] m5 = strassenRecur(n, x6, B22);
//        int[][] m6 = strassenRecur(n, x7, x8);
//        int[][] m7 = strassenRecur(n, x9, x10);


        //새로운 행렬에 합치기
        int[][] result = new int[N][N];
        conquerMatrix(result, matrixAdd(matrixSub(matrixAdd(m1, m4), m5), m7), 0, 0, n);
        conquerMatrix(result, matrixAdd(m3, m5), 0, n, n);
        conquerMatrix(result, matrixAdd(m2, m4), n, 0, n);
        conquerMatrix(result, matrixAdd(matrixSub(matrixAdd(m1, m3), m2), m6), n, n, n);

        return result;
    }

    //행렬 나누는 함수
    public static int[][] splitMatrix(int[][] matrix, int y, int x, int n) {
        int[][] result = new int[n][n];
        for (int dy = y; dy < y + n; dy++) {
            for (int dx = x; dx < x + n; dx++) {
                result[dy - y][dx - x] = matrix[dy][dx];
            }
        }

        return result;
    }

    //행렬 합치는 함수
    public static int[][] conquerMatrix(int[][] result, int[][] matrix, int y, int x, int n) {
        for (int dy = y; dy < y + n; dy++) {
            for (int dx = x; dx < x + n; dx++) {
                result[dy][dx] = matrix[dy - y][dx - x];
            }
        }

        return result;
    }

    //행렬 합치는 함수 행과 열 크기를 n과 m에 넣으면 result에 복사해줌
    public static int[][] conquerMatrix(int[][] result, int[][] matrix, int y, int x, int n, int m) {
        for (int dy = y; dy < y + n; dy++) {
            for (int dx = x; dx < x + m; dx++) {
                result[dy][dx] = matrix[dy - y][dx - x];
            }
        }

        return result;
    }

    //행렬 합
    public static int[][] matrixAdd(int[][] matrix, int[][] matrix2) {
        int n = matrix.length;
        int[][] result = new int[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                result[y][x] = matrix[y][x] + matrix2[y][x];
            }
        }

        return result;
    }

    //행렬 차
    public static int[][] matrixSub(int[][] matrix, int[][] matrix2) {
        int n = matrix.length;
        int[][] result = new int[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                result[y][x] = matrix[y][x] - matrix2[y][x];
            }
        }

        return result;
    }


    //행렬 곱
    public static int[][] matrixMul(int[][] matrix, int[][] matrix2) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                for (int i = 0; i < n; i++) {
//                    result[y][x] += (matrix[i][x] * matrix2[y][i]) % MOD;
                    result[y][x] += matrix[i][x] * matrix2[y][i];
                }
//                result[y][x] %= MOD;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

//        N = Integer.parseInt(br.readLine());
//
//        matrix = new int[N][N];
//        matrix2 = new int[N][N];
//
//        for (int y = 0; y < N; y++) {
//            st = new StringTokenizer(br.readLine());
//            for (int x = 0; x < N; x++) {
//                matrix[y][x] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int y = 0; y < N; y++) {
//            st = new StringTokenizer(br.readLine());
//            for (int x = 0; x < N; x++) {
//                matrix2[y][x] = Integer.parseInt(st.nextToken());
//            }
//        }

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
//        int T = 1;
//        while(N > T) {
//            T = T << 1;
//        }
//        int[][] tmp = new int[N][M];
        //행렬 1 입력받기
        matrix = new int[T][T];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                matrix[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        N2 = Integer.parseInt(st.nextToken());
        M2 = Integer.parseInt(st.nextToken());
//        int T2 = 1;
//        while(M2 > T2) {
//            T2 = T2 << 1;
//        }
//        int T3 = Math.max(T, T2);

//        matrix = new int[T3][T3];
//        matrix2 = new int[T3][T3];
        //행렬 2 입력받기
        matrix2 = new int[T][T];
        for (int y = 0; y < N2; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M2; x++) {
                matrix2[y][x] = Integer.parseInt(st.nextToken());
            }
        }

//        conquerMatrix(matrix, tmp,0,0,N,M);

        int[][] result = strassenRecur(T, matrix, matrix2);

        //출력
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M2; x++) {
                bw.write(result[y][x] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

}
