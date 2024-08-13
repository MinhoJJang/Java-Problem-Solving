package BOJ_28251;

import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static int findParent(int n){
        if(parent[n] != n){
            parent[n] = findParent(parent[n]);
        }
        return parent[n];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        long[] power  = new long[N+1];
        Map<Integer, ArrayList<Integer>> group = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        // 나도리 파워 받기
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(Integer.parseInt(st.nextToken()));
            group.put(i, arr);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = a;

            if(a > b){
                b = temp;
                a = b;
            }
            
            // 1. 각 그룹원의 부모를 찾아, 해당 부모와 연결된 그룹의 곱을 구해 더하고 answer에 추가 
            int pa = findParent(a);
            int pb = findParent(b);

            if(pa == pb) {
                bw.append(power[pa] + "\n");
                continue;
            }

            ArrayList<Integer> pa_arr = group.get(pa);
            ArrayList<Integer> pb_arr = group.get(pb);
            long ans = 0;

            long qw1 = 0;
            long qw2 = 0;

            for(Integer pa1 : pa_arr){
                qw1 += pa1;
            }

            for(Integer pb1 : pb_arr){
                qw2 += pb1;
            }
            
            ans = qw1 * qw2;

            power[pa] += (ans + power[pb]);
            bw.append(power[pa]+"\n");
            
            // 2. 부모를 연결
            parent[pb] = pa;

            // 3. 연결된 부모에다 두 그룹을 더한다. 이를 맵에 저장한다. 합쳐진 부분은 맵에서 삭제한다.
            pa_arr.addAll(pb_arr);    
            group.remove(pb);
            group.put(pa, pa_arr);
        }

        bw.flush();
    }
}
