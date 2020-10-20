import java.util.Scanner;
import java.util.Random;
public class LV2 {
    public static void main(String[] args) {
        System.out.println("请为对称矩阵输入行列数");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("随机对称矩阵A：");
        int[][] arr1 = new int[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                Random r = new Random();
                int b = r.nextInt(9) + 1;
                arr1[i][j] = b;
            }
        }
        for(int i = 0;i<x;i++) {
            for(int j = 0;j<x;j++) {
                System.out.print(arr1[i][j]+"  ");
            }
            System.out.println("");
        }
        System.out.println("随机对称矩阵B：");
        int[][] arr2 = new int[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                Random r = new Random();
                int b = r.nextInt(9) + 1;
                arr2[i][j] = b;
            }
        }
        for(int i = 0;i<x;i++) {
            for(int j = 0;j<x;j++) {
                System.out.print(arr2[i][j]+"  ");
            }
            System.out.println("");
        }
        System.out.println("相乘后的对称矩阵：");
        int[][] arr3= new int[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < x; k++) {
                    arr3[i][j] =arr3[i][j]+arr1[i][k] * arr2[k][j];
                }
                System.out.print(arr3[i][j] +"  ");
            }
            System.out.println("");
        }
        int add = 0;
        for(int i = 0;i<x;i++) {
            add = add + arr3[i][i];
        }
        System.out.print("此矩阵对角线的和为："+add);
    }
}