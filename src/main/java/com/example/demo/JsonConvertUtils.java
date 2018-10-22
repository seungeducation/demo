package com.example.demo;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json转换
 * 
 * @author songxibo 
 * @date 2018年1月30日 上午9:46:20
 */
public class JsonConvertUtils {
	
	public static final ObjectMapper mapper = new ObjectMapper();
	
	public static final ObjectMapper mapperIgnoreNull = new ObjectMapper();
	static{
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapperIgnoreNull.setSerializationInclusion(Include.NON_NULL);
	}

	public static String object2Json(Object obj){
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			return null;
		}
	}
	
	public static String object2Json(Object obj, boolean ignoreNull){
		try {
			if(ignoreNull) {
				return mapperIgnoreNull.writeValueAsString(obj);
			}else {
				return mapper.writeValueAsString(obj);
			}
		} catch (JsonProcessingException e) {
			return null;
		}
	}
	
	public static <T> T json2Object(String json, Class<? extends T> clas){
	    try {
			return mapper.readValue(json, clas);
		} catch (IOException e) {
			return null;
		} 
	}
	
	public static <T> T jsonParseObject(String json, Class<? extends T> cls) {
        
	    return JSON.parseObject(json, cls);
	    
	}

	public static <T> T parseObject(String json, Class<? extends T> cls) {

		return JSONObject.parseObject(json, cls);

	}
	
	public static <T> T json2Object(String json, Class<? extends T> clas, Class<?>... parameterClasses){
	    try {
			return mapper.readValue(json, getJavaType(clas, parameterClasses));
		} catch (IOException e) {
			return null;
		} 
	}
	
    public static JavaType getJavaType(Class<?> clas, Class<?>... parameterClasses) {   
        return mapper.getTypeFactory().constructParametricType(clas, parameterClasses);   
    }
    
    /**
     * 当JSON里只含有Bean的部分屬性時，更新一個已存在Bean，只覆蓋該部分的屬性.
     */
    public static void update(String jsonString, Object object) {
        try {
            mapper.readerForUpdating(object).readValue(jsonString);
        } catch (JsonProcessingException e) {
            //logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
        } catch (IOException e) {
            //logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
        }
    }
}
