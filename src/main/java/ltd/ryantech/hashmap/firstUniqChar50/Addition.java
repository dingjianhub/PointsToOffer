package ltd.ryantech.hashmap.firstUniqChar50;

import java.util.HashSet;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.hashmap.firstUniqChar50
 * @description
 * @create 2020/08/21 15:13
 **/

public class Addition {
    public String delete(String str1, String str2) {
        HashSet<Character> set = new HashSet<>();
        for (Character c : str2.toCharArray()) {
            set.add(c);
        }
        StringBuilder res = new StringBuilder();
        for (Character c : str1.toCharArray()) {
            if (!set.contains(c)) {
                res.append(c);
            }
        }
        return res.toString();
    }

    public String delete1(String str) {
        int[] appear = new int[256];
        StringBuilder res = new StringBuilder();
        for (Character c : str.toCharArray()) {
            if (appear[(int) c] != 1) {
                res.append(c);
                appear[(int) c] = 1;
            }
        }
        return res.toString();
    }

    public boolean anagram(String str1, String str2) {
        int[] counter1 = new int[256];
        int[] counter2 = new int[256];
        for (char c : str1.toCharArray()) {
            counter1[c]++;
        }
        for (char c : str2.toCharArray()) {
            counter2[c]++;
        }
        for (int i = 0; i < 256; i++) {
            if (counter1[i] != counter2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Addition().delete("We are student", "astde"));
        System.out.println(new Addition().delete1("google"));
        System.out.println(new Addition().anagram("listen", "silent"));
    }
}
