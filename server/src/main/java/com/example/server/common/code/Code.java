package com.example.server.common.code;

import org.springframework.http.HttpStatus;

/**
 * API 에러 코드
 * @author Administrator
 *
 */
public class Code {
	public static String CODE_9002 = "9002";
	// 중복체크에러:부가서비스
	public static String CODE_9005 = "9005";
	public static String CODE_9006 = "9006";
	public static String CODE_9007 = "9007";
	public static String CODE_9008 = "9008";
	public static String CODE_9009 = "9009";
	// 상품
	public static String CODE_9010 = "9010";
	public static String CODE_9011 = "9011";
	public static String CODE_9012 = "9012";
	public static String CODE_9013 = "9013";
	// 상품 상태 및 재고
	public static String CODE_9050 = "9050";
	public static String CODE_9052 = "9052";
	
	public static String CODE_9900 = "9900";
	
	public static enum CodeName{
		SUCCESS(HttpStatus.OK , "200", "성공")
		,ERR_PARAM( HttpStatus.BAD_REQUEST , "9001", "파라미터가 에러가 발생하였습니다.")
		,ERR_INVALID_USER(HttpStatus.UNAUTHORIZED  , CODE_9002, "유효하지 않은 사용자입니다.") //401
		,ERR_LOGIN(HttpStatus.BAD_REQUEST  , "9003", "클라이언트 인증에 실패했습니다.다시 시도 바랍니다.") //401
		,ERR_NOT_FOUND(HttpStatus.NOT_FOUND  , "9004", "찾을 수 없는 정보입니다.")
		,ERR_CONFLICT(HttpStatus.CONFLICT  , CODE_9005, "사용하고 있는 내역이 존재합니다.")
		,ERR_FORBIDDEN(HttpStatus.FORBIDDEN  , CODE_9006, "불가능한 요청 상태입니다.")
		,ERR_SERVER(HttpStatus.INTERNAL_SERVER_ERROR , "9999", "서버 에러(Server error)");
		
		public HttpStatus id;
		public String code;
		public String message;
		
		CodeName(HttpStatus id, String code, String message) {
			this.id = id;
			this.code = code;
			this.message = message;
		}
	}
	
	
	public static enum ServiceError{
		COMMON("common")
		, USER("user")
		;
		
		public String service;
		
		ServiceError(String service ) {
			this.service = service;
		}
	}
}


