/*
 * Copyright 2017 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

package com.example.demo.controller;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BaseResponse;

/**
 * 短信控制器
 *
 * @author chenzhao
 * @date 2017年12月5日 上午9:31:29
 */
@RestController
public class SmsController {

    public static final Logger  log          = LoggerFactory.getLogger(SmsController.class);

    private static final String MOBILE_REGEX = "^1[3|4|5|7|8][0-9]{9}$";

    @RequestMapping(method = RequestMethod.POST, path = "/sms/send")

    public BaseResponse send(@RequestBody String phoneNum, HttpServletRequest httpServletRequest) {
        log.info("接受到短信发送请求,{}", phoneNum);
        BaseResponse baseResponse = new BaseResponse();
        if (StringUtils.isBlank(phoneNum) || !isMobile(phoneNum)) {
            baseResponse.setCode("1");
            baseResponse.setMsg("请填写正确的手机号码");
            return baseResponse;
        }
        //设置超时时间-可自行调整
        //        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        //        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient需要的几个参数
        //        final String product = "";//短信API产品名称（短信产品名固定，无需修改）
        //        final String domain = "";//短信API产品域名（接口地址固定，无需修改）
        //替换成你的AK
        //        final String accessKeyId = "";//你的accessKeyId,参考本文档步骤2
        //        final String accessKeySecret = "";//你的accessKeySecret，参考本文档步骤2
        //初始化ascClient,暂时不支持多region（请勿修改）
        //        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);

        //        try {
        //            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        //
        //            IAcsClient acsClient = new DefaultAcsClient(profile);
        //            //组装请求对象
        //            SendSmsRequest request = new SendSmsRequest();
        //            //使用post提交
        //            request.setMethod(MethodType.POST);
        //            //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
        //            request.setPhoneNumbers("");
        //            //必填:短信签名-可在短信控制台中找到
        //            request.setSignName("");
        //            //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
        //            request.setTemplateCode("");
        //            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //            //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        //            request.setTemplateParam("{\"number\":\"" + phoneNum + "\"}");
        //            //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        //            //request.setSmsUpExtendCode("90997");
        //            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //            //request.setOutId("yourOutId");
        //            //请求失败这里会抛ClientException异常
        //
        //            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        //            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
        //                //请求成功
        //                baseResponse.setCode("0");
        //                baseResponse.setMsg("success");
        //            } else {
        //                log.error("短信服务返回,{}",sendSmsResponse.getMessage());
        //                baseResponse.setCode("1");
        //                baseResponse.setMsg("failure");
        //            }
        //        } catch (ServerException e) {
        //            baseResponse.setCode("1");
        //            baseResponse.setMsg("failure");
        //            log.error("短信发送失败,异常{}", e);
        //        } catch (ClientException e) {
        //            baseResponse.setCode("1");
        //            baseResponse.setMsg("failure");
        //            log.error("短信发送失败,异常{}", e);
        //        }
        baseResponse.setCode("0");
        baseResponse.setMsg("success");
        return baseResponse;

    }

    private static boolean isMobile(String mobile) {
        Pattern pattern = Pattern.compile(MOBILE_REGEX);
        return pattern.matcher(mobile).matches();

    }
}
