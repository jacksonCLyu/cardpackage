package com.spellchain.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>通用的响应对象</h1>
 * @author jackson.yu
 * @version 1.0 2018年07月27日
 * @since 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    /** 错误码，正确返回 0  */
    private Integer errorCode;

    /** 错误信息，正确返回字符串 */
    private String errorMsg;

    /** 返回值对象 */
    private Object data;

    /**
     * <h2>正确的响应构造函数</h2>
     * @param data 返回的值对象
     */
    public Response(Object data){
        this.data = data;
    }
}
