package com.example.server.common.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.server.user.service.UserService;

@Component
public class MyUserDetailService implements UserDetailsService {
//    private final MemberService memberService;
//
//    @Autowired
//    public MyUserDetailService(MemberService memberService) {
//        this.memberService = memberService;
//    }
    
	@Autowired
	private UserService userService;
//    

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    	UserVo userVo = new UserVo();
    	userVo.setAdminId(userId);
    	userVo = userService.getUserInfo(userVo);
    	
    	if(userVo == null ) {
    		new UsernameNotFoundException("회원없음");
    	}
    	return userVo;
//        return User.builder()
//                .username(userVo.getUserid())
//                .password(userVo.getUserPw())
//                .roles(userVo.getUserRole())
//                .build();
    }
}
