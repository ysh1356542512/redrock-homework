import java.util.Scanner;

public class LV3 {
    public static void main(String[] args) {
        restaurant a = new restaurant();
        a.name = "国民饭店";
        a.welcome();
        food b = new food();
        b.name = new String[]{"0", "辣子鸡丁", "水煮肉片", "糖醋里脊", "干锅牛肉", "干锅排骨"};
        b.price = new int[]{0, 38, 22, 18, 38, 29};
        b.list = new int[]{0, 1, 2, 3, 4, 5};
        String d = "";
        int e = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println("还有需要点的菜么？");
            b.c();
            System.out.println("请输入想要点的菜的序号(按0结束点餐)");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            if (x == 0) {
                System.out.println("结束点餐");
                System.out.println("一共消费" + e + "元");
                break;
            } else if(x>=1&&x<=5) {
                d = d + b.name[x] + "  " + b.price[x] + "元" + "\n";
                e = e + b.price[x];
            } else{
                System.out.println("查无此菜品");
            }
            System.out.println("你一共选择了：\n" + d + "共计" + e + "元");
        }
        a.pay();
        a.goodbye();
    }
}

class food {
    String[] name;
    int[] price;
    int[] list;

    public void c() {
        for (int i = 1; i < 6; i++) {
            System.out.println(list[i] + "." + name[i] + "  " + price[i] + "元");
        }
    }
}

class restaurant {
    String name;

    public void pay() {
        System.out.println("请选择支付方式\n" + "1.支付宝\n" + "2.微信\n" + "3.人脸识别");
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        switch (f) {
            case 1:
            case 2:
                System.out.println("请出示付款码");
                break;
            case 3:
                System.out.println("请凑近您帅气的脸");
                break;
            default:
                System.out.println("暂无此支付方式");
                break;
        }
    }

    public void welcome() {
        System.out.println("欢迎来到" + name + ",这是今天的菜单：");
    }

    public void goodbye() {
        System.out.println("支付成功 欢迎下次光~~~~~~~~~~临↑");
    }
}
