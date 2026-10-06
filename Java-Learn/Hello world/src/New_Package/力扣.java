package New_Package;

import java.util.Arrays;
import java.util.Random;

public class 力扣 {
    public static void main(String[] args) {
        /*int[] nums ={3,2,2,3};
        int val =3;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.print(index);
        }*/

        //移动零
/*        int[] nums = {0, 1, 0, 3, 12};
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        while (index < nums.length){
            nums[index] = 0;
            index++;
            System.out.println(Arrays.toString(nums));
        }*/

        //26.删除有序列表的重复项
        /*int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
                System.out.println(Arrays.toString(nums));
            }
        }
        System.out.println(index+1);*/

        //977. 有序数组的平方
/*
        int[] nums = {-4, -1, 0, 3, 10};
        int[] num = new int[nums.length];//结果数组
        int index = nums.length - 1;//定义一个填充的指针
        int left = 0;//左指针
        int right = nums.length - 1;//右指针
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                num[index] = leftSquare;
                left++;
            }else{
                num[index] = rightSquare;
                right--;
            }
            index--;
        }
        System.out.println(Arrays.toString(num));
*/
        //167. 两数之和 II - 输入有序数组
/*        int[] nummbers = {2, 7, 11, 15};
        int target = 9;
        int left = 0;
        int right = nummbers.length - 1;
        while (left < right) {
            int sum = nummbers[left] + nummbers[right];//定义两个数的和
            if (sum == target) {//当和于目标值相等时返回两个指针的索引
                System.out.println(left+1+""+right+1);
            } else if (sum > target) {//当和大于目标值时说明大的数太大了，应right--
                right--;
            } else {//反之说明右边的数太小了，应left++
                left++;
            }
        }
        System.out.println(left+1+""+right+1);*/

        //随机数1-100中填入数组，去除重复元素
        /*Random r = new Random();
        int[] num = new int[10];
        for (int i = 0; i < num.length; ) {// 循环填充数组，直到每个位置都填入不重复的随机数
            num[i] = r.nextInt(100) + 1;//将随机数据存入i索引所在的位置
            int count = 0;//定义一个计数器判断是否有重复数据
            for (int j = 0; j < i; j++) {//遍历数组，看i之前的数是否有重复的
                if (num[j] == num[i]) {//如有重复的数据，则计数器加1
                    count++;
                    break;
                }
            }
            if (count == 0) {// 如果计数器为0，说明当前 num[i] 和前面不重复，可以保留，i 后移一位，如果不为0，说明重复了，i 不前进，下一轮重新生成 num[i]
                i++;
            }
        }
        System.out.println(Arrays.toString(num));*/

        //80. 删除有序数组中的重复项 II
       /* int[] nums = {1,1,1,2,2,3};
        int index = 0;//定义一个慢指针
        for (int i = 0; i < nums.length; i++) {//定义一个快指针
            if (index < 2 ||nums[i] != nums[index-2]) {//判断数组中的数字是否重复了两次，前两次的数字不用管，当有第三个相同的数字index-2判断前两个数字是否重复
                nums[index] = nums[i];//如果重复将后面的数据移到前面
                index++;//索引加一
            }
        }*/
    }
}
