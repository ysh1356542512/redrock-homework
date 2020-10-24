import java.util.Scanner;

public class LV3restaurant {
    String name = "国民饭店";

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
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("支付成功 欢迎下次光~~~~~~~~~~临↑");
        }
    public void welcome() {
        System.out.println("欢迎来到" + name + ",这是今天的菜单：");
    }
}
