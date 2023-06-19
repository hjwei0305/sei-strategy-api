package com.domlin.strategy.enums;

/**
 * 实现功能：
 *
 * @author 作者[wake]
 * @version 1.0.00 2023-06-19 11:45
 */
public enum ChangeStyleEnum {

    CHANGE("1", "变更"),
    STOP("2", "终止"),
    ABANDON("3", "废弃");

    private final String code;

    private final String style;

    ChangeStyleEnum(String code, String style) {
        this.code = code;
        this.style = style;
    }

    public String getCode() {
        return code;
    }

    public String getStyle() {
        return style;
    }
}
