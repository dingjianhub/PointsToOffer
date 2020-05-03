package ltd.ryantech;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Hello world!
 */
public class App {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> counter1 = new HashMap<>();
        for (char key : ransomNote.toCharArray()) {
            counter1.put(key, counter1.getOrDefault(key, 1) + 1);
        }
        HashMap<Character, Integer> counter2 = new HashMap<>();
        for (char key : magazine.toCharArray()) {
            counter2.put(key, counter2.getOrDefault(key, 1) + 1);
        }
        for (char key : counter1.keySet()) {
            if (!counter2.containsKey(key)) {
                return false;
            }
            if (counter1.get(key) > counter2.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "abbc";
        String magazine = "abbbccc";
        System.out.println(new App().canConstruct(ransomNote, magazine));
    }
}
