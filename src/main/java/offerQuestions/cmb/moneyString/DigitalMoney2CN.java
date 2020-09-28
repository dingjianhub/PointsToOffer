package offerQuestions.cmb.moneyString;

import java.util.HashMap;
import java.util.Map;


/**
 * @author jerry
 * @program PointsToOffer
 * @package_name offerQuestions.cmb.moneyString
 * @description
 * @create 2020/09/25 20:24
 **/

/**
 * 招商银行 算法题
 * 将一个数字的金额，转换成中文的数字金额
 * 例如 ：123.45 转换为 一百二十三元四角五分
 */
public class DigitalMoney2CN {

    public String number2String(String number) {
        char[] moneyChars = number.toCharArray();

        int rightLength = 0; // 小数点右边的长度

        int t = moneyChars.length - 1;
        while (t >= 0 && moneyChars[t] != '.') {
            rightLength++;
            t--;
        }

        rightLength++; // 小数和整数部分的长度
        int leftLength = moneyChars.length - rightLength; // 整数部分的长度，不包含小数点

        /**
         * 整数部分的对应位置的 中文名称
         */
        Map<Integer, String> integerBitName = new HashMap<>();
        integerBitName.put(-1, "元");
        integerBitName.put(1, "十");
        integerBitName.put(2, "百");
        integerBitName.put(3, "千"); //
        integerBitName.put(4, "万");
        integerBitName.put(5, "十万");
        integerBitName.put(6, "百万");
        integerBitName.put(7, "千万");
        integerBitName.put(8, "亿"); //
        integerBitName.put(9, "十亿");
        integerBitName.put(10, "百亿");
        integerBitName.put(11, "千亿");
        integerBitName.put(12, "万亿");


        /**
         * 小数部分的对应位置的 中文名称
         */
        Map<Integer, String> decimalBitName = new HashMap<>();
        decimalBitName.put(1, "角");
        decimalBitName.put(2, "分");
        decimalBitName.put(3, "厘");

        /**
         * 数字的对应中文名
         */
        Map<Integer, String> number2String = new HashMap<>();
        number2String.put(0, "零");
        number2String.put(1, "一");
        number2String.put(2, "二");
        number2String.put(3, "三");
        number2String.put(4, "四");
        number2String.put(5, "五");
        number2String.put(6, "六");
        number2String.put(7, "七");
        number2String.put(8, "八");
        number2String.put(9, "九");


        // 首先，寻找翻译的规律
        // 对于一个数字的金额，其翻译的一个规律是，一段区间类的 小单位 是一致的
        // 比如一个大数：5673810200403.547
        // 其 亿 级别的翻译，首先翻译成 五万六千七百三十八 ，最后 添加一个 亿
        // 比如一个大数：5000810200403.547
        // 在遇到 0 的适合，遇到 1 个 0 ，就添加一个 “零”；遇到多个 0，仍然添加 1 个 “零”


        StringBuilder stringBuilder = new StringBuilder();
        // 求解整数部分的 string

        int pointer = 0;
        // 万亿 千亿 百亿 十亿 亿 千万 百万 十万 万  千 百  十  个
        //  13  12  11   10  9  8   7    6   5  4  3   2  1
        if ((leftLength - pointer) >= 9 && (leftLength - pointer) <= 13) { // 求解 亿 部分的值
            int start = 0;
            int end = leftLength - 9 - pointer; // 13 - 9 = 4
            boolean ZeroFlag = false;
            for (int i = start; i <= end; i++) {
                int integer = Integer.parseInt(String.valueOf(moneyChars[pointer]));
                pointer++;
                if (integer != 0) {
                    if (ZeroFlag) { // 遇到第一个不为 0 的单位，添加 1 个 “零”
                        stringBuilder.append("零");
                        ZeroFlag = false;
                    }
                    stringBuilder.append(number2String.get(integer)); // 添加数字
                    if (i != end) {
                        stringBuilder.append(integerBitName.get(end - start - i)); // 添加单位
                    }
                } else {
                    ZeroFlag = true;
                }
            }
            stringBuilder.append("亿"); // 最后添加亿
        }


        if (leftLength - pointer >= 5 && leftLength - pointer <= 8) {
            // 万亿 千亿 百亿 十亿 亿 千万 百万 十万 万  千 百  十  个
            //  13  12  11   10  9  8   7    6   5  4  3   2  1
            int start = 0;
            int end = leftLength - pointer - 5;
            boolean ZeroFlag = false;
            for (int i = start; i <= end; i++) {
                int integer = Integer.parseInt(String.valueOf(moneyChars[pointer]));
                pointer++;
                if (integer != 0) {
                    if (ZeroFlag) { // 遇到第一个不为 0 的单位，添加 1 个 “零”
                        stringBuilder.append("零");
                        ZeroFlag = false;
                    }
                    stringBuilder.append(number2String.get(integer)); // 添加数字
                    if (i != end) {
                        stringBuilder.append(integerBitName.get(end - start - i)); // 添加单位
                    }
                } else {
                    ZeroFlag = true;
                }
            }
            stringBuilder.append("万"); // 最后添加万
        }

        if (leftLength - pointer >= 1 && leftLength - pointer <= 4) {
            // 万亿 千亿 百亿 十亿 亿 千万 百万 十万 万  千 百  十  个
            //  13  12  11   10  9  8   7    6   5  4  3   2  1
            int start = 0;
            int end = leftLength - pointer - 1;
            boolean ZeroFlag = false;
            for (int i = start; i <= end; i++) {
                int integer = Integer.parseInt(String.valueOf(moneyChars[pointer++]));
                if (integer != 0) {
                    if (ZeroFlag) { // 遇到第一个不为 0 的单位，添加 1 个 “零”
                        stringBuilder.append("零");
                        ZeroFlag = false;
                    }
                    stringBuilder.append(number2String.get(integer)); // 添加数字
                    if (i != end) {
                        stringBuilder.append(integerBitName.get(end - start - i)); // 添加单位
                    }
                } else {
                    ZeroFlag = true;
                }
            }
            stringBuilder.append("元"); // 最后添加元
        }

        for (int i = leftLength + 1, j = 1; i < moneyChars.length; i++) {
            int integer = Integer.parseInt(String.valueOf(moneyChars[i]));
            if (integer != 0) {
                stringBuilder.append(number2String.get(integer));
                stringBuilder.append(decimalBitName.get(j));
            }
            j++;
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        DigitalMoney2CN digitalMoney2CN = new DigitalMoney2CN();
        System.out.println(digitalMoney2CN.number2String("5673810200403.547"));
        System.out.println(digitalMoney2CN.number2String("5603810200403.547"));
        System.out.println(digitalMoney2CN.number2String("5060810200403.547"));
        System.out.println(digitalMoney2CN.number2String("5800880200403.547"));
        System.out.println(digitalMoney2CN.number2String("123.45"));
        System.out.println(digitalMoney2CN.number2String("123.004"));
        System.out.println(digitalMoney2CN.number2String("123.040"));
        System.out.println(digitalMoney2CN.number2String("1233463.547"));
        System.out.println(digitalMoney2CN.number2String("1200403.547")); // 一百二十万零四百零三元五角四分七厘
        System.out.println(digitalMoney2CN.number2String("393123.045")); // 三十九万三千一百二十三元四分五厘
    }
}
