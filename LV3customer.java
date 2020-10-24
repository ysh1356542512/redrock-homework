import java.util.Scanner;
public class LV3customer {
    public void ask(int need) {         //办卡
        LV3restaurant a = new LV3restaurant();
        MutableArraylist Number = new MutableArraylist();      //用LV4建立三个数组 记录卡号 名字 余额
        MutableArraylist Name = new MutableArraylist();
        MutableArraylist Money = new MutableArraylist();
        System.out.println("您是否是会员(是输入1 否输入2)");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if(x==2) {
            System.out.println("您是否需要办卡(是输入1  否输入2)");
            int y = sc.nextInt();
            if(y==2) {
                a.pay();
            } else if(y==1) {
                int number = 0;
                System.out.println("------以下为办卡界面 请填写信息------");
                System.out.print("请输入您的姓名：");
                String name = sc.next();
                Name.add1(name);
                Number.add1(number);
                System.out.println("您的卡号为:"+Number.get(number));      //先将用户办的卡的卡号输出
                number ++;                                               //随后再将number加1
                System.out.println("您是否需要充钱(是输入1 否输入2");
                int z = sc.nextInt();
                if (z==2) {
                    a.pay();
                } else if(z==1) {
                    System.out.println("请选择要充值的数量：\n"+"1.五十元  2.一百元  3.一百五十元");
                    int inMoney = sc.nextInt();
                    System.out.println("请支付-----");
                    Money.add1(inMoney);
                    payMoney(need,Money.get(number-1));//因为前面number加了1 所以卡号应该number-1
                }
            }
        } else if (x==1) {
            System.out.print("请输入您的卡号：");
            int card = sc.nextInt();
            System.out.println("名字为：" + Name.get(card) +"余额为：" + 50*(int)Money.get(card));
            System.out.println("是否需要使用余额(是则1 否则2)");
            int IF = sc.nextInt();
            if(IF == 1) {
                payMoney(need,Money.get(card));
            } else if (IF ==2) {
                a.pay();
            }
        } else {
            throw new RuntimeException("查无此卡");
        }
    }
    public void addMoney(Object card){
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择要充值的数量：\n"+"1.五十元  2.一百元  3.一百五十元");
        int inMoney = sc.nextInt();
        System.out.println("请支付-----");
        card = 50*(int)card +inMoney;
        System.out.println("余额为："+card);
    }
    public void payMoney(int index,Object s){
        int LastMoney =50*(int)s -index;
        System.out.println("------支付中------");
        if(LastMoney >=0) {
            s = (Object)LastMoney;
            System.out.println("余额为："+s);
        } else {
            System.out.println("余额不足，请充值");
            addMoney(s);
        }
        System.out.println("支付成功 欢迎下次光~~~~~~~~~~~~临↑");
    }
}
