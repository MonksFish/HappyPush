package cn.monksfish.happypush.template;

import cn.monksfish.happypush.util.TemplateUtils;
import cn.monksfish.happypush.util.TimeUtils;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.regex.Matcher;

@Data
public class Timing {
    private String statement;
    private TimeUtils.TimingType timingType;

    @Override
    public String toString() {
        Matcher matcher = TemplateUtils.REGEX.matcher(statement);
        if (matcher.find()) {
            String dateStringMatched = matcher.group(0);
            String dateString = matcher.group(0).replace(TemplateUtils.PLACEHOLDER_LEFT, "")
                    .replace(TemplateUtils.PLACEHOLDER_RIGHT, "");
            LocalDateTime dateTime = LocalDateTime.parse(dateString, TimeUtils.DEFAULT_FORMATTER);
            String time = timingType.getFunctionConvert().apply(dateTime);
            statement = statement.replace(dateStringMatched, time);
        }
        return statement;
    }

    public static void main(String[] args) {
        String statement = "今天开学，距离放暑假那天已经过了${2022-08-31 12:00:10}了，好久不见！";
        Timing timing = new Timing();
        timing.setStatement(statement);
        timing.setTimingType(TimeUtils.TimingType.TIMING);
        System.out.println(timing);

        String statement2 = "今天放暑假，距离暑假结束还有${2022-11-31 12:00:10}，珍惜吧！";
        Timing timing2 = new Timing();
        timing2.setStatement(statement2);
        timing2.setTimingType(TimeUtils.TimingType.COUNT_DOWN);
        System.out.println(timing2);
    }
}
