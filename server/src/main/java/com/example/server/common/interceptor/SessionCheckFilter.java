package com.example.server.common.interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.server.common.sys.UserVo;

@Component
public class SessionCheckFilter extends OncePerRequestFilter {

	public Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		
		HttpSession session = request.getSession();
		UserVo userVo = (UserVo)session.getAttribute("userInfo");
		
		if(url.equals("/")) {
			if (userVo != null ) {
				response.sendRedirect("/main");
			} else {
				filterChain.doFilter(request, response);
			}
		} else {
			filterChain.doFilter(request, response);
		}
		
		

		
		
		
		
//        if (SecurityContextHolder.getContext().getAuthentication() != null) {
//            // 로그인 정보가 있는 경우 리디렉션
//            response.sendRedirect("/main"); // 리디렉션할 URL을 지정
//        } else {
//            filterChain.doFilter(request, response);
//        }
    }
	
}
