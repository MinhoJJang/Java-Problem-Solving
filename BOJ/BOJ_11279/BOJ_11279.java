package BOJ_11279;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11279 {
    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                int w = 0;
                if(!pq.isEmpty()){
                    w = pq.remove();
                }
                bw.write(w + "\n");
            }
            else {
                pq.add(num);
            }
        }

        bw.flush();
    }
}
