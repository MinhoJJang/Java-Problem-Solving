//package BOJ_1925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static double getDist(int[] A, int[] B){
        return (A[0]-B[0]) * (A[0]-B[0]) + (A[1]-B[1]) * (A[1]-B[1]);
    }

    static String triangleStatus(double a, double b, double c){
        double res = c - (a + b);
        String status = "";
        if(res < 0){
            status = "Yeahkak";
        }
        else if(res == 0){
            status = "Jikkak";
        }
        else if(res > 0){
            status = "Dunkak";
        }
        return status;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] input = new int[3][2];
        double[] dist = new double[3];
        Stack<String> answer = new Stack<>();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        // 각 삼각형 길이 구하기
        for (int i = 0; i < 3; i++) {
            dist[i] = getDist(input[i], input[(i+1)%3]);
        }

        // 길이 중 최댓값
        Arrays.sort(dist);

        double a = dist[0];
        double b = dist[1];
        double c = dist[2];

        answer.add("Triangle");
        
        if(Math.sqrt(c) == Math.sqrt(a) + Math.sqrt(b)){
            System.out.println("X");
            return;
        }

        if(a == b && b == c){
            System.out.println("JungTriangle");
            return;
        }

        if(a == b || b == c || c == a){
            answer.add("2");
        }

        answer.add(triangleStatus(a, b, c));

        StringBuilder sb = new StringBuilder();

        while (!answer.isEmpty()) {
            sb.append(answer.pop());
        }

        System.out.println(sb);

    }
}
