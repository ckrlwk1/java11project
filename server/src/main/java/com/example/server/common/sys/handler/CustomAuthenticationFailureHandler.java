package com.example.server.common.sys.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler  {
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException errorException) throws IOException, ServletException {
		
		 String errorMessage;
        if (errorException instanceof BadCredentialsException || errorException instanceof InternalAuthenticationServiceException){
            errorMessage="아이디 또는 비밀번호가 맞지 않습니다.";
        }else if (errorException instanceof UsernameNotFoundException){
            errorMessage="존재하지 않는 아이디 입니다.";
        } else {
        	errorMessage = "알 수 없는 이유로 로그인이 안되고 있습니다.";
        }
		
		System.out.println("-----------------------------------------fail");
		System.out.println(errorMessage);
		
		try {
			request.setAttribute("loginErrorMessage", errorMessage);
		} catch (Exception e) {
		}
		request.getRequestDispatcher("/").forward(request, response);
	}
}

