package com.example.server.common.sys.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.server.common.sys.UserVo;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private  UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        UserVo userVo = (UserVo) userDetailsService.loadUserByUsername(username);
        
        if (userVo == null || userVo.getAdminId() == null ) {
			throw new UsernameNotFoundException(username);
		}
        
        if( !passwordEncoder.matches(password, userVo.getAdminPw())) {			
	        throw new BadCredentialsException(username);
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority( "USER" ));
        return new UsernamePasswordAuthenticationToken(userVo, password, authorities);
    }

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

