package New_Package;

import java.util.Scanner;

public class Keyboard_input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个整数:");
        int a = sc.nextInt();
        System.out.print("请输入第二个整数:");
        int b = sc.nextInt();
        int c = a + b;
        System.out.print("两个整数的和为:"+ c);

        //练习数据拆分
/*        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个三位数的整数:");
        int a = sc.nextInt();
        int uinit = a % 10;
        int ten = a / 10 % 10;
        int hundred = a / 100 % 10;
        System.out.println("该整数的个位数为:"+ uinit);
        System.out.println("该整数的十位数为:"+ ten);
        System.out.println("该整数的百位数为:"+ hundred);*/

        //时间转换
/*        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个时间（秒）:");
        int Second = sc.nextInt();
        int hour = Second / 3600;
        int minute = Second % 3600 / 60;
        int second = Second % 3600 % 60;
        System.out.print("该时间转换为"+ hour+"小时"+ minute+"分"+ second+"秒");*/
    }
}
