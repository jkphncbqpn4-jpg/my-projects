package New_Package;

import java.util.Scanner;
import java.util.concurrent.CompletionStage;

public class if语句 {
    public void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的体温:");
        double temp = sc.nextDouble();
        if(temp >= 38.0 || temp <= 36.0){
            System.out.println("你的体温异常");
        } else {
            System.out.println("你的体温正常");
        }*/
        /*Scanner sc = new Scanner(System.in);
        double blood = 200;
        System.out.print("请输入攻击的伤害:");
        double attack = sc.nextDouble();
        double hp = blood - attack;
        if (hp <= 0) {
            hp = 1;
            System.out.println("受到的伤害为超过最低血量1,最终血量重置为" + hp);
        }else {
            System.out.println("受到的伤害为" + attack);
        }
        System.out.print("请输入回复的血量");
        double treat = sc.nextDouble();
        double finalBlood = hp + treat;
        if (finalBlood > blood) {
            hp = 200;
            System.out.print("回复的血量超过血量,最终血量重置为" + hp);
        }else {
            System.out.print("最终血量为" + finalBlood);
        }*/
/*        Scanner sc = new Scanner(System.in);
        System.out.print("请输入消费的金额:");
        double money = sc.nextDouble();
        double elm = money * 0.9;
        double mt = 0;
        if (money>=30){
            mt = money - 10;
        }else {
            mt = money;
        }
        if (elm < mt){
            System.out.println("使用饿了么最便宜,最终金额为" + elm);
        }else {
            System.out.println("使用美单最便宜,最终金额为" + mt);
        }*/
/*        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个数:");
        int a = sc.nextInt();
        System.out.print("请输入第二个数:");
        int b = sc.nextInt();
        System.out.println("请输入+ - * /");
        String operator = sc.next();
        if (operator.equals("+")) {
            System.out.println(a + b);
        }else if(operator.equals("-")){
            System.out.println(a - b);
        }else if (operator.equals("*")){
            System.out.println(a * b);
        }else if(operator.equals("/")) {
            if (b == 0) {
                System.out.println("除数不能为0");
            } else {
                System.out.println(a / b);
            }
        }else {
            System.out.println("请输入正确的运算符");
        }*/
/*        Scanner sc = new Scanner(System.in);
        System.out.print("请输入价格:");
        double price = sc.nextDouble();
        double Voucher = 0;
        double card = price * 0.8;
        if (price > 0) {
            if (price <10) Voucher = 0;
            else if (price<50) Voucher = 8;
            else if (price<100) Voucher = 30;
            else if (price<200) Voucher = 50;
            else Voucher = 90;
        }else {
            System.out.println("请输入正确的价格");
        }
        double finalPrice = price - Voucher;
        if (price < card){
            System.out.println("使用优惠卷,最便宜最终金额为" + finalPrice);
        }else {
            System.out.println("使用会员卡,最便宜最终金额为" + card);
        }*/
/*        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要充值的价格:");
        int recharge = sc.nextInt();
        int give = 0;
        if (recharge == 1000) give = 200;
        else if (recharge == 2000) give = 500;
        else if (recharge == 3000) give = 700;
        else if (recharge == 5000) give = 1300;
        else if (recharge == 10000) give = 2500;
        else if (recharge == 20000) give = 6000;
        else if (recharge == 50000) give = 15000;
        else System.out.println("请输入正确的充值金额");
        int finalPrice = recharge + give;
        System.out.println("你充值的金额为" + recharge + "元,你获得的赠送金额为" + give + "元,余额为" + finalPrice);*/
        /*Scanner sc = new Scanner(System.in);
        System.out.print("请输入实际用电量:");
        double km = sc.nextDouble();
        double cost = 13;//消费金额
        double remainder = km - 3 ;//公里数
        if (remainder <= 0){
            remainder = 0;
        }
        if (remainder > 7){
            cost += 7  * 2.5;
            remainder -=7;
        }else {
            cost += remainder * 2.5;
            remainder = 0;
        }
        if (remainder > 0){
            cost += remainder * 3.75;
            remainder = 0;
        }
        System.out.println("你消费的金额为" + cost);
    }*/
/*        Scanner sc = new Scanner(System.in);
        System.out.print("请输入实际重量:");
        double weight = sc.nextDouble();
        double cost = 10;
        double remainder = weight - 1;
        if (remainder <= 0){
            remainder = 0;
        }
        if (remainder > 4){
            cost += 4 * 6;
            remainder -= 4;
        }else {
            cost += remainder * 6;
            remainder = 0;
        }
        if (remainder > 0){
            cost += remainder * 3;
            remainder = 0;
        }
        System.out.println("你消费的金额为" + cost);*/
        /*Scanner sc = new Scanner(System.in);
        System.out.print("请输入应纳税所得额:");
        double income = sc.nextDouble();
        double tax = 0;
        double remainder = income;
        if (income > 36000){
            tax += 36000 * 0.03;
            remainder -= 36000;
        }else {
            tax += income * 0.03;
            remainder = 0;
        }
        if (remainder > 108000){
            tax += 108000 * 0.1;
            remainder -= 108000;
        }else {
            tax += remainder * 0.1;
            remainder = 0;
        }
        if (remainder > 156000){
            tax += 156000 * 0.2;
            remainder -= 156000;
        }else {
            tax += remainder * 0.2;
            remainder = 0;
        }
        if (remainder > 0){
            tax += remainder * 0.25;
            remainder = 0;
        }
        System.out.println("你需要缴纳的税款为" + tax);*/
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入销售额度:");
        double sales = sc.nextDouble();
        double bonus = 0;
        double remainder = sales;
        if (remainder> 10000){
            bonus += 10000 * 0.05;
            remainder -= 10000;
        }else {
            bonus += remainder * 0.05;
            remainder = 0;
        }
        if (remainder > 40000){
            bonus += 40000 * 0.08;
            remainder -= 40000;
        }else {
            bonus += remainder * 0.08;
            remainder = 0;
        }
        if (remainder > 0){
            bonus += remainder * 0.12;
            remainder = 0;
        }
        if (sales > 50000){
            bonus +=1000;
        }
        System.out.println("你的奖金为" + bonus);
    }
}

