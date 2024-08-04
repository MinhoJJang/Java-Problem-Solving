package BOJ_21763;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int max(int n){
        if(n <= 2) return n-1;
        return n*n - n;
    }

    static void printBingo(char[][] bingo){
        for (int i = 0; i < bingo.length; i++) {
            System.out.println(bingo[i]);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String answer = "NO";
        char[][] bingo = new char[n][n];
        for (int i = 0; i < bingo.length; i++) {
            Arrays.fill(bingo[i], '.');
        }
        if(k <= max(n)){
            answer = "YES";
            int cnt = 0;
            boolean finished = false;

            if(k == 0) finished = true;

            if(n % 2 != 0){
                for (int i = 0; i < bingo.length; i++) {

                    if(finished) break;

                    for (int j = 0; j < bingo.length; j++) {
                        if(i == j) continue;
                        bingo[i][j] = '#';
                        cnt++;

                        if(cnt == k) {
                            finished = true; 
                            break;
                        }
                    }
                }
            } 
            else {
                int point = n / 2;
                for (int i = 0; i < bingo.length; i++) {

                    if(finished) break;

                    for (int j = 0; j < bingo.length; j++) {
                       
                        // 그리면 안되는 경우
                        if(i == j && !((i == point - 1 && j == point - 1) || (j == point && i == point))) {
                            continue;
                        }

                        if((i == point - 1 && j == point) || (j == point - 1 && i == point)) {
                            continue;
                        }

                        bingo[i][j] = '#';
                        cnt++;

                        if(cnt == k) {
                            finished = true; 
                            break;
                        }
                    }
                }
            }

            System.out.println(answer);
            printBingo(bingo);
        }
        else {
            System.out.println(answer);
        }
    }
}