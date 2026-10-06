import java.util.Arrays;
import java.util.Scanner;

public class 练习 {
    public void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个大于等于2的整数:");
        int num;
        while (true){
            num = sc.nextInt();
            if(num >= 2){
                break;
            }else {
                System.out.println("请输入一个大于等于2的整数");
            }
        }
        boolean isPrime = true;
        for (int i = 2; i < num; i++) {
            if (num % i ==0){
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("你输入的整数是:" + num + ",这是一个质数");
        } else {
            System.out.println("你输入的整数是:" + num + ",这不是一个质数");
        }*/
       /* int num[] = {7,3,5,2,1,4,6};
        for (int i =0; i<num.length-1; i++){
            for (int j = 0; j < num.length-1-i; j++){//减去i是因为经过一轮后最大的数字已经在末尾了，所以不需要重复的去运算
                if (num[j] > num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(num));*/
        /*int[] num = {2,7,11,15};
        int target = 9;
        for (int i = 0; i<num.length; i++){
            for (int j = i+1; j<num.length; j++){
                if (num[i]+num[j]==target){
                    System.out.println(i);
                    System.out.println(j);
                }
            }
        }*/

        int[] nums = {-4, -1, 0, 3, 10};
        int[] num = new int[nums.length];
        int index = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                num[index] = leftSquare;
                left++;
            }else {
                num[index] = rightSquare;
                right--;
            }
            index--;
        }
        System.out.println(Arrays.toString(num));
    }
}
