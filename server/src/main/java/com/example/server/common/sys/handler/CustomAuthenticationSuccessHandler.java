package com.example.server.common.sys.handler;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.server.common.sys.UserVo;
import com.example.server.common.util.RedisService;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	
	@Autowired
    private RedisService redisService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		System.out.println("successHandler.....");
		
		//session 세팅
		settingSessionAttributes(request);
		
		
		redisService.saveData("myKey", "Hello, Redis!");
		
		
		// 데이터 조회
        Object retrievedData = redisService.getData("myKey");
        System.out.println("Retrieved Data: " + retrievedData);
		
		
		//리다이렉트 진행
        response.sendRedirect("/main");
		
	}
		
	
	protected HttpSession settingSessionAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		UserVo userVo = null;
		
		if ( SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null ) {
			request.getSession(false).setMaxInactiveInterval(30*60); //15분*60초
			
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if ( principal instanceof UserVo )
				userVo = (UserVo)principal;
			
			Collection<? extends GrantedAuthority> authorities = userVo.getAuthorities();
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userVo, userVo.getUserPw(), authorities);
			
			SecurityContext context = SecurityContextHolder.getContext();
			context.setAuthentication(authToken);
			
			if(session!=null) {
				session.setAttribute("SPRING_SECURITY_CONTEXT", context);
				session.setAttribute("userInfo", SecurityContextHolder.getContext().getAuthentication().getPrincipal());				
			}
			
		}
		return session;
	}
		
}

