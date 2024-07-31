import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_28238 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] status = new int[n][5];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cases = 0;
        int[] count = new int[10];
        int[][] date = new int[10][5];
        int idx = 0;
        int max = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                date[cases][i] = 1;
                date[cases][j] = 1;

                // search all students
                for (int k = 0; k < n; k++) {
                    if(status[k][i] == 1 && status[k][j] == 1) {
                        count[cases]++;
                    }
                }

                if(max < count[cases]){
                    max = count[cases];
                    idx = cases;
                }

                cases ++;
            }
        }
        
        System.out.println(max);
        for (int i = 0; i < 5; i++) {
            System.out.print(date[idx][i] + " ");
        }
    }
}
