package New_Package;

import java.util.Random;
import java.util.Scanner;

public class While语句 {
    public void main(String[] args) {
/*        int a = 1;
        while (a <=10){
            System.out.println(a);
            a++;
        }*/

/*        double height = 8848860;
        double paper = 0.1;
        int count = 0;
        while (paper < height){
            paper *= 2;
            count++;
        }
        System.out.println(count);*/

/*        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个整数n:");
        int n = sc.nextInt();
        int sum = 0;
        if (n <0){
            n = -n;
        }
        while (n != 0){
            sum += n % 10;//获取整数中的个位数，例如123的个位数是3,取余10后得到3,再除以10得到12,再取余10得到2,再除以10得到1,再取余10得到1,最后得到1
            n /= 10;//获取整数中的十位数，例如123中的十位数为2，通过整除10后得到12，再将12赋值给n，继续下一次的循环运算，最后算出num的各位数字的和
        }
        System.out.println(sum);*/
//        Scanner sc = new Scanner(System.in);
//        System.out.print("请输入一个整数:");
//        int n = sc.nextInt();
//        int sum = 0;
//        while (n > 0) {
//            if (n == 0) {
//                break;
//            }
//            int digit = n % 10;
//            sum = sum * 10 + digit;
//            n /= 10;
//        }
//        System.out.println(sum);

        //do while是先执行一次循环，再判断是否继续执行循环
/*        Scanner sc = new Scanner(System.in);
        String password = " ";
        do {
            System.out.print("请输入一个密码:");
            password = sc.nextLine();
        } while (!password.equals("123456"));//当密码不是123456时，返回true，继续执行循环，当密码是123456时，返回false，退出循环，执行System.out.println("密码正确");
        System.out.println("密码正确");*/

/*        Scanner sc = new Scanner(System.in);
        double hp = 200;
        double damage;
        double heal;
        while (true) {
            System.out.print("请输入人物受到的伤害:");
            damage = sc.nextDouble();
            if (damage >= 0) {
                break;
            } else {
                System.out.println("人物受到的伤害不能小于0");
            }
        }

        hp -= damage;
        if (hp <= 0) {
            hp = 1;
            System.out.println("人物最少血量为1点");
        }

        System.out.println("人物受到伤害:" + damage);
        System.out.println("人物当前血量:" + hp);

        while (true) {
            System.out.print("请输入人物恢复的血量:");
            heal = sc.nextDouble();
            if (heal > 0) {
                break;
            } else {
                System.out.println("人物恢复的血量不能小于0");
            }
        }
        double oldHp = hp;

        hp += heal;
        if (hp >= 200) {
            hp = 200;
            System.out.print("人物最多血量为200点,");
        }
        System.out.println("人物恢复血量:" + (hp - oldHp));
        System.out.println("人物当前血量:" + hp);*/

        //判断一个整数是否为质数

        //方法1：
        /*Scanner sc = new Scanner(System.in);
        int num;
        while (true) {
            System.out.print("请输入一个大于等于2的整数:");
            num = sc.nextInt();
            if (num >= 2) {
                boolean prime = true;//定义一个布尔变量prime，初始值为true，用于判断num是否为质数
                for (int i = 2; i < Math.sqrt(num); i++) { //从2开始，判断num是否能被除它以外的其他整数整除，如果能被整除，说明num不是质数，prime赋值为false，退出循环
                    if (num % i == 0) {
                        prime = false;//找到能被1和自身以外的其他整数整除的整数，prime赋值为false，退出循环
                        break;
                    }
                }
                if (prime) {
                    System.out.println("你输入的整数是:" + num + ",这是一个质数");
                } else {
                    System.out.println("你输入的整数是:" + num + ",这不是一个质数");
                }
            } else {
                System.out.println("请输入一个大于等于2的整数");
            }
        }*/

        //方法2：
       /* Scanner sc = new Scanner(System.in);
        int num;
        while (true) {
            System.out.print("请输入一个大于等于2的整数:");
            num = sc.nextInt();
            if (num >= 2) {
                break;
            } else {
                System.out.println("请输入一个大于等于2的整数");
            }
        }

        int count = 0;//定义一个整数变量count，初始值为0，用于记录num能被除它以外的其他整数整除的次数

        for (int i = 2; i < Math.sqrt(num); i++) { //合数的判断范围是2到num的平方根，因为合数的一定有一个因子小于等于它的平方根
            if (num % i == 0) {
                count++;//如果num能被i整除，count加1
                break;//如果num能被i整除，说明num不是质数，退出循环
            }
        }

        if (count == 0) {
            System.out.println("你输入的整数是:" + num + ",这是一个质数");
        } else {
            System.out.println("你输入的整数是:" + num + ",这不是一个质数");
        }*/
       /* Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个整数:");
        int num = sc.nextInt();
        int i= 0;
        while (i < num){
            i++;
            if (i % 4 == 0 || i % 10 == 4 || i /10%10 == 4) {
                System.out.println("");
                continue;
            }
            System.out.println(i);
        }*/
        Random r = new Random();
        int num = r.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int guess;
        while (true) {
            System.out.print("请输入你猜的数字(1-100):");
            guess = sc.nextInt();
            count++;
            if (count == 10 && guess != num) {
                System.out.println("恭喜你猜对了,你猜了" + count + "次");
                break;
            }
            if (guess > num) {
                System.out.println("你猜的数字太大了,再来一次:");
            } else if (guess < num) {
                System.out.println("你猜的数字太小了,再来一次:");
            } else {
                System.out.println("恭喜你猜对了,你猜了" + count + "次");
                break;
            }
            if (count == 3) {
                System.out.println("范围为" + (num - 5) + "~" + (num + 5) + "之间");
            }

        }
    }
}
