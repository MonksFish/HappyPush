package cn.monksfish.happypush.plugin.util;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TimeUtils {

    public static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static LocalDateTime START = LocalDateTime.parse("2022-08-31 12:00:10", DEFAULT_FORMATTER);
    private static LocalDateTime TARGET = LocalDateTime.parse("2022-08-31 20:00:00", DEFAULT_FORMATTER);

    /**
     * 时间枚举-保存将要展示的时间单位粒度
     */
    @Getter
    @AllArgsConstructor
    public enum Time {
        DAY(Duration::toDays, (date, offset) -> date.plusDays(offset), "天"),
        HOUR(Duration::toHours, (date, offset) -> date.plusHours(offset), "小时"),
        MINUTE(Duration::toMinutes, (date, offset) -> date.plusMinutes(offset), "分钟"),
        SECOND(Duration::toSeconds, (date, offset) -> date.plusSeconds(offset), "秒"),
        MILLIS(Duration::toMillis, (date, offset) -> date.plusNanos(offset), "毫秒");

        public Function<Duration, Long> functionPeriod;//计算时间间隔
        public BiFunction<LocalDateTime, Long, LocalDateTime> functionAddition;//根据偏移量和给定的时间计算增加后的时间
        public String name;
    }

    /**
     * 计算指定时间还有多久到达
     *
     * @param target 指定时间-一般晚于现在
     * @return
     */
    public static String howLongArrive(LocalDateTime target) {
        return calTime(LocalDateTime.now(), target);
    }

    /**
     * 计算指定时间距离现在的时间间隔
     *
     * @param start 开始时间-一般早于现在
     * @return
     */
    public static String howLongTillNow(LocalDateTime start) {
        return calTime(start, LocalDateTime.now());
    }

    /**
     * 计算当前时间距离给定时间的差值，格式为时/分/秒/毫秒
     *
     * @param left  较小的时间
     * @param right 较大的时间
     */
    public static String calTime(LocalDateTime left, LocalDateTime right) {
        StringBuilder res = new StringBuilder();
        Duration duration;
        for (Time e : Time.values()) {
            duration = Duration.between(left, right);
            Long currentTimeUnit = e.getFunctionPeriod().apply(duration);
            left = e.getFunctionAddition().apply(left, currentTimeUnit);
            res.append(currentTimeUnit).append(e.getName());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(howLongTillNow(START));
        System.out.println(howLongArrive(TARGET));
    }
}
