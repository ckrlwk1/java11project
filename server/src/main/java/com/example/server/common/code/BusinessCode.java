package com.example.server.common.code;
import org.springframework.http.HttpStatus;

import com.example.server.common.code.Code.CodeName;
import com.example.server.common.code.Code.ServiceError;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *  API 결과
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@NoArgsConstructor
@Data
public class BusinessCode {
	
	private ServiceError service;
	private HttpStatus id;
	private String code;
	private String message;
	private String link;
	private Object resultData;
	
	public BusinessCode(ServiceError service, CodeName codeName) {
		super();

		this.id = codeName.id;
		this.code = codeName.code;
		this.message = codeName.message;
		this.service = service;
	}

	public BusinessCode(ServiceError service, CodeName codeName, String message) {
		super();

		this.id = codeName.id;
		this.code = codeName.code;
		this.message = message;
		this.service = service;
	}
	
	public BusinessCode(ServiceError service, CodeName codeName, Object resultData) {
		super();

		this.id = codeName.id;
		this.code = codeName.code;
		this.message = codeName.message;
		this.service = service;
		this.resultData = resultData;
	}

	public BusinessCode(ServiceError service, CodeName codeName, Object resultData, String message) {
		super();
		this.id = codeName.id;
		this.code = codeName.code;
		this.message = message;
		this.service = service;
		this.resultData = resultData;
	}
}
