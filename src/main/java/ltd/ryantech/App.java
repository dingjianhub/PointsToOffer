package ltd.ryantech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    //    public static void main(String[] args) throws IOException {
//        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        st.nextToken();
//        int number = (int) st.nval;
//        String s = Integer.toString(number);
//        int[] dp = new int[s.length() + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for (int i = 2; i <= s.length(); i++) {
//            String tmp = s.substring(i - 2, i);
//            if (tmp.compareTo("11") >= 0 && tmp.compareTo("26") <= 0) {
//                dp[i] = dp[i - 1] + dp[i - 2];
//            } else {
//                dp[i] = dp[i - 1];
//            }
//        }
//        System.out.println(dp[s.length()]);
//    }

    public static void main(String[] args) {
//        Stream<String> a = Stream.of("a", "b", "c");
//        List<String> list = a.peek(e -> System.out.println(e.toUpperCase())).collect(Collectors.toList());


        Integer[] l = {1, 2, 3, 4, 5, 6};
        Stream<Integer> b = Stream.of(l);
        Comparator<Integer> comparator = (x,y) -> (x.intValue() < y.intValue()) ? -1 : ((x.equals(y)) ? 0 : 1);
//        System.out.println(b.max(comparator).get());
        b.filter(e -> e.intValue() > 4).forEach(e -> System.out.println(e));
    }

}
