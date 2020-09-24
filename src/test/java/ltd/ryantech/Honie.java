package ltd.ryantech;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech
 * @description
 * @create 2020/09/23 21:23
 **/

public class Honie {
    public static void move(int n, char x, char y, char z) {
        if (n == 1) {
            System.out.println(x + " -> " + z);
        } else {
            move(n - 1, x, z, y);
            System.out.println(x + " -> " + z);
            move(n - 1, y, x, z);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        move(n, 'x', 'y', 'z');
    }
}
