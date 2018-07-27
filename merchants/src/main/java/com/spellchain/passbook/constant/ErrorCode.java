package com.imooc.passbook.constant;

/**
 * <h2>错误码枚举类</h2>
 * @author jackson.yu
 * @version 1.0 2018年07月26日
 * @since 1.8
 */
public enum ErrorCode {

    SUCCESS(0, ""),
    DUPLICATE_NAME(1, "商户名称重复"),
    EMPTY_LOGO(2, "商户 logo 为空"),
    EMPTY_BUSINESS_LICENSE(3, "商户营业执照为空"),
    ERROR_PHONE(3, "商户联系电话错误"),
    EMPTY_ADDRESS(3, "商户地址为空"),
    MECHANTS_NOT_EXISTS(3, "商户不存在");

    /** 错误码 */
    private Integer code;
    /** 错误描述 */
    private String desc;

    /** 构造函数 */
    ErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }
}
