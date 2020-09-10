package 网易2020.字典序最小的排列;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 网易笔试：字典序最小的排列：给出一个长度为m的序列T，
 * 求一个长度为n且字典序最小的排列S，要求不改变原序列
 * 中元素的相对位置。
 */
public class Solution {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] s = new int[m];
        for(int i=0;i<m;i++){
            s[i] = scan.nextInt();
        }
        int[] t =a(s,n);
        for(int i=0;i<t.length-1;i++){
            System.out.print(t[i]);
            System.out.print(" ");
        }
        System.out.print(t[n-1]);
        System.out.print("\n");
    }
    public static int[] a(int[] s,int n){
        int[] t = new int[n];
        int m = s.length;
        int[] tmp = new int[n-m];
        HashSet<Integer> set = new HashSet<>();
        for(int i:s){
            set.add(i);
        }
        int index=1;
        for(int i=0;i<tmp.length;i++){
            while(set.contains(index))
                index++;
            tmp[i] = index++;
        }
        int index1 = 0;
        int index2 = 0;
        for(int i=0;i<t.length;i++){
            if(index1 <m && index2<n-m){
                if(s[index1] <= tmp[index2]){
                    t[i] = s[index1++];
                }else{
                    t[i] = tmp[index2++];
                }
            }else if(index1<m){
                t[i] = s[index1++];
            }else{
                t[i] = tmp[index2++];
            }
        }
        return t;
    }
}
