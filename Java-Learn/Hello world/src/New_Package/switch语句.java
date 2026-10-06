package New_Package;

import java.util.Scanner;

public class switch语句 {
    public void main(String[] args) {
        // switch语句
        //switch语句的语法
        //switch (表达式){
        //    case 值1:
        //        代码块1;
        //        break;
        //    case 值2:
        //        代码块2;
        //        break;
        //    default:
        //        代码块n;
        //        break;
        //}
        //switch语句的注意事项
        //1. 表达式必须是整数类型或枚举类型
        //2. 每个case标签必须是唯一的
        //3. 每个case标签后面必须有break语句或default语句
        //4. default语句可以省略
        //5. switch语句没有标准的上下执行顺序，只是为了方便阅读
        //6. switch穿透：switch语句没有break语句，
        // 会继续执行下一个case标签的代码块，直到遇到break语句或运行完整个switch语句
        Scanner sc = new Scanner(System.in);
/*        System.out.print("请输入一个星期数:");
        String day = sc.nextLine();
        switch (day){
            case "1":
                System.out.println("你输入的是星期一");
                break;
            case "2":
                System.out.println("你输入的是星期二");
                break;
            case "3":
                System.out.println("你输入的是星期三");
                break;
            case "4":
                System.out.println("你输入的是星期四");
                break;
            case "5":
                System.out.println("你输入的是星期五");
                break;
            case "6":
                System.out.println("你输入的是星期六");
                break;
            case "7":
                System.out.println("你输入的是星期日");
                break;
            default:
                System.out.println("你输入的星期数有误");
                break;
        }*/

        /*switch语句穿透的应用场景：
          当多个case的语句相同时，利用case穿透可以减少代码量
          */
/*        System.out.print("请输入月份获取对应的季节:");
        int month = sc.nextInt();
        switch (month) {
            case 1:
            case 2:
            case 12:
                System.out.println("冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("你输入的月份有误");
                break;
        }*/
        /*
        switch语句的新特性：
        case后面可以写多个值，用逗号隔开
        switch可以有运行结果，用yield关键字返回
        如果是一行代码，可以省略大括号和break语句还有yield关键字
        注意：switch语句使用yield时接受数据时需要在switch的最后的括号中写;符号
         */
        System.out.print("请输入星期数:");
        int day = sc.nextInt();
        switch (day) {
            case 1 -> System.out.println("你输入的是星期一");
            case 2 -> System.out.println("你输入的是星期二");
            default -> System.out.println("你输入的星期数有误");
        }

        System.out.print("请输入加减乘除运算符:");
        String operator = sc.next();
        System.out.print("请输入第一个数:");
        int a = sc.nextInt();
        System.out.print("请输入第二个数:");
        int b = sc.nextInt();
        int sum = switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
        System.out.println(sum);
    }
}
