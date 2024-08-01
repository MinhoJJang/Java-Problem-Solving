package BOJ_15552_B4;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());
        while(T > 0){
            String s = bf.readLine();
            String[] arr = s.split(" ");
            int answer = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
            bw.write(answer+"\n");
            T--;
        }
        bw.flush();
        bw.close();
    }
}
