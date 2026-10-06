package New_Package;

import javax.xml.transform.dom.DOMResult;
import java.util.Scanner;

public class for循环嵌套 {
    public static void main(String[] args) {
/*        for (int j =1; j<=3; j++) {
            for (int i =1; i<=j; i++) {
                System.out.print("*");
            }
            System.out.println();
        }*/
/*        for (int i =1; i<=5; i++) {
            for (int j =1; j<=6-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }*/

        //打印一个平行四边形
        /*for (int i =1; i<=3; i++) {//控制最外面的行数
            for (int j =1; j<=3-i; j++) {//控制空格数
                System.out.print(" ");
            }
            for (int k =1; k<=6; k++) {//控制打印的星号数
                System.out.print("*");
            }
            System.out.println();
        }*/
        //打印一个梯形
/*        for (int i =1; i<=3; i++) {//控制最外面的行数
            for (int j =1; j<=3-i; j++) {//控制空格数
                System.out.print(" ");
            }
            for (int k =1; k<=2*i+1; k++) {//控制打印的星号数
                System.out.print("*");
            }
            System.out.println();
        }*/
        //打印一个大菱形
        //打印上半部分
        /*for (int i =1; i<=4; i++) {
            for (int j =1; j<=4-i; j++) {
                System.out.print(" ");
            }
            for (int k =1; k<=2*i-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //打印下半部分
        for (int i =1; i<=3; i++) {
            for (int j =1; j<=i; j++) {
                System.out.print(" ");
            }
            for (int k =1; k<=7-2*i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }*/
        //打印一个空心菱形
        //打印上半部分
        /*for (int i=1;i<=3;i++){
            for (int j=1;j<=3-i;j++){
                System.out.print(" ");
            }
            for (int k=1;k<=2*i-1;k++){
                if (k==1 || k==2*i-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        //打印下半部分
        for (int i =1; i<=2; i++) {
            for (int j =1; j<=i ;j++) {
                System.out.print(" ");
            }
            for (int k =1; k<=3-(i-1)*2; k++) {
                if (k==1 || k==3-(i-1)*2){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }*/
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个数");
        int a = sc.nextInt();
        for (int i = a; i>=1; i--) {
            for (int j = i; j>=1; j--) {
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
    }
}
