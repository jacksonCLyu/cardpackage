package com.imooc.passbook.constant;

/**
 * 优惠券背景色枚举类
 * @author jackson.yu
 * @version 1.0 2018年07月26日
 * @since 1.8
 */
public enum TemplateColor {

    RED(1, "红色"),
    GREEN(2, "绿色"),
    BLUE(3, "蓝色");
    /** 颜色代码 */
    private Integer code;
    /** 颜色描述 */
    private String color;

    /** 构造函数 */
    TemplateColor(Integer code, String color) {
        this.code = code;
        this.color = color;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getColor(){
        return this.color;
    }
}
