package New_Package;

public class variable {
    public static void main() {
        int gj = 220;
        int fy = 85;
        double blood = 1012.5;
        double jn = 1.2;

        int gj2 = 210;
        int fy2 = 80;
        double blood2 = 1223.3;
        double jn2 = 1.3;

        double sh = gj - fy2;
        System.out.println("造成的伤害" + sh);
        blood2 = blood2 - sh;
        System.out.println("敌方剩余血量" + blood2);
        double sh2 = gj * jn - fy2;
        System.out.println("造成的伤害" + sh2);
        blood2 = blood2 - sh2;
        System.out.println("敌方剩余血量" + blood2);
    }
}
