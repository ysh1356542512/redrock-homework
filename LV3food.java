import java.util.Scanner;

public class LV3food {             //把food分开  在food类里确定食物种类和价格 方便修改
    String[] name = {"0", "辣子鸡丁", "水煮肉片", "糖醋里脊", "干锅牛肉", "干锅排骨"};
    int[] price = {0, 38, 22, 18, 38, 29};
    int[] list = {0, 1, 2, 3, 4, 5};

    public void meal1() {
        for (int i = 1; i < 6; i++) {
            System.out.println(list[i] + "." + name[i] + "  " + price[i] + "元");
        }
    }

    public int order1() {
        String d = "";
        int e = 0;
        int f = 0;             //用来记录菜品的个数(本来想用LV4里的size 但是发现y==2的时候不行)
        MutableArraylist foodList = new MutableArraylist();  //引用LV4里的数组类
        for (int i = 1; i <= 5; i++) {
            System.out.println("还有需要点的菜么？");
            meal1();
            System.out.println("请输入想要点的菜的序号(按0结束点餐)");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
                    if (x == 0) {
                        System.out.println("结束点餐");
                        System.out.println("一共消费" + e + "元");
                        break;
                    } else if (x >= 1 && x <= 5) {
                        for(int j = 0;j<=i-1;j++) {         //通过循环找到用户是否重复输入菜名
                            for (int k = 0; k <= i - 1; k++) {
                                foodList.add1(x);    //将用户点的菜记录在数组中
                                if(j!=k) {
                                    if (foodList.get(j)== (Object)x && foodList.get(j)==foodList.get(k)) {     //如果重复 给予用户选择是否确定选择
                                        System.out.println("您选择的菜名重复，是否确定选择(是请按1，否请按2)");
                                        int y = sc.nextInt();
                                        if (y == 1) {
                                            d = d + name[x] + "  " + price[x] + "元" + "\n";
                                            e = e + price[x];
                                            f++;         //菜品个数加一
                                            break;      //用break结束循环 防止数组中有三个重复的菜时多次打印
                                        } else if (y == 2) {
                                            foodList.remove1(i - 1);//若不选择 则将x从数组中移除
                                            f--;     // 用以区别 有菜名相等但y==2  和 无菜名重复 的情况
                                            break;  //sss
                                        }
                                    }
                                }
                            }
                            if(f==i || f==i-2) {     //确保y==1和y==2的情况只出现一次
                                break;
                            }
                        }
                        if(f == i-1) {   //当f为i-1 则判定为无菜名重复的情况
                            d = d + name[x] + "  " + price[x] + "元" + "\n";
                            e = e + price[x];
                            f++;      //菜品数加一
                        } else if (f == i-2) {
                            f++;      //菜品数恢复
                        }
                    }else {
                        System.out.println("查无此菜品");
                    }
                }
        System.out.println("你一共选择了：\n" + d);
        return e;
    }
}