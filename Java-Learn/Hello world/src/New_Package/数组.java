package New_Package;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class 数组 {
    public static void main(String[] args) {
/*        int arr[] ={13,24,35,46,57};
        int num = arr[2];
        System.out.println(arr[0]);
        System.out.println(num);
        arr[4] = 68;
        System.out.println(arr[4]);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/

        //数组的动态初始化
        /*Scanner sc = new Scanner(System.in);
        int arr[] = new int[6];
        int count = 0;//记录数组的元素个数
        for (int i = 0 ; i< arr.length;i++){
            count ++;
            System.out.print("请输入数组的第"+(count)+"个整数:");
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
        /*Scanner sc = new Scanner(System.in);
        int num_arr[] = {33, 4, 5, 33, 22};
        System.out.println("输入要查找的数据:");
        int num = sc.nextInt();
        int count = 0;
        for (int i = 0; i < num_arr.length; i++) {
            if (num == num_arr[i]) {
                System.out.println(i);
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("查找失败");
        }*/
        //查找数组中的最大值
        //方法1:
/*        int num_arr[] = {33, 5, 22, 44,55};
        int max = num_arr[0];
        for (int i = 0; i < num_arr.length; i++) {
            max = Math.max(max,num_arr[i]);
        }
        System.out.println(max);*/

        //方法2:
/*        int num_arr[] = {33, 5, 22, 44,55};
        int max = num_arr[0];
        for (int i = 0; i < num_arr.length; i++) {
            if (num_arr[i] > max){
                max = num_arr[i];
            }
        }
        System.out.println(max);*/

        /*int num_arr[] = {33, 5, 22, 44, 55};
        Scanner sc = new Scanner(System.in);
        System.out.println("输入数组中你认为最小的值:");
        int min_num = sc.nextInt();
        int min = num_arr[0];
        int count = 0;
        for (int i = 0; i < num_arr.length; i++) {
            min = Math.min(min, num_arr[i]);
        }
        if (min == min_num) {
            System.out.println("猜对了");
            count++;
        }
        if (count == 0) {
            System.out.println("猜错了");
        }*/

        //冒泡排序
        /*int num[] = {5, 3, 8, 1, 2};
        for (int i = 0; i < num.length-1; i++) {
            for (int j = 0; j < num.length-1-i; j++) {
                if (num[j] > num[j+1]) {
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(num));*/
       /* Random r = new Random();
        int num[] = {1,2,3,4,5,6,7,8,9,10};
        for (int i= 0; i < num.length; i++) {
            int index = r.nextInt(num.length);
            int temp = num[i];
            num[i] = num[index];
            num[index] = temp;
        }
        System.out.println(Arrays.toString(num));*/

/*        int num[] = {1, 2, 3, 4, 5};
        for (int i = 0; i < num.length/2; i++) {
            int temp = num[i];
            num[i] = num[num.length - 1 - i];
            num[num.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(num));*/

/*        int num[] = {8,2,15,6,7};
        int max = num[0];
        int max_index = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max){
                max = num[i];
                max_index = i;
            }
        }
        System.out.println("最大的数为:"+max);
        System.out.println("该数的下标为:"+max_index);*/

        //移动零排序
        //方法一:
        /*int num[] = {0,1,0,3,12};
        for(int i=0;i<num.length;i++){
            for (int j = 0; j < num.length-1-i; j++) {
                if(num[j]==0){
                    int temp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(num));*/

        //方法二:
        /*int num[] = {0,1,0,3,12};
        int index = 0;//初始化索引为0
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) {//判断i所对应的值是否为0，不为零执行
                num[index] = num[i];//第一次num[0]=num[1],第二次是num[1]=num[3],第三次是num[2]=[4]
                index++;//索引值每次加一
            }
        }
        while (index < num.length) {//判断index的长度是否小于数组的长度,将长度小于数组所对应索引的值变为0
            num[index] = 0;
            index++;
        }
        System.out.println(Arrays.toString(num));*/
        /*Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("输入需要存入数组的值:");
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));*/

       /* int num[] = new int[10];
        Random r = new Random();
        for (int i = 0; i < num.length;) {
            int count = 0;
            int index = r.nextInt(100) + 1;
            for (int j = 0; j < num.length; j++) {
                if (num[j] == index) {
                    count++;
                    break;
                }
            }
            if (count == 0){
                num[i]=index;
                i++;
            }
        }
        System.out.println(Arrays.toString(num));*/
        /*int arr[] = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[index]) {
                index++;
                arr[index] = arr[i];
            }
        }
        for (int i = 0; i <= index; i++) {
            System.out.print(arr[i] + " ");
        }*/

        /*int[] num = {1, 2, 3};
        int target = 100;
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] + num[j] == target) {
                    count++;
                    System.out.println("第"+count+"对满足要求的索引是: [" + i + ", " + j + "]");
                }
            }
        }
        if (count == 0) {
            System.out.println("没有能相加为"+target+"的索引");
        }*/
       /* int[] num1 = {1,3,5,7,9};
        int[] num2 = {2,4,6,8,10};
        int[] num3 = new int[num1.length+num2.length];
        System.arraycopy(num1,0,num3,0,num1.length);
        System.arraycopy(num2,0,num3,num1.length,num2.length);
        for (int i = 0; i < num3.length-1; i++) {
            for (int j = 0; j < num3.length-1-i; j++) {
                if (num3[j]>num3[j+1]) {
                    int temp = num3[j];
                    num3[j] = num3[j+1];
                    num3[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(num3));*/

        /*int[] num = {1, 3, 5, 6};
        int target = 7;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == target) {
                System.out.println(i);
                return;
            }
            if (num[i] > target) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(num.length);*/

/*        int[] num = {3, 2, 2, 3};
        int[] num2 = new int[2];
        int val = 3;
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != val) {
                num[index] = num[i];
                index++;
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.print(num[i] + " ");
        }*/

        /*int[] num = {0,1,0,3,12};
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) {
                int temp = num[i];
                num[i] = num[index];
                num[index] = temp;
                index++;
            }
        }
        System.out.println(Arrays.toString(num));*/

        /*int[] num = {1, 1, 2, 2, 3};
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != num[index]) {
                num[index + 1] = num[i];
                index++;
            }
        }
        for (int i = 0; i <= index; i++) {
            System.out.print(num[i] + " ");
        }*/

        /*int[] num = {3,1,2,4};
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                int temp = num[i];
                num[i] = num[index];
                num[index] = temp;
                index++;
            }
        }
        System.out.println(Arrays.toString(num));*/

        int[] num = {1, 1, 1, 2, 2, 2, 3};
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if (index < 2 || num[i] != num[index - 2]) {
                num[index] = num[i];
                index++;
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.print(num[i] + " ");
        }
    }
}