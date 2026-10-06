package New_Package;

import java.util.Scanner;

public class Assignment_Operator {
    public void main(String[] args){
        /*Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的身高:");
        double height = sc.nextDouble();
        System.out.print("请输入你的身高:");
        double height2 = sc.nextDouble();
        if (height > height2) {
            System.out.println("你更高");
        } else {
            System.out.println("你更矮");
        }*/
       /* Scanner sc = new Scanner(System.in);
        System.out.print("请输入一位三位数:");
        int num = sc.nextInt();

        int unit = num % 10;
        int ten = num / 10 % 10;
        int hundred = num / 100;
        int sum = unit + ten + hundred;
        if (sum % 3 == 0){
            System.out.println("该数能被3整除");
        } else {
            System.out.println("该数不能被3整除");
        }*/

/*        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个整数:");
        int num = sc.nextInt();
        boolean result = !(num >= 1 && num <= 10);
        System.out.println(result);*/

/*        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个四位数整数:");
        int num = sc.nextInt();
        int unit = num % 10;
        int ten = num / 10 % 10;
        int hundred = num / 100 % 10;
        int thousand = num / 1000 % 10;
        boolean result = unit == thousand && ten == hundred;
        System.out.println(num + "是否回文数为:"+result);*/

/*        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个两位数整数:");
        int num = sc.nextInt();
        int unit = num % 10;
        int ten = num / 10 % 10;
        if (unit == 7 || ten == 7 || num % 7 == 0){
            System.out.println("该数能被7整除或包含7");
        } else {
            System.out.println("该数不能被7整除或包含7");
        }*/

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个整数:");
        int num1 = sc.nextInt();
        System.out.print("请输入另一个整数:");
        int num2 = sc.nextInt();
        // 三元运算符判断较大的数
        //先执行条件表达式，再执行表达式1和表达式2
        // 三元运算符的格式为：条件表达式 ? 表达式1 : 表达式2;
        // 当条件表达式为true时，表达式1会被执行，false则表达式2会被执行
        int max = num1 > num2 ? num1 : num2;
        System.out.println("较大的数为:"+max);
    }
}
