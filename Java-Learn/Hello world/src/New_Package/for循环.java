package New_Package;
import java.util.Scanner;
public class for循环 {
    public static void main(String[] args) {
/*        int sum = 0;
        for(int i = 1;i <= 100;i++){
            if (i % 2 != 0){
                sum += i;
            }
        }
        System.out.println(sum);*/
/*        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个数字:");
        int a = sc.nextInt();
        System.out.print("请输入二个数字:");
        int b = sc.nextInt();
        int max = a > b ? a : b;
        int min = a < b ? a : b;
        int count = 0;
        for (int i = min; i <= max; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                count++;
            }
        }
        System.out.println("这个范围内既能被3整除又能被5整除的数有:" + count+"个");*/
/*        int a =0;
        int b =1;
        int c = 0;
        for (int i = 3;i <= 10;i++){
            c = a + b;
            a = b;
            b = c;
            System.out.println(c);
        }*/
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个数字:");
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 1;i <= n;i++){
            if (i % 2 != 0){
                sum += i;
            }
            else{
                sum -= i;
            }
        }
        System.out.println(sum);
    }
}
