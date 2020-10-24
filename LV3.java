import java.util.Scanner;

public class LV3 {
    public static void main(String[] args) {
        LV3restaurant a = new LV3restaurant();
        a.welcome();
        LV3food b = new LV3food();
        int need1 = b.order1();
        LV3dishes c = new LV3dishes();
        int need2 = c.order2();
        int addUp = need1 +need2;
        System.out.println("共计" + addUp + "元");
        LV3customer d = new LV3customer();
        d.ask(addUp);
    }
}