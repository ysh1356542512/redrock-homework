import java.util.Arrays;//导入Arrays 扩容作用
public class LV4 {
    public static void main(String[] args) {
        MutableArraylist list = new MutableArraylist();
        list.add1("红岩网校Android");
        list.add2(1,"a");
        list.add2(2,"b");
        list.add2(3,"c");
        list.add1("c");
        list.remove1(3);
        list.remove2("c");
        System.out.println(list.get(0));
        System.out.println("a内拥有："+list.size()+"个元素");
    }
}
class MutableArraylist {  //创建一个类
    private Object[] elementDate;   //定义一个Object数组
    private int size = 0;           //用于记录目前数组中有多少个元素 便于与数组的长度做比较 判断是否需要扩容
    public MutableArraylist() {     //创建一个无参数构造器
        this(4);                 //默认数组长度为4
    }
    public MutableArraylist(int x) {  //创建一个有参数构造器
        elementDate = new Object[x];
    }
    public void add1(Object obj) {   //该方法为默认按顺序将元素加入数组
        if(size == elementDate.length) {  //如果当size与数组长度相等 即数组已经满了  则用Arrays函数将数组扩容加1
            elementDate = Arrays.copyOf(elementDate,elementDate.length+1);
        }
        elementDate[size] = obj;    //若数组未满 则下一位为obj  若数组满了 则增加的那一位为obj
        size ++;      //  记录数组中元素加1
    }
    public void add2(int x,Object obj) {  //该方法为将元素指定加入数组中的某一位置
        if(x<0||x>size) {                 //若指定的位置小于0或超出数组长度，则报错
          throw new RuntimeException("数组越界"); //用throw抛出错误 否则会被catch块吃掉 程序会继续进行
        }
        if(size == elementDate.length) {   //和add1一样
            elementDate = Arrays.copyOf(elementDate,elementDate.length+1);
        }
        for(int i = 0;i<elementDate.length;i++) {   //构造循环
            if (i >= 0 && i < x) {                   //在x前的元素保持不动
                elementDate[i] = elementDate[i];
            } else if(i>x) {                        //在x后的元素向后移动一格
                elementDate[i] = elementDate[i-1];
            } else {                                //在x索引上加入obj
                elementDate[i] = obj;
            }

        }
        size++;
    }
    public void remove1(int index) {   //该方法删除某索引下的元素
        if(index<0||index>size) {         //报错
            throw new RuntimeException("数组越界");
        }
        for(int i = 0;i<size-1;i++) {      //原理与add2类似
            if(i>=0&&i<index) {
                elementDate[i] = elementDate[i];  //在index前不动
            } else if(i>=index&&i<size-1) {         //直接跳过index索引下的元素
                elementDate[i] = elementDate[i+1];
            }
        }
        size--;    //记录数组中的元素减一
    }
    public void remove2(Object obj) {      //该方法删除指定元素
        for (int i = 0;i<size;i++) {       //构建循环 当i索引下的元素与obj相等时  采取删除
            if(elementDate[i]==obj) {
                for(int j = 0;j<size-1;j++) {    //原理与add2类似
                    if(j>=0&&j<i) {
                        elementDate[j] = elementDate[j];
                    } else{
                        elementDate[j] = elementDate[j+1];
                    }
                }
            }
        }
        size --;   //记录数组中的元素减一
    }
    public Object get(int index) {   //该方法是得到某个索引下的元素
        if(index<0||index>size) {
            throw new RuntimeException("数组越界");
        }
        return elementDate[index];
    }
    public int size() {    //返回数组中元素的个数
        return size;
    }
}
