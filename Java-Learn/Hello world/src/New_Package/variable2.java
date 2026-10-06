package New_Package;

import java.util.Scanner;

public class variable2 {
    public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的身高（米）:");
        double height = sc.nextDouble();
        System.out.print("请输入你的体重（kg）:");
        double weight = sc.nextDouble();
        double BMI = weight/(height * height);
        System.out.print("您的BMI体重为"+BMI);
    }
}
