package BOJ_28251;

import java.io.*;
import java.util.*;

public class GPT {

    static int[] parent, size;
    static long[] power, groupSum;

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
        size = new int[N+1];
        power = new long[N+1];
        groupSum = new long[N+1];

        st = new StringTokenizer(br.readLine());

        // 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
            long val = Long.parseLong(st.nextToken());
            power[i] = 0;
            groupSum[i] = val;
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int pa = findParent(a);
            int pb = findParent(b);

            if(pa == pb) {
                bw.append(power[pa] + "\n");
                continue;
            }

            // 작은 그룹을 큰 그룹에 병합
            if(size[pa] < size[pb]) {
                int temp = pa;
                pa = pb;
                pb = temp;
            }

            // pa가 더 큰 그룹, pb가 작은 그룹
            power[pa] += power[pb] + groupSum[pa] * groupSum[pb];
            groupSum[pa] += groupSum[pb];
            parent[pb] = pa;
            size[pa] += size[pb];

            bw.append(power[pa] + "\n");
        }

        bw.flush();
    }
}