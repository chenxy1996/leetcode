package 网易.教授互相认可;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static int count = 0;
    static Stack<Integer> stack = new Stack<>();
    static int[] dfn;
    static int[] low ;
    static boolean[] inStack;   //看当前节点是否在栈中
    static ArrayList<edge>[] graph;
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    static class edge {
        public int u;  //边的起点
        public int v;  //边的终点
        edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    private static void tarjan(ArrayList<edge>[] graph, int cur){
        dfn[cur] = low[cur] = count++;
        inStack[cur] = true;
        stack.push(cur);
        int next = cur;
        for (int i = 0; i < graph[cur].size(); i++) {
            next = graph[cur].get(i).v;
            if (dfn[next] == -1){
                tarjan(graph, next);
                low[cur] = Math.min(low[cur], low[next]);
            }else if (inStack[next]){
                low[cur] = Math.min(low[cur], dfn[next]);
            }
        }
        if (dfn[cur] == low[cur]){
            ArrayList<Integer> temp = new ArrayList<>();
            while(cur != next){
                next = stack.pop();
                temp.add(next);
                inStack[next] = false;
            }
            result.add(temp);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int proNum = sc.nextInt();
        int relNum = sc.nextInt();
        dfn = new int[proNum];
        low = new int[proNum];
        inStack = new boolean[proNum];
        Arrays.fill(dfn, -1);   //-1表示节点未被遍历
        Arrays.fill(low, -1);
        Arrays.fill(inStack, false);
        graph = new ArrayList[proNum];
        for (int i = 0; i < proNum; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < relNum; i++) {
            int u = sc.nextInt() - 1;   //因为输入的节点是从1开始的，而数组是0开始的，因此把教授编号也转化为从0开始。
            int v = sc.nextInt() - 1;
            graph[u].add(new edge(u, v));
        }
        tarjan(graph, 1);
        int res = 0;
        for (ArrayList<Integer> list : result) {
            int num = list.size();
            res += (num - 1) * num / 2;     //每个强连通分量中两两认可的个数为(n-1)*n/2
        }
        System.out.println(res);
    }
}
