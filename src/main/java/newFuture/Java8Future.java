package newFuture;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name newFuture
 * @description
 * @create 2020/10/12 19:19
 **/

public class Java8Future {

    public void showBase64() {
        String string = new String("Java 8 Base64 测试");
        String encoded = Base64.getEncoder().encodeToString(string.getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64 编码是 : " + encoded);
        String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
        System.out.println("解码后的源码是 : " + decoded);
        System.out.println("解码结果 : " + decoded.equals(string));
    }

    public void showDataApi() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        System.out.println("今年是 : " + year + " 年");
        System.out.println("今年是不是闰年 : " + today.isLeapYear());

        LocalDateTime todayTime = LocalDateTime.now();
        System.out.println("当前时间是 : " + todayTime);

        // 时区
        System.out.println("美国时间 : " + ZonedDateTime.of(todayTime, ZoneId.of("America/Los_Angeles")));

        LocalDate specialDate = LocalDate.of(2020, 6, 20);
        LocalDate expectDate = specialDate.plus(100, ChronoUnit.DAYS);
        System.out.println("比较特别的一天 : " + specialDate);
        System.out.println("特殊日期的100天 : " + expectDate);
    }

    public void showStream() {
        List<Singer> singerList = new ArrayList<Singer>();
        singerList.add(new Singer("jay", 11, 36));
        singerList.add(new Singer("eason", 8, 31));
        singerList.add(new Singer("JJ", 6, 29));

        List<String> singerNameList = singerList.stream()
                .filter(singer -> singer.getAge() > 30)  //筛选年龄大于30
                .sorted(Comparator.comparing(Singer::getSongNum))  //根据歌曲数量排序
                .map(Singer::getName)  //提取歌手名字
                .collect(Collectors.toList()); //转换为List
        System.out.println(Arrays.toString(singerNameList.toArray()));
    }

    public static void main(String[] args) {
        Java8Future java8Future = new Java8Future();
        java8Future.showBase64();
        java8Future.showDataApi();
        java8Future.showStream();
    }
}
