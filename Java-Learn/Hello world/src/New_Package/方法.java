package New_Package;

import java.util.Arrays;
import java.util.Random;

public class 方法 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] num = new int[10];
        for (int i = 0; i < num.length;) {
            int num1 = r.nextInt(100)+1;
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (num[j] == num1) {
                    count++;
                    break;
                }
            }
            if (count == 0){
                num[i] = num1;
                i ++;
            }
        }
        System.out.println(Arrays.toString(num));
    }
}
