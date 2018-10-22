/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

package com.example.demo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author chenzhao
 * @date 2018年10月15日 下午6:38:54
 */
@Setter
@Getter
@ToString
public class ImgJsonLayout implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String            img;

    private String            url;

    private boolean           prob;

}
