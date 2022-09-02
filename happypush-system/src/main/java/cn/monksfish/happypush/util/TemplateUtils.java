package cn.monksfish.happypush.util;

import java.util.regex.Pattern;

public class TemplateUtils {
    public static final Pattern REGEX = Pattern.compile("\\$\\{[^}]+\\}");
    public static final String PLACEHOLDER_LEFT = "${";
    public static final String PLACEHOLDER_RIGHT = "}";
}
