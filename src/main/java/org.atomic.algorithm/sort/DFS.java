package org.atomic.java.sort;

/**
 *  打印1~n的全排列
 */
public class DFS {

    public static void dfs(int n){
        int[] arr = new int[n];
        int[] book = new int[n];
        dfs(0,arr,book);
    }

    private static void dfs(int step, int[] arr, int[] book){
        if(step==arr.length){
            for(int i=0; i<arr.length; i++){
                System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(book[i]==0){
                arr[step]=i+1;
                book[i] = 1;
                dfs(step+1,arr,book);
                book[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
//        dfs(4);

        int a = 10;
        int b = 10;
        int c = 10;

        a = b++;
        System.out.println("a=" +a);
        System.out.println("b=" +b);
        System.out.println("c=" +c);
        System.out.println("===========");
        c = --a;
        System.out.println("a=" +a);
        System.out.println("b=" +b);
        System.out.println("c=" +c);
        System.out.println("===========");
        b = ++a;
        System.out.println("a=" +a);
        System.out.println("b=" +b);
        System.out.println("c=" +c);
        System.out.println("===========");
        a = c--;
        System.out.println("a=" +a);
        System.out.println("b=" +b);
        System.out.println("c=" +c);
        System.out.println("===========");

        int a1 = 10;
        int b1 = 20;
        a1 = a1 ^ b1;
        System.out.println("a1=" +a1);
        System.out.println("b1=" +b1);

        b1 = a1 ^ b1;
        System.out.println("a1=" +a1);
        System.out.println("b1=" +b1);

        a1 = a1 ^ b1;
        System.out.println("a1=" +a1);
        System.out.println("b1=" +b1);

    }
}
