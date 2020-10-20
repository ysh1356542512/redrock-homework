import java.util.Scanner;
public class LV1 {
    public static void main(String[] args) {
        int[] arr = {15,25,10,30,40,20,50};
        System.out.println("冒泡排序后的结果：");
        change(arr);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个待插入的数：");
        int x = sc.nextInt();
        int[] arr1 = {15,25,10,30,40,20,50,x};
        System.out.print("插入数字("+x+")之后的数组为：");
        change(arr1);
    }
    public static void change(int[] arr) {
        int term = 0;
        for(int i = 0;i<arr.length-1;i++) {
            for(int j = 0;j<arr.length-1-i;j++) {
                if (arr[j] > arr[j+1]) {
                    term = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = term;
                }
            }

        }
        for(int x = 0;x<arr.length;x++) {
            System.out.print(arr[x]+" ");
        }
        System.out.println("");
    }
}

