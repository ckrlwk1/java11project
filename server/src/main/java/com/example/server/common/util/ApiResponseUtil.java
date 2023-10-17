package com.example.server.common.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.server.common.code.BusinessCode;

@Component
public class ApiResponseUtil {

	
	/**
	 * 성공(리스트 등)
	 * 
	 * @param str
	 * @param obj
	 * @return
	 */
	public static ResponseEntity<?> getOkResponseEntity(String str, Object obj) throws Exception {
		
		if(!StringUtils.isEmpty(str)) {
			Map<String, Object> bodyMap = new HashMap<String, Object>();
			bodyMap.put(str, obj);
			return new ResponseEntity<Object>(bodyMap, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
	}

	
	
	/**
	 * 응답
	 * 
	 * @param str
	 * @param httpStatus
	 * @param obj
	 * @return
	 */
	public static ResponseEntity<?> getResponseEntity(String str, HttpStatus httpStatus, Object obj) throws Exception {
		
		if(!StringUtils.isEmpty(str)) {
			Map<String, Object> bodyMap = new HashMap<String, Object>();
			bodyMap.put(str, obj);
			return new ResponseEntity<Object>(bodyMap, httpStatus);
		} else {
			return new ResponseEntity<Object>(obj, httpStatus);
		}
	}
	
	public static ResponseEntity<?> getResponseEntity(BusinessCode svcWebOrderInfo) {
		return new ResponseEntity<Object>(svcWebOrderInfo, svcWebOrderInfo.getId());
	}
	
	

}