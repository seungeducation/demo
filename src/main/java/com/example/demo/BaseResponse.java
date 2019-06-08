package com.example.demo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 返回基类
 * 
 * @author
 * @param <T>
 */
public class BaseResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6333627171476575637L;

    /**
     * 返回code
     */
    private String            code;

    /**
     * 返回code 描述
     */
    private String            msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
